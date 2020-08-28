package microservice.uaa.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import microservice.uaa.model.Permission;
import microservice.uaa.model.User;
import microservice.uaa.model.UserDTO;
import microservice.uaa.security.TokenUtils;



// Primer kontrolera cijim metodama mogu pristupiti samo autorizovani korisnici
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	
	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	private String serviceUrl = "http://localhost:8184/api/delete-ad/user";

	@GetMapping("/user/{userId}")
	public User loadById(@PathVariable Long userId) {
		return this.userService.findById(userId);
	}

	@GetMapping("/user/all")
	public List<UserDTO> loadAll() {
		List<UserDTO> res = new ArrayList<>();
		
		for( User u :this.userService.findAll())
		{
			res.add(new UserDTO(u));
		}
		return res;
	}
	
	@PutMapping("/user/update")
	public List<User> updateUser(@RequestBody UserDTO update) {
		User target = userService.findById(update.getId());
		target.setEmail(update.getEmail());
		target.setUsername(update.getUsername());
		userService.save(target);
	
		return userService.findAll(); 
	}

	@DeleteMapping("/user/{id}")
	public List<User> deleteeUser(@RequestHeader("Authorization") String header,@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", header );
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(serviceUrl + "/" + id, HttpMethod.DELETE, entity , void.class);
		
		userService.removeUser(id);	
		
		return userService.findAll(); 
	}
	
	@GetMapping("/whoami")
	public User user(@RequestHeader("Authorization") String header) {

		String[] divider = header.split(" ");
		String token;
		if(divider.length > 1)
			token = divider[1];
		else
			token = divider[0];
		String username = this.tokenUtils.getUsernameFromToken(token);
		return (User) this.userDetailsService.loadUserByUsername(username);
		
	}
	
	@GetMapping(value= "/user/{id}/permissions")
		Permission getUsersPermissionConfigs(@PathVariable Long id) {
		Permission perm = new Permission();
		User target = userService.findById(id);
		perm.setCanLog(target.isCanLoggin());
		perm.setCanPost(target.isCanPost());
		return perm;
	}
	
	@PutMapping(value = "/user/block")
	List<UserDTO> block(@RequestBody Long id){
		
		userService.blockUser(id);
		List<UserDTO> res = new ArrayList<>();
		for( User u :this.userService.findAll())
		{
			res.add(new UserDTO(u));
		}
		return res;	
		
	}
	@PutMapping(value ="/user/{id}/update-permissions")
	void updatePermisionToLog(@PathVariable Long id, @RequestBody Permission state) {
		User target = userService.findById(id);
		target.setCanLoggin(state.getCanLog());
		target.setCanPost(state.getCanPost());
		userService.save(target);
	}
	
	
	@PutMapping(value = "/user/activate")
	List<UserDTO> activek(@RequestBody Long id){
		
		userService.activateUser(id);
		List<UserDTO> res = new ArrayList<>();
		for( User u :this.userService.findAll())
		{
			res.add(new UserDTO(u));
		}
		return res;	
		
	}

	
}

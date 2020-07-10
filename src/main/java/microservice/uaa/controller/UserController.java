package microservice.uaa.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

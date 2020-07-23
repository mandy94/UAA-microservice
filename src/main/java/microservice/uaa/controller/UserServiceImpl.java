package microservice.uaa.controller;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import microservice.uaa.model.Authority;
import microservice.uaa.model.User;
import microservice.uaa.model.UserRequest;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthorityService authService;

	
	@Override
	public User findByUsername(String username) {
		User u = userRepository.findByUsername(username);
		return u;
	}

	public User findById(Long id) {
		User u = userRepository.findById(id).orElseGet(null);
		return u;
	}

	public List<User> findAll() {
		List<User> result = userRepository.findAllByOrderByIdAsc();
		return result;
	}

	@Override
	public User save(UserRequest userRequest) {
		User u = new User();
		u.setUsername(userRequest.getUsername());
		// pre nego sto postavimo lozinku u atribut hesiramo je
		u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		u.setFirstName(userRequest.getFirstname());
		u.setLastName(userRequest.getLastname());
		u.setEnabled(true);
		
		List<Authority> auth = authService.findByname("ROLE_USER");
		// u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
		u.setAuthorities(auth);
		
		u = this.userRepository.save(u);
		return u;
	}

	@Override
	public void blockUser(Long id) {
		User u  = userRepository.findById(id).orElse(null);
		u.setStatus("BLOCK");
		u.setEnabled(false);
		userRepository.save(u);
		
	}

	@Override
	public void activateUser(Long id) {
		User u  = userRepository.findById(id).orElse(null);
		u.setStatus("ACTIVE");
		u.setEnabled(true);
		userRepository.save(u);
		
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}

	@Override
	public void removeUser(Long id) {
		
		
		userRepository.deleteById(id);
		
	}


}

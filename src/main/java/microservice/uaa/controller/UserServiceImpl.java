package microservice.uaa.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
		List<User> result = userRepository.findAll();
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


}

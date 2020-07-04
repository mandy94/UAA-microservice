package microservice.uaa.controller;
import java.util.List;

import microservice.uaa.model.User;
import microservice.uaa.model.UserRequest;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
	User save(UserRequest userRequest);
}

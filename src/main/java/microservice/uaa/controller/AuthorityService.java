package microservice.uaa.controller;
import java.util.List;

import microservice.uaa.model.Authority;

public interface AuthorityService {
	List<Authority> findById(Long id);
	List<Authority> findByname(String name);
}

package microservice.uaa.controller;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import microservice.uaa.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	Authority findByName(String name);
}

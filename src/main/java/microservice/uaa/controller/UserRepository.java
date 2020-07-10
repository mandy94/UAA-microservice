package microservice.uaa.controller;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import microservice.uaa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username );


	List<User> findAllByOrderByIdAsc();
}


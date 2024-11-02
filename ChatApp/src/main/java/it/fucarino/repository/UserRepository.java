package it.fucarino.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.fucarino.model.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer > {

	Optional<User> findByUsername(String username);
	
}

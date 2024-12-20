package it.fucarino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.fucarino.model.Role;
import java.util.List;


public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findByName(String username);
	
}

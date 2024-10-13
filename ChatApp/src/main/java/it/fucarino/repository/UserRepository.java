package it.fucarino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.fucarino.model.User;

public interface UserRepository extends JpaRepository<User, Integer > {

}
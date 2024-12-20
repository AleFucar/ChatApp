package it.fucarino.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import it.fucarino.model.User;
import it.fucarino.repository.UserRepository;

public class DatabaseUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user  = userRepository.findByUsername(username);
		
		if (user.isPresent()) {
			return new DatabaseUserDetails(user.get());
		}else {
			throw new UsernameNotFoundException("Username non trovato");
		}
	}

}

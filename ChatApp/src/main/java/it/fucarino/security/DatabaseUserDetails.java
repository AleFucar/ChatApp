package it.fucarino.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import it.fucarino.model.Role;
import it.fucarino.model.User;
import it.fucarino.repository.UserRepository;

public class DatabaseUserDetails implements UserDetails {

	@Autowired UserRepository userRepository;
	
	private final Integer id;
	private final String username;
	private final String mail;
	private final String password;
	private final Set<GrantedAuthority> grantedAuthorities;
	
	public DatabaseUserDetails(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.mail = user.getMail();
		this.password = user.getPassword();
		this.grantedAuthorities = new HashSet<>();
		for (Role role : user.getRoles()) {
			this.grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

}

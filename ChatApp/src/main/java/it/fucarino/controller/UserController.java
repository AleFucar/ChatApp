package it.fucarino.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.fucarino.model.Role;
import it.fucarino.model.User;
import it.fucarino.repository.RoleRepository;
import it.fucarino.repository.UserRepository;


@Controller
@RequestMapping
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	
	
	@GetMapping("/index")
	public String getUser(Model model) {
		
		List<User> user = userRepository.findAll();
		model.addAttribute("user", user);
		
		return "/index";
	}
	
	
	
	@GetMapping("/create")
	public String createUser(Model model){
		User user = new User();		
		model.addAttribute("user", user );
		user.setDataCreazione(LocalDateTime.now());
		return"/user/create";
	}
	
	
	
	@PostMapping("/create")
	public String postCreateUser(@ModelAttribute("user") User userForm, Model model, BindingResult bindingResult) {
        
		String encodePassword = passwordEncoder.encode(userForm.getPassword());
		userForm.setPassword(encodePassword);
		
        Role userRole = roleRepository.findByName("USER");
        if (userRole == null) {
            userRole = new Role();
            userRole.setName("USER");
            roleRepository.save(userRole);
        }
        
        // Aggiungi il ruolo "USER" alla lista dei ruoli dell'utente
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        userForm.setRoles(roles);
        
        
        
        userRepository.save(userForm);
		return "redirect:/index";
	}
	
	
	
	
	
}

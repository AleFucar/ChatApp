package it.fucarino.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.fucarino.model.User;
import it.fucarino.repository.UserRepository;


@Controller
@RequestMapping
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	
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
	public String postCreateUser(@ModelAttribute("user") User userForm, Model model) {
			
		userRepository.save(userForm);
		
		return "redirect:/index";
	}
	
	
	
	
	
}

package it.fucarino.controller;

import java.awt.print.Printable;
import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.fucarino.model.Message;
import it.fucarino.model.User;
import it.fucarino.repository.ChatRepository;
import it.fucarino.repository.MessageRepository;
import it.fucarino.repository.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping
public class ChatController {
	
	@Autowired 
	private ChatRepository chatRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	
	@GetMapping("/index/{id}")
	public String getSingleChat(@PathVariable("id") Integer id, Model model) {
		
		// Lista utenti cliccabili //
		List<User> user = userRepository.findAll();
		model.addAttribute("user", user);
		model.addAttribute("id", id);
		model.addAttribute("userById", userRepository.getReferenceById(id));

		return "/index";
	}
	
	
	
}

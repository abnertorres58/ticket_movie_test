package com.fdmgroup.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdmgroup.entities.User;
import com.fdmgroup.repositories.UserRepository;

@Controller
//RequestMapping(path="/")
public class MainController {
	
	@Autowired
	private UserRepository userRepository;
	
    @GetMapping("/login")
    public String greeting(Model model) {
        model.addAttribute("name", "Laura");
        return "login";
    }
    
    @PostMapping("/login")
    public String loginPost(@RequestParam String email, @RequestParam String password, Model model) {
        model.addAttribute("name", "Laura");
    	List<User> users = userRepository.findByEmail(email);
    	
    	// if didnt found or password incorrect
    	if(users.size()==0 || !users.get(0).getPassword().equals(password)) {
    		model.addAttribute("error", "Invalid Credentials");
    		return "login";
    	}
    	// check if
    	return "redirect:movies";
    }
    
    
	

}

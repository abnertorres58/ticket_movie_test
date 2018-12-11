package com.fdmgroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdmgroup.entities.Movie;
import com.fdmgroup.repositories.MovieRepository;

@Controller
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	
//	@GetMapping(path="/add")
//	public @ResponseBody String addNewMovie (@RequestParam String title) {
//		
//		Movie m = new Movie();
//		m.setTitle(title);
//		movieRepository.save(m);
//		return "Saved";
//	}
//	
//	@GetMapping(path="/all")
//	public @ResponseBody Iterable<Movie> getAllùMovies(){
//		return movieRepository.findAll();		
//	}
	
	@GetMapping(path="/movies")
	public String moviePost() {
		return "movies";
	}
	
}

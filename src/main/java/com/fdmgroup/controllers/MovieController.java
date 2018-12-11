package com.fdmgroup.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdmgroup.entities.Movie;
import com.fdmgroup.entities.Rental;
import com.fdmgroup.repositories.MovieRepository;
import com.fdmgroup.repositories.RentalRepository;

@Controller
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private RentalRepository rentalRepository;
	
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
	public String moviePost(Model model) {
		Iterable<Movie> allMovies = movieRepository.findAll();
		model.addAttribute("allMovies", allMovies);
		return "movies";
	}
	
	@PostMapping(path="/rent")
	public String movieRent(@RequestParam int movie_id, Model model) {
		Rental r = new Rental();
		r.setMovie_id(movie_id);
		r.setUser_id(1);
		rentalRepository.save(r);
		
		return "redirect:rentals";
	}
	
	@GetMapping(path="/rentals")
	public String movieRentals(Model model) {
		Iterable<Movie> allMovies = movieRepository.findAll();
		model.addAttribute("allMovies", allMovies);
		return "movies";
	}
}

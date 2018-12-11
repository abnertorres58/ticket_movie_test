package com.fdmgroup.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdmgroup.entities.Movie;
import com.fdmgroup.entities.Rental;
import com.fdmgroup.entities.User;
import com.fdmgroup.repositories.MovieRepository;
import com.fdmgroup.repositories.RentalRepository;

@Controller
public class MovieController {
	
	@Autowired
	private MainController mainController;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private RentalRepository rentalRepository;

	// set the currentUser attribute available to all views
	@ModelAttribute("currentUser")
	public User getCurrentUser() {
	   return mainController.getCurrentUser();
	}
	
	@GetMapping(path="/movies")
	public String moviePost(Model model) {
		Iterable<Movie> allMovies = movieRepository.findAll();
		model.addAttribute("allMovies", allMovies);
		return "movies";
	}
	
	@PostMapping(path="/rent")
	public String movieRent(@RequestParam int movie_id, Model model) {
		Rental r = new Rental();
		Optional<Movie> m = movieRepository.findById(movie_id);
		r.setMovie(m.get());
		r.setUserId(this.mainController.getCurrentUser().getId());
		rentalRepository.save(r);
		
		return "redirect:rentals";
	}
	
	@GetMapping(path="/rentals")
	public String movieRentals(Model model) {
		List<Rental> myRendedMovies = rentalRepository.findByUserId(this.mainController.getCurrentUser().getId());
		model.addAttribute("allRentals", myRendedMovies);
		return "rentals";
	}
	
	@PostMapping(path="/return")
	public String movieReturn(@RequestParam int rentalId, Model model) {
		//rentalRepository.deleteByMovieIdAndUserId(movieId, this.mainController.getCurrentUser().getId());
		rentalRepository.deleteById(rentalId);
		return "redirect:rentals";
	}
}
	
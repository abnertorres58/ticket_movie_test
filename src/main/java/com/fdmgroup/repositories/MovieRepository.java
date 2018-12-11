package com.fdmgroup.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.fdmgroup.entities.Movie;


public interface MovieRepository extends CrudRepository<Movie, Integer>{
	List<Movie> findByTitle(String title);
	
}
	


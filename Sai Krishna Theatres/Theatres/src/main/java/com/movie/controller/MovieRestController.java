package com.movie.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.Exception.NoDataFoundException;
import com.movie.entity.TheatreDetails;
import com.movie.service.MovieServiceInterface;
@RestController
@RequestMapping("/movie")
@CrossOrigin("http://localhost:4200")
public class MovieRestController {
	@Autowired
	MovieServiceInterface service;
	
	@PostMapping("/add_theatres")
	public ResponseEntity<TheatreDetails> addTheatres(@PathVariable("theatre") TheatreDetails theatre) {
		/*Display Theatres based on the city selected*/
		TheatreDetails result=service.addTheatres(theatre);
			return new ResponseEntity<TheatreDetails>(result,HttpStatus.OK);
	}
	
	@GetMapping("/display_theatres")
	public ResponseEntity<List<TheatreDetails>> displayTheatres() throws NoDataFoundException{
		/*Display Theatres based on the city selected*/
		List<TheatreDetails> result=service.displayTheatres();
		if(result.isEmpty())
			throw new NoDataFoundException("NO THEATRES AVAILABLE");
		else
			return new ResponseEntity<List<TheatreDetails>>(result,HttpStatus.OK);
	}
	}

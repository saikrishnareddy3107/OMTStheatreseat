package com.movie.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entity.TheatreDetails;
import com.movie.repository.TheatreRepository;

@Service

public class MovieServiceImplementation implements MovieServiceInterface {

	@Autowired
	TheatreRepository trepo;

	@Override
	public List<TheatreDetails> displayTheatres() {
		// TODO Auto-generated method stub
		return trepo.displayTheatres();
	}

	@Override
	public TheatreDetails addTheatres(TheatreDetails theatre) {
		
		// TODO Auto-generated method stub
				TheatreDetails result=trepo.save(theatre);
				return result;
	}

	@Override
	public TheatreDetails deleteTheatres(String theatrename) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
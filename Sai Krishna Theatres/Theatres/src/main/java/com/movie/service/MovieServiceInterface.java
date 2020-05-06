package com.movie.service;


import java.util.List;

import com.movie.entity.TheatreDetails;

public interface MovieServiceInterface {


	List<TheatreDetails> displayTheatres();

	TheatreDetails addTheatres(TheatreDetails theatre);

	TheatreDetails deleteTheatres(String theatrename);

}

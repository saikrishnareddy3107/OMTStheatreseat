package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movie.entity.TheatreDetails;

public interface TheatreRepository extends JpaRepository<TheatreDetails, Integer>{

	@Query(value="select * from theatre_info",nativeQuery=true)
	List<TheatreDetails> displayTheatres();

}

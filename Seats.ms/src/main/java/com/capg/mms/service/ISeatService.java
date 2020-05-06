package com.capg.mms.service;

import java.util.List;

import com.capg.mms.model.Seat;

public interface ISeatService {

	
	Seat addSeat (Seat seat);
	
	//Boolean deleteSeatById (int seatId);
	
	List<Seat> getAvailableSeats();
	
	 public List<Seat> bookSeats(List<Integer> seatIds);
	
	 public List<Seat> blockSeats(List<Integer> seatId);
	
	 public List<Seat> cancelSeats(List<Integer> seatId);
	
}

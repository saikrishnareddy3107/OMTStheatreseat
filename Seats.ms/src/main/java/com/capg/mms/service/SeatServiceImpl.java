package com.capg.mms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.mms.exceptions.SeatAlreadyExistException;
import com.capg.mms.exceptions.SeatException;
import com.capg.mms.exceptions.SeatNotFoundException;
import com.capg.mms.model.Seat;
import com.capg.mms.model.SeatStatus;

import com.capg.mms.repository.ISeatRepository;

@Service
public class SeatServiceImpl implements ISeatService {

	@Autowired
	ISeatRepository seatRepo;
	private Seat bookseat1;

	/********************************************
	 * ADD SEATS
	 ***************************************************/
	@Override
	@Transactional
	public Seat addSeat(Seat seat) {
		if (seatRepo.existsById(seat.getSeatId())) {
			throw new SeatAlreadyExistException("Seat already exists");
		}
		return seatRepo.save(seat);
	}

	/*******************************************
	 * DELLETE SEATS
	 ************************************************/

//	@Override
//	public Boolean deleteSeatById(int seatId) {
//		
//		if( seatrepo.existsById(seatId))
//		{
//			
//			seatrepo.deleteById(seatId);
//		}
//		return true;
//	}

	/************************************************
	 * AVAILABLE SEATS
	 *********************************************/
	@Override
	public List<Seat> getAvailableSeats() {

		return seatRepo.getAvailableSeats(SeatStatus.AVAILABLE);
	}

	/***************************************************BOOK SEAT***************************************************/
	

	 @Override
	 @Transactional
	 public List<Seat> bookSeats(List<Integer> seatIds) {
		 List<Seat> seatList=new ArrayList<>();
		 for(int seatId:seatIds) {
		if(seatRepo.existsById(seatId)) {
			 Seat bookseat= seatRepo.getOne(seatId);
			if(bookseat.getSeatStatus()==SeatStatus.AVAILABLE) {
				bookseat.setSeatStatus(SeatStatus.BOOKED);
				seatList.add(bookseat);
			}
		}
		 }
		
		 return seatRepo.saveAll(seatList);
		 }
		/*******************************************************
		 * BLOCK SEAT
		 **********************************************/

	 @Override
		public List<Seat> blockSeats(List<Integer> seatIds) {
			List<Seat> seatList=new ArrayList<>();
			for(int seatId:seatIds) {
				
			if (seatRepo.existsById(seatId)) {
				Seat bookseat = seatRepo.getOne(seatId);
				if (bookseat.getSeatStatus() == SeatStatus.AVAILABLE) {
					bookseat.setSeatStatus(SeatStatus.BLOCKED);
					seatList.add(bookseat);
				}
			}

			}

			return seatRepo.saveAll(seatList);
		}

	 
	 
	 /********************CANCEL SEATS*************************/
		@Override
		public 	List<Seat> cancelSeats(List<Integer> seatIds) {
			List<Seat> seatList=new ArrayList<>();
			for(int seatId:seatIds) {
			if (seatRepo.existsById(seatId)) {
				Seat bookseat = seatRepo.getOne(seatId);
				if (bookseat.getSeatStatus() == SeatStatus.BOOKED) {
					bookseat.setSeatStatus(SeatStatus.AVAILABLE);
					seatList.add(bookseat);
				}
				}
			}

			  return seatRepo.saveAll(seatList);
		}

	}

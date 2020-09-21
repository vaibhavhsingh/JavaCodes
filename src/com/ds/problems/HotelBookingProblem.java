package com.ds.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Find if k bookings possible with given arrival and departure times
 * 
 * A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. 
 * Bookings contain an arrival date and a departure date. 
 * He wants to find out whether there are enough rooms in the hotel to satisfy the demand.
 * 
 * Input :  Arrivals :   [1 3 5]
 *        Departures : [2 6 8]
 *        K: 1
 *        
 * https://medium.com/solvingalgo/solving-algorithmic-problems-possible-hotel-bookings-fa3a544c6683
 * 
 * @author vaibhavsingh
 *
 */
public class HotelBookingProblem {

	public boolean isAllHotelBookingsPossible(List<Integer> arrival, List<Integer> departure, int k) {
		int n = arrival.size();
		int arrivalIndex = 0;
		int departureIndex = 0;
		Collections.sort(arrival);
		Collections.sort(departure);
		int count = 0;
		
		while(arrivalIndex < n && departureIndex < n) {
			if(arrival.get(arrivalIndex) < departure.get(departureIndex)) {
				arrivalIndex++;
				count++;
				
				if(count > k) {
					return false;
				}
			} else {
				departureIndex++;
				count--;
			}
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		HotelBookingProblem hotelBooking = new HotelBookingProblem();
		List<Integer> arrival = Arrays.asList(1, 4, 10, 12);
		List<Integer> departure = Arrays.asList(3, 5, 11, 13);
		int k=3;
		System.out.println(hotelBooking.isAllHotelBookingsPossible(arrival, departure, k));
		
		List<Integer> arrival1 = Arrays.asList(1, 4, 5, 6, 8, 9);
		List<Integer> departure1 = Arrays.asList(5, 5, 11, 7, 12, 11);
		int k1=3;
		System.out.println(hotelBooking.isAllHotelBookingsPossible(arrival1, departure1, k1));
	}
}

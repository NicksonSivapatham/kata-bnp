package com.nickson.vehicle;

import com.nickson.map.Plan2D;
import com.nickson.vehicle.exception.InvalidItinerary;
import com.nickson.vehicle.exception.InvalidPosition;

public interface Vehicle {
	
	/**
	 * The vehicle navigate following the given itinerary on a given plan
	 * @param itinerary
	 * @param plan
	 * @throws InvalidItinerary If the vehicle is not capable to execute the itinerary
	 * @throws InvalidPosition If the vehicle is conduct to an invalid position 
	 */
	public void navigate(String itinerary, Plan2D plan) throws InvalidItinerary, InvalidPosition;
}

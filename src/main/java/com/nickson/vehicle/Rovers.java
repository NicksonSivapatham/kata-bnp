package com.nickson.vehicle;

import com.nickson.map.Coordinate2D;
import com.nickson.map.Orientation;
import com.nickson.map.Plan2D;
import com.nickson.vehicle.exception.InvalidItinerary;
import com.nickson.vehicle.exception.InvalidPosition;

public class Rovers implements Vehicle{
	
	public static enum movement {L,M,R}
	
	private Coordinate2D coordinate;

	public Coordinate2D getCoordinate() {
		return coordinate;
	}

	@Override
	public void navigate(String itinerary, Plan2D plan) throws InvalidItinerary, InvalidPosition {
		// TODO Auto-generated method stub
		
	}
	
	public Orientation turnLeft(Orientation orientation) {
		return orientation;
	}
	
	public Orientation turnRight(Orientation orientation) {
		return orientation;
	}
	
	public Coordinate2D move(Coordinate2D coordinate) {
		return coordinate;
	}
	
	public Boolean verifyItinerary(String itinerary) {
		return false;
	}
}

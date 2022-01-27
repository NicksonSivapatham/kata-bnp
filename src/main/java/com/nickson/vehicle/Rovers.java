package com.nickson.vehicle;

import com.nickson.map.Coordinate2D;
import com.nickson.map.Orientation;
import com.nickson.map.Plan2D;
import com.nickson.vehicle.exception.InvalidItinerary;
import com.nickson.vehicle.exception.InvalidPosition;

public class Rovers implements Vehicle{

	public static enum movement {L,M,R}
	
	private Coordinate2D coordinate;

	public Rovers(Coordinate2D coordinate) {
		super();
		this.coordinate = coordinate;
	}
	
	public Coordinate2D getCoordinate() {
		return coordinate;
	}

	@Override
	public void navigate(String itinerary, Plan2D plan) throws InvalidItinerary, InvalidPosition {
		// TODO Auto-generated method stub
		
	}
	
	public Orientation turnLeft() {
		Integer leftOrientationOrder = Math.floorMod(coordinate.getOrientation().getOrder() - 1, 4);
		return Orientation.fromOrder(leftOrientationOrder);
	}
	
	public Orientation turnRight() {
		return coordinate.getOrientation();
	}
	
	public Coordinate2D move(Plan2D plan) throws InvalidPosition{
		return coordinate;
	}
	
	public Boolean verifyItinerary(String itinerary) {
		return false;
	}
}

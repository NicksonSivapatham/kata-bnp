package com.nickson.map;

import com.nickson.map.exception.InvalidPositionException;

public interface Plan2D {
	
	public void verifyCoordinate(Coordinate2D coodinate) throws InvalidPositionException;
	
}

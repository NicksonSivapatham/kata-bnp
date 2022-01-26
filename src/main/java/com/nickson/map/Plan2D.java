package com.nickson.map;


public interface Plan2D {
	
	/**
	 * Verify if the given coordinate exist on the plan
	 * @param coodinate
	 * @return true if the coodinate exist false otherwise 
	 */
	public Boolean verifyCoordinate(Coordinate2D coodinate);
	
}

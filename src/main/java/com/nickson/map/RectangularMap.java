package com.nickson.map;

import com.nickson.map.exception.InvalidPositionException;

public class RectangularMap implements Plan2D {
	
	private Long xSize;
	private Long ySize;
	
	public RectangularMap (Long xSize, Long ySize) {
		super();
		this.xSize = xSize;
		this.ySize = ySize;
	}

	@Override
	public void verifyCoordinate(Coordinate2D coordinate) throws InvalidPositionException {
		// TODO Auto-generated method stub
	}
	
}

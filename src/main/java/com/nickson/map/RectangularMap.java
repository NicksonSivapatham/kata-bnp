package com.nickson.map;

public class RectangularMap implements Plan2D {
	
	private Long xSize;
	private Long ySize;
	
	public RectangularMap (Long xSize, Long ySize) {
		super();
		this.xSize = xSize;
		this.ySize = ySize;
	}
	
	public Long getxSize() {
		return xSize;
	}


	public Long getySize() {
		return ySize;
	}

	@Override
	public Boolean verifyCoordinate(Coordinate2D coordinate) {
		return null;
	}
	
}

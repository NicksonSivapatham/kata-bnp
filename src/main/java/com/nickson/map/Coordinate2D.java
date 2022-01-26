package com.nickson.map;

public class Coordinate2D {
	
	private Long x;
	private Long y;
	private Orientation orientation;
	
	public Coordinate2D(Long x, Long y, Orientation orientation) {
		super();
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}
	
	public Long getX() {
		return x;
	}
	public Long getY() {
		return y;
	}
	public Orientation getOrientation() {
		return orientation;
	}
}

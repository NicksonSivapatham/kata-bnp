package com.nickson.map;

public enum Orientation {

	NORTH("N", 0),
	EST("E", 1),
	SOUTH("S", 2),
	WEST("W", 3);
		
	private String  direction;
	private Integer order;
	

	public String getDirection() {
		return this.direction;
	}

	public Integer getOrder() {
		return this.order;
	}	
	
	Orientation(String direction, Integer order) {
		this.direction = direction;
		this.order = order;
	}

	public static Orientation fromString(String direction) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Orientation fromOrder(Integer order) {
		// TODO Auto-generated method stub
		return null;
	}
}

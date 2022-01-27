package com.nickson.map;

import java.util.Objects;

public class Coordinate2D {
	
	private Long x;
	private Long y;
	private Orientation orientation;
	
	public Coordinate2D(Long x, Long y, Orientation orientation) {
		super();
		this.x = x == null || x < 0 ? 0 : x;
		this.y = y == null || y < 0 ? 0 : y;
		this.orientation = orientation;
		this.orientation = orientation == null ? Orientation.NORTH : orientation;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(orientation, x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate2D other = (Coordinate2D) obj;
		return orientation == other.orientation && Objects.equals(x, other.x) && Objects.equals(y, other.y);
	}
}

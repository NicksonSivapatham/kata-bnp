package com.nickson.map;

import java.util.Objects;

public class RectangularMap implements Plan2D {
	
	private Long xSize;
	private Long ySize;
	
	public RectangularMap (Long xSize, Long ySize) {
		super();
		this.xSize = xSize == null || xSize < 0 ? 0 : xSize;
		this.ySize = ySize == null || ySize < 0 ? 0 : ySize;
	}
	
	public Long getxSize() {
		return xSize;
	}


	public Long getySize() {
		return ySize;
	}

	@Override
	public Boolean verifyCoordinate(Coordinate2D coordinate) {
		return coordinate.getX() < this.xSize && coordinate.getY() < this.ySize 
				&& coordinate.getX() >= 0 && coordinate.getY() >= 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(xSize, ySize);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RectangularMap other = (RectangularMap) obj;
		return Objects.equals(xSize, other.xSize) && Objects.equals(ySize, other.ySize);
	}
	
}

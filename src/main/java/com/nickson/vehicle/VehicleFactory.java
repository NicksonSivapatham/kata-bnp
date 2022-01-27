package com.nickson.vehicle;

import com.nickson.map.Coordinate2D;
import com.nickson.map.Orientation;

public class VehicleFactory {
	public static Rovers getRovers(String infos) {
		String[] splitInfos =  infos.split(" ");
		Long x;
		Long y;
		Orientation orientation;
		
		try {
			x = Long.valueOf(splitInfos[0]);
			y = Long.valueOf(splitInfos[1]);
			orientation = Orientation.fromString(splitInfos[2]);
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Given infos can't produce a rovers: " + infos, e);
		}

		Coordinate2D coordinate = new Coordinate2D(x, y, orientation);
		return new Rovers(coordinate); 
	}
}

package com.nickson.vehicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nickson.map.Coordinate2D;
import com.nickson.map.Orientation;

public class VehicleFactory {
	
	private static Logger logger = LoggerFactory.getLogger(VehicleFactory.class);
			
	public static Rovers getRovers(String infos) {
		logger.info("Creating rover with infos: "+ infos);
		String[] splitInfos =  infos.split(" ");
		Long x;
		Long y;
		Orientation orientation;
		
		try {
			x = Long.valueOf(splitInfos[0]);
			y = Long.valueOf(splitInfos[1]);
			orientation = Orientation.fromString(splitInfos[2]);
		} catch(IllegalArgumentException e) {
			logger.error("Given infos can't produce a rovers: " + infos);
			throw new IllegalArgumentException("Given infos can't produce a rovers: " + infos, e);
		}

		Coordinate2D coordinate = new Coordinate2D(x, y, orientation);
		return new Rovers(coordinate); 
	}
}

package com.nickson.map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Plan2DFactory {
	
	private static Logger logger = LoggerFactory.getLogger(Plan2DFactory.class);
	
	public static RectangularMap getRectangularMap(String infos) {
		logger.info("Creating rectangular map with infos: "+ infos);
		String[] splitInfos =  infos.split(" ");
		Long sizeX;
		Long sizeY;
		try {
			sizeX = Long.valueOf(splitInfos[0]);
			sizeY = Long.valueOf(splitInfos[1]);
		} catch(NumberFormatException e) {
			logger.error("Given infos can't produce a rectangular map: " + infos);
			throw new IllegalArgumentException("Given infos can't produce a rectangular map: " + infos, e);
		}
		
		return new RectangularMap(sizeX, sizeY); 
	}
}

package com.nickson.map;

public class Plan2DFactory {
	
	public static RectangularMap getRectangularMap(String infos) {
		String[] splitInfos =  infos.split(" ");
		Long sizeX;
		Long sizeY;
		try {
			sizeX = Long.valueOf(splitInfos[0]);
			sizeY = Long.valueOf(splitInfos[1]);
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException("Given infos can't produce a rectangular map: " + infos, e);
		}
		
		return new RectangularMap(sizeX, sizeY); 
	}
}

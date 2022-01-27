package com.nickson.map;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectangularMapTest {

	@Test
	void testVerifyCoordinate() {
		RectangularMap rectangularMap = new RectangularMap(3l, 5l);
		
		Coordinate2D correctCordinate = new Coordinate2D(0l, 2l, Orientation.EST);
		assertTrue(rectangularMap.verifyCoordinate(correctCordinate));
		
		Coordinate2D wrongCordinate = new Coordinate2D(3l, 2l, Orientation.EST);
		assertFalse(rectangularMap.verifyCoordinate(wrongCordinate));
		
		wrongCordinate = new Coordinate2D(-3l, 2l, Orientation.EST);
		assertFalse(rectangularMap.verifyCoordinate(wrongCordinate));
	}
	
	@Test
	void testCreateWithBadInput() {
		RectangularMap rectangularMap = new RectangularMap(-3l, -5l);
		RectangularMap expectedMap = new RectangularMap(0l, 0l);
		assertEquals(expectedMap, rectangularMap);
		
		rectangularMap = new RectangularMap(null, null);
		assertEquals(expectedMap, rectangularMap);
	}

}

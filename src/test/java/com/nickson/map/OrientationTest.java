package com.nickson.map;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrientationTest {

	@Test
	void fromStringTest() {
		Orientation orientation = Orientation.fromString("S");
		assertEquals(Orientation.SOUTH, orientation);
		
		orientation = Orientation.fromString("N");
		assertEquals(Orientation.NORTH, orientation);
		
		orientation = Orientation.fromString("E");
		assertEquals(Orientation.EST, orientation);
		
		orientation = Orientation.fromString("W");
		assertEquals(Orientation.WEST, orientation);
	}

	
	@Test
	void fromOrderTest() {
		Orientation orientation = Orientation.fromOrder(2);
		assertEquals(Orientation.SOUTH, orientation);
		
		orientation = Orientation.fromOrder(0);
		assertEquals(Orientation.NORTH, orientation);
		
		orientation = Orientation.fromOrder(1);
		assertEquals(Orientation.EST, orientation);
		
		orientation = Orientation.fromOrder(3);
		assertEquals(Orientation.WEST, orientation);
	}
}

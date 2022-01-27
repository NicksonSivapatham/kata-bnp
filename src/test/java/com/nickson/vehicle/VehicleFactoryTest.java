package com.nickson.vehicle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.nickson.map.Coordinate2D;
import com.nickson.map.Orientation;

class VehicleFactoryTest {

	@Test
	void testGetRovers() {
		Rovers expectedRovers = new  Rovers(new Coordinate2D(5l,3l, Orientation.NORTH));
		
		assertEquals(expectedRovers,VehicleFactory.getRovers("5 3 N"));
		assertThrows(IllegalArgumentException.class, () -> VehicleFactory.getRovers("5 D"));
	}

}

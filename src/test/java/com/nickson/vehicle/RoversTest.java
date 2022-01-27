package com.nickson.vehicle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nickson.map.Coordinate2D;
import com.nickson.map.Orientation;
import com.nickson.map.Plan2D;
import com.nickson.map.RectangularMap;
import com.nickson.vehicle.exception.InvalidItinerary;
import com.nickson.vehicle.exception.InvalidPosition;

class RoversTest {
	
	private Rovers rover;
	
	@BeforeEach 
    void init() {
		Coordinate2D coordinate = new Coordinate2D(0l, 0l, Orientation.NORTH);
		rover = new Rovers(coordinate);
    }

	@Test
	void testNavigate() throws InvalidItinerary, InvalidPosition {
		Plan2D rectangularPlan = new RectangularMap(5l,3l);
		
		rover.navigate("MMRM", rectangularPlan);
		assertEquals(new Coordinate2D(1l, 2l, Orientation.EST), rover.getCoordinate());
		
		assertThrows(InvalidItinerary.class, () -> rover.navigate("LXDR", rectangularPlan));
		assertThrows(InvalidPosition.class, () -> rover.navigate("MMMMMMMM", rectangularPlan));
	}

	@Test
	void testTurnLeft() {
		Orientation newOrientation = rover.turnLeft();
		assertEquals(Orientation.WEST, newOrientation);
		assertEquals(Orientation.WEST, rover.getCoordinate().getOrientation());
		
		newOrientation = rover.turnLeft();
		assertEquals(Orientation.SOUTH, newOrientation);
		assertEquals(Orientation.SOUTH, rover.getCoordinate().getOrientation());
		
		newOrientation = rover.turnLeft();
		assertEquals(Orientation.EST, newOrientation);
		assertEquals(Orientation.EST, rover.getCoordinate().getOrientation());
		
		newOrientation = rover.turnLeft();
		assertEquals(Orientation.NORTH, newOrientation);
		assertEquals(Orientation.NORTH, rover.getCoordinate().getOrientation());
	}

	@Test
	void testTurnRight() {
		Orientation newOrientation = rover.turnRight();
		assertEquals(Orientation.EST, newOrientation);
		assertEquals(Orientation.EST, rover.getCoordinate().getOrientation());
		
		newOrientation = rover.turnRight();
		assertEquals(Orientation.SOUTH, newOrientation);
		assertEquals(Orientation.SOUTH, rover.getCoordinate().getOrientation());
		
		newOrientation = rover.turnRight();
		assertEquals(Orientation.WEST, newOrientation);
		assertEquals(Orientation.WEST, rover.getCoordinate().getOrientation());
		
		newOrientation = rover.turnRight();
		assertEquals(Orientation.NORTH, newOrientation);
		assertEquals(Orientation.NORTH, rover.getCoordinate().getOrientation());
	}

	@Test
	void testMove() throws InvalidPosition {
		Plan2D rectangularPlan = new RectangularMap(1l,1l);
		
		Coordinate2D newCoordinate = rover.move(rectangularPlan);
		Coordinate2D expectedCoodinate = new Coordinate2D(0l,1l, Orientation.NORTH);
		assertEquals(expectedCoodinate, newCoordinate);
		assertEquals(expectedCoodinate, rover.getCoordinate());
		
		rover.turnRight();
		newCoordinate = rover.move(rectangularPlan);
		expectedCoodinate = new Coordinate2D(1l,1l, Orientation.EST);
		assertEquals(expectedCoodinate, newCoordinate);
		assertEquals(expectedCoodinate, rover.getCoordinate());
		
		rover.turnRight();
		newCoordinate = rover.move(rectangularPlan);
		expectedCoodinate = new Coordinate2D(1l,0l, Orientation.SOUTH);
		assertEquals(expectedCoodinate, newCoordinate);
		assertEquals(expectedCoodinate, rover.getCoordinate());
		
		rover.turnRight();
		newCoordinate = rover.move(rectangularPlan);
		expectedCoodinate = new Coordinate2D(0l,0l, Orientation.WEST);
		assertEquals(expectedCoodinate, newCoordinate);
		assertEquals(expectedCoodinate, rover.getCoordinate());
		
		assertThrows(InvalidPosition.class, () -> rover.move(rectangularPlan));
	}

	@Test
	void testVerifyItinerary() {
		assertTrue(rover.verifyItinerary("LMRLLLRRM"));
		assertTrue(rover.verifyItinerary("MMMMMM"));
		
		assertFalse(rover.verifyItinerary("LMRLLLXXD"));
		assertFalse(rover.verifyItinerary("LM RLLL "));	
	}

}

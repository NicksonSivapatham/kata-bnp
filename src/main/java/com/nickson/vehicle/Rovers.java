package com.nickson.vehicle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.nickson.map.Coordinate2D;
import com.nickson.map.Orientation;
import com.nickson.map.Plan2D;
import com.nickson.vehicle.exception.InvalidItinerary;
import com.nickson.vehicle.exception.InvalidPosition;

public class Rovers implements Vehicle{

	public static enum Movement {L,M,R}
	
	private Coordinate2D coordinate;

	public Rovers(Coordinate2D coordinate) {
		super();
		this.coordinate = coordinate;
	}
	
	public Coordinate2D getCoordinate() {
		return coordinate;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(coordinate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rovers other = (Rovers) obj;
		return Objects.equals(coordinate, other.coordinate);
	}

	@Override
	public void navigate(String itinerary, Plan2D plan) throws InvalidItinerary, InvalidPosition {
		if (verifyItinerary(itinerary)) {
			for (String movementString : itinerary.split("")) {
				Movement nextMovement = Movement.valueOf(movementString);
				switch (nextMovement) {
				case M:
					move(plan);
					break;
				case L:
					turnLeft();
					break;
				case R:
					turnRight();
					break;
				default:
					break;
				}
			}
		} else {
			throw new InvalidItinerary("The rover can not execute some movement from the itinerary: " + itinerary);
		}
	}
	
	/**
	 * Turn Rover to the left
	 * @return new position
	 */
	public Orientation turnLeft() {
		Integer leftOrientationOrder = Math.floorMod(coordinate.getOrientation().getOrder() - 1, 4);
		Orientation leftOrientation = Orientation.fromOrder(leftOrientationOrder);
		coordinate = new Coordinate2D(coordinate.getX(), coordinate.getY(), leftOrientation);
		return leftOrientation;
	}
	
	/**
	 * Turn Rover to the right
	 * @return new position
	 */
	public Orientation turnRight() {
		Integer rightOrientationOrder = Math.floorMod(coordinate.getOrientation().getOrder() + 1, 4);
		Orientation rightOrientation = Orientation.fromOrder(rightOrientationOrder);
		coordinate = new Coordinate2D(coordinate.getX(), coordinate.getY(), rightOrientation);
		return rightOrientation;
	}
	
	/**
	 * Move rover on the given plan
	 * @param plan
	 * @return new position
	 * @throws InvalidPosition if rover goes out of the plan
	 */
	public Coordinate2D move(Plan2D plan) throws InvalidPosition{
		Coordinate2D nextCoordinate;
		Long currentX = coordinate.getX();
		Long currentY = coordinate.getY();
		
		switch (coordinate.getOrientation()) {
		case NORTH:
			currentY++;
			break;
		case SOUTH:
			currentY--;	
			break;
		case WEST:
			currentX--;
			break;
		case EST:
			currentX++;
			break;
		default:
			break;
		}
		
		nextCoordinate = new Coordinate2D(currentX, currentY, coordinate.getOrientation());
		if (plan.verifyCoordinate(nextCoordinate)) {
			this.coordinate = nextCoordinate;
		} else {
			throw new InvalidPosition("The rover can't move to the next position, due to plan constraint");
		}
		return nextCoordinate;
	}
	
	/**
	 * Verify if the rover can execute movements of the given itinerary 
	 * @param itinerary
	 * @return
	 */
	public Boolean verifyItinerary(String itinerary) {
		Set<String> itineraryDistinctActions =	new HashSet<>(Arrays.asList(itinerary.split("")));
		
		if (itineraryDistinctActions.size() > Movement.values().length) {
			return false;
		}
		
		Set<String> authorizeMovement = Arrays.asList(Movement.values()).stream()
																		.map(Movement::toString).collect(Collectors.toCollection(HashSet::new));
		
		for(String move: itineraryDistinctActions) {
			if (!authorizeMovement.contains(move)) {
				return false;
			}
		}
		
		return true;
	}
}

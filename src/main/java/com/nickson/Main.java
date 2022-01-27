package com.nickson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nickson.map.Plan2D;
import com.nickson.map.Plan2DFactory;
import com.nickson.reader.FileReader;
import com.nickson.reader.FileReaderTxt;
import com.nickson.vehicle.Rovers;
import com.nickson.vehicle.Vehicle;
import com.nickson.vehicle.VehicleFactory;
import com.nickson.vehicle.exception.InvalidItinerary;
import com.nickson.vehicle.exception.InvalidPosition;

public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReaderTxt();
		List<String> inputInfos = fileReader.readFile("src/main/resources/input.txt");

		Plan2D plan = Plan2DFactory.getRectangularMap(inputInfos.get(0));
		
		List<Vehicle> listOfVehicle = new ArrayList<>();
		for (int i = 1; i < inputInfos.size(); i = i+2) {
			String vehicleInfos = inputInfos.get(i);
			String vehicleItinerary = inputInfos.get(i+1);
			
			Vehicle vehicle = VehicleFactory.getRovers(vehicleInfos);
			listOfVehicle.add(vehicle);
			
			try {
				vehicle.navigate(vehicleItinerary, plan);
			} catch (InvalidItinerary e) {
				e.printStackTrace();
			} catch(InvalidPosition e) {
				e.printStackTrace();
			}
		}
		
		listOfVehicle.stream().map(Rovers.class::cast).map(Rovers::getCoordinate).forEach(c -> System.out.println(c));
		
	}

}

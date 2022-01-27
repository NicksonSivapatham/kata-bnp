package com.nickson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nickson.map.Coordinate2D;
import com.nickson.map.Plan2D;
import com.nickson.map.Plan2DFactory;
import com.nickson.reader.FileReader;
import com.nickson.reader.FileReaderTxt;
import com.nickson.vehicle.Rovers;
import com.nickson.vehicle.Vehicle;
import com.nickson.vehicle.VehicleFactory;
import com.nickson.vehicle.exception.InvalidItinerary;
import com.nickson.vehicle.exception.InvalidPosition;
import com.nickson.writter.FileWritter;
import com.nickson.writter.FileWritterTxt;

public class Main {
	
	public static void main(String[] args) throws IOException {
		if (args.length > 0) {
			FileReader fileReader = new FileReaderTxt();
			List<String> inputInfos = fileReader.readFile(args[0]);

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
			
			List<String> finalCoordinate = listOfVehicle.stream()
														.map(Rovers.class::cast)
														.map(Rovers::getCoordinate)
														.map(Coordinate2D::toString)
														.toList();
			
			FileWritter writter = new FileWritterTxt(); 
			writter.write("output.txt", finalCoordinate);
			
		} else {
			System.out.println("Please indicate the input file ex: ./input.txt");
		}
		
	}

}

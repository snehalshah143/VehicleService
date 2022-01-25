package com.snehal.carservice.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.snehal.carservice.common.VehicleSegment;
import com.snehal.carservice.model.persistable.VehiclePersistable;

public class VehicleManagement {

	private static Set<VehiclePersistable> vehicles = new HashSet<VehiclePersistable>();

	private static VehicleManagement vehicleManagement = new VehicleManagement();
	
	public static void main(String args[]) {
		VehicleManagement.populateAllVehicles();
		}

	static {
		populateAllVehicles();
	}

	private VehicleManagement() {

	}

	private static void populateAllVehicles() {

//#Manufacturer,Model,VehicleSegment
			 File file=new File("D:\\SnehalImp\\Wash\\Repo\\carservice\\carservice\\src\\main\\resources\\vehicles.csv");
       Scanner sc = null;
	try {
		sc = new Scanner(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
             String line;
             while (sc.hasNextLine()) {
          
            	 String str=sc.nextLine();
            	 String[] array=str.split(",");
              	 VehiclePersistable v=new VehiclePersistable(array[0], array[1], VehicleSegment.valueOf(array[2]));
              	vehicles.add(v);
             }
		 		
	}

	public static VehicleManagement getVehicleManagement() {
		return vehicleManagement;
	}

	public static Set<VehiclePersistable> getVehicles() {
		return vehicles;
	}

	public static void setVehicles(Set<VehiclePersistable> vehicles) {
		VehicleManagement.vehicles = vehicles;
	}

	
}

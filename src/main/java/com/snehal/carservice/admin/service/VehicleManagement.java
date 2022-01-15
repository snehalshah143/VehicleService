package com.snehal.carservice.admin.service;

import java.util.HashSet;
import java.util.Set;

import com.snehal.carservice.common.model.Vehicle;

public class VehicleManagement {

	private static Set<Vehicle> vehicles = new HashSet<Vehicle>();

	private static VehicleManagement vehicleManagement = new VehicleManagement();
	
	public static void main(String args[]) {
		VehicleManagement.populateAllVehicles();
		System.out.println(vehicles);
	}

	static {
		populateAllVehicles();
	}

	private VehicleManagement() {

	}

	private static void populateAllVehicles() {

		
	}

	public static VehicleManagement getVehicleManagement() {
		return vehicleManagement;
	}

	public static Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public static void setVehicles(Set<Vehicle> vehicles) {
		VehicleManagement.vehicles = vehicles;
	}

	
}

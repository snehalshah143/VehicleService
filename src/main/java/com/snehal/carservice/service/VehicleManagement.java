package com.snehal.carservice.service;

import com.snehal.carservice.common.VehicleSegment;
import com.snehal.carservice.common.util.DateTimeUtil;
import com.snehal.carservice.model.persistable.VehiclePersistable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class VehicleManagement {

  private static Set<VehiclePersistable> vehicles = new HashSet<VehiclePersistable>();

  private static VehicleManagement vehicleManagement = new VehicleManagement();

  public static void main(String args[]) {
    VehicleManagement.populateAllVehicles();
  }

  static {
    populateAllVehicles();
  }

  private VehicleManagement() {}

  private static void populateAllVehicles() {

    // #Manufacturer,Model,VehicleSegment
    File file = new File("src\\main\\resources\\vehicles.csv");
    Scanner sc = null;
    try {
      sc = new Scanner(file);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    String line;
    Date createdOn = DateTimeUtil.getCurrentDate();
    while (sc.hasNextLine()) {

      String str = sc.nextLine();
      String[] array = str.split(",");
      VehiclePersistable v =
          new VehiclePersistable(array[0], array[1], VehicleSegment.valueOf(array[2]));
      v.setCreatedOn(createdOn);
      v.setCreatedBy("ADMIN");
      v.setRecordStatus("Active");

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

package com.snehal.carservice.service;

import com.snehal.carservice.common.ProductType;
import com.snehal.carservice.common.TimeSlot;
import com.snehal.carservice.common.VehicleSegment;
import com.snehal.carservice.common.util.DateTimeUtil;
import com.snehal.carservice.model.persistable.ProductPersistable;
import java.util.HashSet;
import java.util.Set;

public class ProductManagement {

  private static Set<ProductPersistable> products = new HashSet<ProductPersistable>();

  private static ProductManagement productManagement = new ProductManagement();

  private static double tax = 0.05;

  public static void main(String args[]) {
    ProductManagement.populateAllProductCombination();
    System.out.println(products);
  }

  static {
    populateAllProductCombination();
  }

  private ProductManagement() {}

  public static ProductManagement getProdctManagement() {
    return productManagement;
  }

  public static Set<ProductPersistable> getProducts() {
    return products;
  }

  public static void setProducts(Set<ProductPersistable> products) {
    ProductManagement.products = products;
  }

  private static void populateAllProductCombination() {
    VehicleSegment[] vehicleCategoryEnum = VehicleSegment.values();
    ProductType[] productTypeEnum = ProductType.values();
    TimeSlot[] timeSlotEnum = TimeSlot.values();
    for (int i = 0; i < vehicleCategoryEnum.length; i++) {
      for (int j = 0; j < productTypeEnum.length; j++) {
        for (int k = 0; k < timeSlotEnum.length; k++) {
          double price =
              calculatePrice(productTypeEnum[j], vehicleCategoryEnum[i], timeSlotEnum[k]);
          addProductDetail(productTypeEnum[j], vehicleCategoryEnum[i], timeSlotEnum[k], price);
        }
      }
    }
  }

  private static double calculatePrice(
      ProductType productType, VehicleSegment vehicleCategory, TimeSlot timeSlot) {

    return ((vehicleCategory.getBasePrice() * productType.getFactor())
        + (timeSlot.getPremium() * productType.getFactor()));
  }

  private static void addProductDetail(
      ProductType productType, VehicleSegment vehicleCategory, TimeSlot timeSlot, double price) {
    products.add(
        new ProductPersistable(
            productType,
            vehicleCategory,
            timeSlot,
            price,
            DateTimeUtil.getCurrentDate(),
            "ADMIN",
            "Active"));
  }

  public static double getTax() {
    return tax;
  }
}

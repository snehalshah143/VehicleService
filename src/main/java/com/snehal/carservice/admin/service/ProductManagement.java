package com.snehal.carservice.admin.service;

import java.util.HashSet;
import java.util.Set;

import com.snehal.carservice.common.model.Product;
import com.snehal.carservice.common.model.ProductType;
import com.snehal.carservice.common.model.TimeSlot;
import com.snehal.carservice.common.model.VehicleSegment;

public class ProductManagement {

	private static Set<Product> products = new HashSet<Product>();

	private static ProductManagement productManagement = new ProductManagement();
	
	private static double tax=0.05;

	public static void main(String args[]) {
		ProductManagement.populateAllProductCombination();
		System.out.println(products);
	}

	static {
		populateAllProductCombination();
	}

	private ProductManagement() {

	}

	public static ProductManagement getProdctManagement() {
		return productManagement;
	}



	public static Set<Product> getProducts() {
		return products;
	}

	public static void setProducts(Set<Product> products) {
		ProductManagement.products = products;
	}

	private static void populateAllProductCombination() {
		VehicleSegment[] vehicleCategoryEnum = VehicleSegment.values();
		ProductType[] productTypeEnum = ProductType.values();
		TimeSlot[] timeSlotEnum = TimeSlot.values();
		for (int i = 0; i < vehicleCategoryEnum.length; i++) {
			for (int j = 0; j < productTypeEnum.length; j++) {
				for (int k = 0; k < timeSlotEnum.length; k++) {
					double price = calculatePrice(productTypeEnum[j], vehicleCategoryEnum[i], timeSlotEnum[k]);
					addProductDetail(productTypeEnum[j], vehicleCategoryEnum[i], timeSlotEnum[k], price);

				}
			}
		}

	}

	private static double calculatePrice(ProductType productType, VehicleSegment vehicleCategory, TimeSlot timeSlot) {

		
		return ((vehicleCategory.getBasePrice() * productType.getFactor()) + (timeSlot.getPremium()*productType.getFactor()));
	}

	private static void addProductDetail(ProductType productType, VehicleSegment vehicleCategory, TimeSlot timeSlot,
			double price) {
		products.add(new Product(productType, vehicleCategory, timeSlot,price));

	}

	public static double getTax() {
		return tax;
	}

}

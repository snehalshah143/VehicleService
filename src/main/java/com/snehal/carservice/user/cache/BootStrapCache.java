package com.snehal.carservice.user.cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.snehal.carservice.admin.service.ProductService;
import com.snehal.carservice.common.model.Product;
import com.snehal.carservice.common.model.Vehicle;

public class BootStrapCache {

	private static Map<Product, Double> productPricingCache=new HashMap();
	
	private static Map<Long,Product> productCache=new HashMap();
	
	private static Map<Long,Vehicle> vehicleCache=new HashMap();

	
	public static Map<Product, Double> getProductPricingCache() {
		return productPricingCache;
	}

	public static void setProductPricingCache(Map<Product, Double> productPricingCache) {
		BootStrapCache.productPricingCache = productPricingCache;
	}

	public static Map<Long, Product> getProductCache() {
		return productCache;
	}

	public static void setProductCache(Map<Long, Product> productCache) {
		BootStrapCache.productCache = productCache;
	}

	public static Map<Long, Vehicle> getVehicleCache() {
		return vehicleCache;
	}

	public static void setVehicleCache(Map<Long, Vehicle> vehicleCache) {
		BootStrapCache.vehicleCache = vehicleCache;
	}

}

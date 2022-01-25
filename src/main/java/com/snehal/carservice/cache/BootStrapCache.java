package com.snehal.carservice.cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.snehal.carservice.model.persistable.ProductPersistable;
import com.snehal.carservice.model.persistable.VehiclePersistable;
import com.snehal.carservice.service.ProductService;

public class BootStrapCache {

	private static Map<ProductPersistable, Double> productPricingCache=new HashMap();
	
	private static Map<Long,ProductPersistable> productCache=new HashMap();
	
	private static Map<Long,VehiclePersistable> vehicleCache=new HashMap();

	
	public static Map<ProductPersistable, Double> getProductPricingCache() {
		return productPricingCache;
	}

	public static void setProductPricingCache(Map<ProductPersistable, Double> productPricingCache) {
		BootStrapCache.productPricingCache = productPricingCache;
	}

	public static Map<Long, ProductPersistable> getProductCache() {
		return productCache;
	}

	public static void setProductCache(Map<Long, ProductPersistable> productCache) {
		BootStrapCache.productCache = productCache;
	}

	public static Map<Long, VehiclePersistable> getVehicleCache() {
		return vehicleCache;
	}

	public static void setVehicleCache(Map<Long, VehiclePersistable> vehicleCache) {
		BootStrapCache.vehicleCache = vehicleCache;
	}

}

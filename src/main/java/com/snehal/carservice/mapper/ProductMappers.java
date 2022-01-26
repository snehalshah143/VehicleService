package com.snehal.carservice.mapper;

import com.snehal.carservice.model.domain.Product;
import com.snehal.carservice.model.dto.ProductJsonDto;
import com.snehal.carservice.model.persistable.ProductPersistable;

public class ProductMappers extends AbstarctMapper<ProductJsonDto, Product, ProductPersistable>{

	private static ProductMappers productMappers=new ProductMappers();

	public static ProductMappers getProductMappers() {
		return productMappers;
	}

	public ProductJsonDto  mapPersistableToJsonDto(ProductPersistable persistable) {
		ProductJsonDto jsonDto=new ProductJsonDto();
		jsonDto.setProductId(persistable.getProductId());
		jsonDto.setPrice(persistable.getPrice());
		jsonDto.setProductType(persistable.getProductType());
		jsonDto.setTimeSlot(persistable.getTimeSlot());
		jsonDto.setVehicleSegment(persistable.getVehicleSegment());
		return jsonDto;
		
	}

}

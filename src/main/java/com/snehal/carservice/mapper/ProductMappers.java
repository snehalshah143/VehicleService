package com.snehal.carservice.mapper;

import com.snehal.carservice.model.domain.Product;
import com.snehal.carservice.model.dto.ProductJsonDto;
import com.snehal.carservice.model.persistable.ProductPersistable;

public class ProductMappers extends AbstarctMapper<ProductJsonDto, Product, ProductPersistable>{

	private static ProductMappers productMappers=new ProductMappers();

	public static ProductMappers getProductMappers() {
		return productMappers;
	}


}

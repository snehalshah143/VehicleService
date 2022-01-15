package com.snehal.carservice.admin.service;

import java.util.List;

import com.snehal.carservice.common.model.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	
	public List<Product> saveProducts(List<Product> products);
	
	public List<Product> getAllProducts();

	public void deleteAllProducts();
	
	public void saveAllProductsForFirstTime();
}

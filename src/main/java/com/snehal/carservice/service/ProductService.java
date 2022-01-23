package com.snehal.carservice.service;

import java.util.List;

import com.snehal.carservice.model.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	
	public List<Product> saveProducts(List<Product> products);
	
	public List<Product> getAllProducts();

	public void deleteAllProducts();
	
	public void saveAllProductsForFirstTime();
}

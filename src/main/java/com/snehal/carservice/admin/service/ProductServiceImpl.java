package com.snehal.carservice.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snehal.carservice.admin.dao.ProductRepository;
import com.snehal.carservice.common.model.Product;
import com.snehal.carservice.user.cache.BootStrapCache;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	@Override
	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void deleteAllProducts() {
		 productRepository.deleteAll();
	}
	
	public void saveAllProductsForFirstTime() {
		deleteAllProducts();
		ProductManagement productManagement=ProductManagement.getProdctManagement();
		List<Product> products=saveProducts(new ArrayList(productManagement.getProducts()));
		pouplateProductAndPricingCache(products);
	}
	
	public void pouplateProductAndPricingCache(List<Product> allProducts) {

		Map<Product, Double> productPricingCache=BootStrapCache.getProductPricingCache();
		Map<Long,Product> productCache=BootStrapCache.getProductCache();
		productPricingCache.clear();
		productCache.clear();
		
		for(Product p:allProducts) {
			productPricingCache.put(p, p.getPrice());
			productCache.put(p.getProductId(), p);
		}
	}
	
	@PostConstruct
	public  void loadProductAndPricingCache() {
		Map<Product, Double> productPricingCache=BootStrapCache.getProductPricingCache();
		Map<Long,Product> productCache=BootStrapCache.getProductCache();	
		List<Product> allProducts=getAllProducts();
		productPricingCache.clear();
		productCache.clear();
		for(Product p:allProducts) {
			productPricingCache.put(p, p.getPrice());
			productCache.put(p.getProductId(), p);
		}
		System.out.println("Product Loading");
	}
}

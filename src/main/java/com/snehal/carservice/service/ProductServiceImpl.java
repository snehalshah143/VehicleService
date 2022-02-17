package com.snehal.carservice.service;

import com.snehal.carservice.cache.BootStrapCache;
import com.snehal.carservice.dao.ProductRepository;
import com.snehal.carservice.model.persistable.ProductPersistable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductRepository productRepository;

  @Override
  public ProductPersistable saveProduct(ProductPersistable product) {

    return productRepository.save(product);
  }

  @Override
  public List<ProductPersistable> saveProducts(List<ProductPersistable> products) {
    return productRepository.saveAll(products);
  }

  @Override
  public List<ProductPersistable> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public void deleteAllProducts() {
    productRepository.deleteAll();
  }

  public void saveAllProductsForFirstTime() {
    deleteAllProducts();
    ProductManagement productManagement = ProductManagement.getProdctManagement();
    List<ProductPersistable> products =
        saveProducts(new ArrayList(productManagement.getProducts()));
    pouplateProductAndPricingCache(products);
  }

  public void pouplateProductAndPricingCache(List<ProductPersistable> allProducts) {

    Map<ProductPersistable, Double> productPricingCache = BootStrapCache.getProductPricingCache();
    Map<Long, ProductPersistable> productCache = BootStrapCache.getProductCache();
    productPricingCache.clear();
    productCache.clear();

    for (ProductPersistable p : allProducts) {
      productPricingCache.put(p, p.getPrice());
      productCache.put(p.getProductId(), p);
    }
  }

  @PostConstruct
  public void loadProductAndPricingCache() {
    Map<ProductPersistable, Double> productPricingCache = BootStrapCache.getProductPricingCache();
    Map<Long, ProductPersistable> productCache = BootStrapCache.getProductCache();
    List<ProductPersistable> allProducts = getAllProducts();
    productPricingCache.clear();
    productCache.clear();
    for (ProductPersistable p : allProducts) {
      productPricingCache.put(p, p.getPrice());
      productCache.put(p.getProductId(), p);
    }
    System.out.println("Product Loading");
  }
}

package com.snehal.carservice.service;

import com.snehal.carservice.model.persistable.ProductPersistable;
import java.util.List;

public interface ProductService {

  public ProductPersistable saveProduct(ProductPersistable product);

  public List<ProductPersistable> saveProducts(List<ProductPersistable> products);

  public List<ProductPersistable> getAllProducts();

  public void deleteAllProducts();

  public void saveAllProductsForFirstTime();
}

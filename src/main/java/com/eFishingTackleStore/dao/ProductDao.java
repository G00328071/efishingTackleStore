package com.eFishingTackleStore.dao;

import com.eFishingTackleStore.model.Product;

import java.util.List;

/**
 * Created by Alan Doyle on 04/02/2017.
 */
public interface ProductDao {
    void addProduct(Product product);

    Product getProductById(String Id);

    List<Product> getAllProducts();

    void deleteProduct(String id);
}

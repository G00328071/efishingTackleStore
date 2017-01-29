package com.eFishingTackleStore.dao;

import com.eFishingTackleStore.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan Doyle on 28/01/2017.
 */
public class ProductDao {
    private List<Product> productList;

    public List<Product> getProductList(){
        Product product1 = new Product();

        product1.setProductName("FlyRod_3piece");
        product1.setProductCategory("Game_Fishing");
        product1.setProductDescription("This is a Grays grx model 11'6");
        product1.setProductPrice(150);
        product1.setProductCondition("new");
        product1.setProductStatus("active");
        product1.setUnitInStock(10);
        product1.setProductManufacturer("Grays");

        productList = new ArrayList<Product>();
        productList.add(product1);


    return productList;
    }
}//class

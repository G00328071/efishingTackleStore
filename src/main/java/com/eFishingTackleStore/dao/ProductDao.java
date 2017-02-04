package com.eFishingTackleStore.dao;

import com.eFishingTackleStore.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan Doyle on 28/01/2017.
 */
public class ProductDao {
    private List<Product> productList;

    public List<Product> getProductList() {
        Product product1 = new Product();
        Product product2 = new Product();

        product1.setProductID("GR0001");
        product1.setProductName("FlyRod 4 piece");
        product1.setProductCategory("Game_Fishing");
        product1.setProductDescription("This is a Grays gr50 6ft");
        product1.setProductPrice(149.99);
        product1.setProductCondition("new");
        product1.setProductStatus("active");
        product1.setUnitInStock(10);
        product1.setProductManufacturer("Greys");

        product2.setProductID("FR0001");
        product2.setProductName("Hatch Fly Reel");
        product2.setProductCategory("Game_Fishing");
        product2.setProductDescription("HATCH FLY REEL : large Arbor Reel");
        product2.setProductPrice(329.99);
        product2.setProductCondition("new");
        product2.setProductStatus("active");
        product2.setUnitInStock(5);
        product2.setProductManufacturer("Hatch");

        productList = new ArrayList<Product>();
        productList.add(product1);
        productList.add(product2);

        return productList;
    }
    //this function takes the product id
    // searches through the product list comparing product id,s
    // if found returns that product
    //otherwise it throws an IO exception and gives product not found error
    public Product getProductById(String productId) throws IOException{
        for (Product product : getProductList()) {
            if (product.getProductID().equals(productId)) {
                return product;

            }
        }
        throw new IOException("No Product Found");

    }

}//class

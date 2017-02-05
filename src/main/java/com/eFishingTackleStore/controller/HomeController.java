package com.eFishingTackleStore.controller;

import com.eFishingTackleStore.dao.ProductDao;
import com.eFishingTackleStore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alan Doyle on 28/01/2017.
 */
@Controller
public class HomeController {

    @Autowired
    private ProductDao productDao;


    @RequestMapping("/")
    public String home() {
        return "home";
    }


    @RequestMapping("/productList")
    public String getProducts(Model model) {
        List<Product> products = productDao.getAllProducts();

        //once we create the product
        //we bind the product to the model
        model.addAttribute("products", products);

        // when this view is returned the model well be bound to the view
        return "productList";

    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException{
            Product product = productDao.getProductById(productId);
            model.addAttribute(product);

        return "viewProduct";
    }


}//class end

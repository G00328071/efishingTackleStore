package com.eFishingTackleStore.controller;

import com.eFishingTackleStore.dao.ProductDao;
import com.eFishingTackleStore.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Alan Doyle on 28/01/2017.
 */
@Controller
public class HomeController {

    private ProductDao productDao = new ProductDao();

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> productList = productDao.getProductList();
        Product product = productList.get(0);
        //once we create the product
        //we bind the product to the model
        model.addAttribute(product);

        // when this view is returned the model well be bound to the view
        return "productList";

    }

}

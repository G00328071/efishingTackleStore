package com.eFishingTackleStore.controller;

import com.eFishingTackleStore.dao.ProductDao;
import com.eFishingTackleStore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";
    }
    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model){
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products",products);

        return "productInventory";


    }
    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        product.setProductCategory("course fishing");
        product.setProductCondition("new");
        product.setProductStatus("active");

        model.addAttribute("product", product);

    return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product) {
        productDao.addProduct(product);

        return "redirect:/admin/productInventory";


    }
    @RequestMapping("/admin/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable String id, Model model) {
        productDao.deleteProduct(id);

        return "redirect:/admin/productInventory";
    }

}//class end

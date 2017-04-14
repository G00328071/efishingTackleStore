package com.eFishingTackleStore.controller;

import com.eFishingTackleStore.dao.ProductDao;
import com.eFishingTackleStore.model.Product;
import org.jboss.logging.annotations.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


/**
 * Created by Alan Doyle on 28/01/2017.
 */
@Controller
public class HomeController {
    private Path path;

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
    public String viewProduct(@PathVariable int productId, Model model) throws IOException {
        Product product = productDao.getProductById(productId);
        model.addAttribute(product);

        return "viewProduct";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);

        return "productInventory";


    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProductCategory("course fishing");
        product.setProductCondition("new");
        product.setProductStatus("active");

        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) {

        if(result.hasErrors()){

            return "addProduct";
        }

        productDao.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductID() + ".png");
        // this takes in the image regardless of file type and then then saves it to the images file
        //as a .png image type
        if (productImage != null && !productImage.isEmpty()) {
            try {

                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("product Image saving failed", e);


            }

        }

        return "redirect:/admin/productInventory";


    }

    @RequestMapping("/admin/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {
        // delete the image when deleting the item
        // so as in the add product we create a path to the image
        //we use the path of the image to reference the image we want to delete
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id + ".png");


        //check if the files exist
        if (Files.exists(path)) {

            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        productDao.deleteProduct(id);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        //create a new product instance and get the the dao to source the product by id
        //pass that product to the product we just created.
        Product product = productDao.getProductById(id);

        model.addAttribute(product);
        return "editProduct";

    }

    @RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
    public String editPrduct(@Valid @ModelAttribute("product") Product product, BindingResult result,Model model, HttpServletRequest request) {

        if(result.hasErrors()){

            return "editProduct";
        }

        MultipartFile productImage = product.getProductImage();
        String root = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(root + "\\WEB-INF\\resources\\images\\" + product.getProductID() +".png");


            if(productImage != null && !productImage.isEmpty())
            {
                try{
                    productImage.transferTo(new File(path.toString()));
                }catch(Exception e)
                {

                    throw new RuntimeException("image not saved", e);

                }

            }

            productDao.editProduct(product);
            return "redirect:/admin/productInventory";
    }

}//class end

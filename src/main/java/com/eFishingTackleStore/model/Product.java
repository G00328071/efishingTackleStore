package com.eFishingTackleStore.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Created by Alan Doyle on 28/01/2017.
 */

//@Entity => tells spring, that this is the entity that we want to store in the
//database. Each instance of the Product class represents a row(tuple)
// in the database table.
//@GeneratedValue(strategy = GenerationType.AUTO)
//this means when an instance /row is created its product Id is auto generated in sequence.

@Entity
public class Product {
    //Id defines the primary key in the view(table)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;

    @NotEmpty(message = " A product name must be filled in")
    private String productName;
    private String productCategory;
    private String productDescription;

    @Min(value = 0, message=" The product price must not be less the zero")
    private double productPrice;
    private String productCondition;
    private String productStatus;

    @Min(value=0,message=" The units in stock must not be less then zero")
    private int unitInStock;
    private String productManufacturer;
    /*
    the image will be stored remote to the db as
    the storage of image would require to much space relational dbs have to allow similar space
    for images per tulpe(row)
    instead it will store the image in the resources folder
    */
    @Transient
    private MultipartFile productImage;



    public int getProductID() {
        return productID;
    }

    public void setProductID(int  productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }
}//product

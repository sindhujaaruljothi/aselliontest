package com.sindhu.aselliontest.aselliontest.service;

import com.sindhu.aselliontest.aselliontest.model.Product;

import java.util.List;

public interface ProductService {

    /**
     * This method will get all the products from database
     *
     * @return List of Products
     */
    List<Product> getProducts();

    /**
     * This method will add the given product details to database
     *
     * @param product a product
     * @return A successfully saved product
     */
    Product addProduct(Product product);
}

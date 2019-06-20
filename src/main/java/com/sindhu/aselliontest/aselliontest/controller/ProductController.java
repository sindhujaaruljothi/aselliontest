package com.sindhu.aselliontest.aselliontest.controller;

import com.sindhu.aselliontest.aselliontest.model.Product;
import com.sindhu.aselliontest.aselliontest.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return productService.getProducts();

    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}

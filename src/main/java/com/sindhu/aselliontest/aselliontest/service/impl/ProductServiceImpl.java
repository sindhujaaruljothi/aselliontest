package com.sindhu.aselliontest.aselliontest.service.impl;

import com.sindhu.aselliontest.aselliontest.model.Product;
import com.sindhu.aselliontest.aselliontest.repository.ProductRepository;
import com.sindhu.aselliontest.aselliontest.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.findByName(product.getName())
                .orElseGet(() -> productRepository.save(product));
    }
}


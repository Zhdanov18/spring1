package com.geekbrains.services;

import com.geekbrains.entities.Product;
import com.geekbrains.repositories.ProductsRepositoryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceCriteria {
    private ProductsRepositoryCriteria productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepositoryCriteria productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public List<Product> findAll(Integer min, Integer max) {
        return productsRepository.findAll(min, max);
    }
}
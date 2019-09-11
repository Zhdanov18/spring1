package com.geekbrains.services;

import com.geekbrains.entities.Product;
import com.geekbrains.repositories.ProductsRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceCrud {
    private ProductsRepositoryCrud productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepositoryCrud productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAll() {
        return (List<Product>) productsRepository.findAll();
    }

    public List<Product> findByCostGreaterThanEqual(Integer min) {
        return productsRepository.findByCostGreaterThanEqual(min);
    }

    public List<Product> findByCostLessThanEqual(Integer max) {
        return productsRepository.findByCostLessThanEqual(max);
    }

    public List<Product> findByCostGreaterThanEqualAndCostLessThanEqual(Integer min, Integer max) {
        return productsRepository.findByCostGreaterThanEqualAndCostLessThanEqual(min, max);
    }

}

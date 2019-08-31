package com.geekbrains.services;

import com.geekbrains.entities.Product;
import com.geekbrains.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product getById(int id) {
        return productsRepository.getById(id);
    }

    public List<Product> getAll() {
        return productsRepository.getAll();
    }

    public Product add(Product product) {
        if(product == null) {
            return null;
        }
        return productsRepository.add(product);
    }
}

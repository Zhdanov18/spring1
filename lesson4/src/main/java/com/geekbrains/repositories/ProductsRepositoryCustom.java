package com.geekbrains.repositories;

import com.geekbrains.entities.Product;

import java.util.List;

public interface ProductsRepositoryCustom {
    List<Product> findAll();
    List<Product> findAll(Integer min, Integer max);
}

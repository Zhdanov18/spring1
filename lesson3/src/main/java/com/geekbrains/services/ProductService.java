package com.geekbrains.services;

import com.geekbrains.dao.ProductDao;
import com.geekbrains.models.Product;

import java.util.List;

public class ProductService {
    private ProductDao productDao = new ProductDao();

    public ProductService() {
    }

    public Product findProduct(Long id) {
        return productDao.findById(id);
    }

    public Product findProduct(String name) {
        return productDao.findByName(name);
    }

    public void saveProduct(Product product) {
        productDao.save(product);
    }

    public void deleteProduct(Product product) {
        productDao.delete(product);
    }

    public void updateProduct(Product product) {
        productDao.update(product);
    }

    public List<Product> findAllProducts() {
        return productDao.findAll();
    }

    public void showCustomers(Product product) { productDao.showCustomers(product); }
}

package com.geekbrains.repositories;

import com.geekbrains.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "milk", 60));
        products.add(new Product(2, "bread", 40));
        products.add(new Product(3, "oil", 300));
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getById(int id) {
        for(Product p: products) {
            if(p.getId() == id) {
                return p;
            }
        }
        return products.get(id);
    }

    public List<Product> getAll() {
        return products;
    }

    public Product add(Product product) {
        products.add(product);
        return product;
    }
}

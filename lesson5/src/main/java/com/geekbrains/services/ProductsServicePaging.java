package com.geekbrains.services;

import com.geekbrains.entities.Product;
import com.geekbrains.repositories.ProductsRepositoryPaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductsServicePaging {
    private ProductsRepositoryPaging productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepositoryPaging productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Page<Product> findAll(PageRequest pageRequest) {
        return productsRepository.findAll(pageRequest);
    }

    public Product save(Product product) { return productsRepository.save(product); }

    public Page<Product> getProductsWithPagingAndFiltering(int pageNumber, int pageSize, Sort sort, Specification<Product> productSpecification) {
        return productsRepository.findAll(productSpecification, PageRequest.of(pageNumber, pageSize, sort));
    }

    public Optional<Product> findById(Long id) {
        return productsRepository.findById(id);
    }

    public void update(Product product) {
        productsRepository.update(product.getTitle(), product.getCost(), product.getId());
    }
}

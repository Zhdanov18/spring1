package com.geekbrains.repositories;

import com.geekbrains.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepositoryCrud extends CrudRepository<Product, Long> {
    List<Product> findByCostBetween(Integer min, Integer max);
    List<Product> findByCostGreaterThanEqual(Integer min);
    List<Product> findByCostLessThanEqual(Integer max);
    List<Product> findByCostGreaterThanEqualAndCostLessThanEqual(Integer min, Integer max);
}

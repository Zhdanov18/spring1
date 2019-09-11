package com.geekbrains.repositories;

import com.geekbrains.entities.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductsRepositoryPaging extends PagingAndSortingRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Modifying
    @Query(value = "update Product p set p.title = ?1, p.cost = ?2 where p.id = ?3")
    void update(String title, Integer cost, Long id);
    //Так и не понял, почему это не работает
}

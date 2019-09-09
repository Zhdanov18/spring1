package com.geekbrains.repositories;

import com.geekbrains.entities.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsRepositoryCriteria implements ProductsRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    private List<Product> universalFind(Integer min, Integer max) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        final Root<Product> root = criteriaQuery.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();
        if(min != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), min));
        }
        if(max != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("cost"), max));
        }
        criteriaQuery.select(root).where(predicates.toArray(new Predicate[predicates.size()]));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Product> findAll() {
        return universalFind(null, null);
    }

    @Override
    public List<Product> findAll(Integer min, Integer max) {
        return universalFind(min, max);
    }
}

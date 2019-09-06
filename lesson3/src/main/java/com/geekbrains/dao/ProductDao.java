package com.geekbrains.dao;

import com.geekbrains.models.Customer;
import com.geekbrains.models.Product;
import com.geekbrains.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

public class ProductDao {
    public Product findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession().get(Product.class, id);
    }

    public Product findByName(String title) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.createQuery(
                "SELECT p FROM Product p WHERE p.title = :title", Product.class)
                .setParameter("title", title).getSingleResult();
        transaction.commit();
        return product;
    }

    public List<Product> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Product> products = (List<Product>) session.createQuery("From Product").list();
        transaction.commit();
        return products;
    }

    public void save(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
    }

    public void update(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
    }

    public void delete(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
    }

    public void showCustomers(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Product newProduct = session.get(Product.class, product.getId());
        List<Customer> customers= newProduct.getCustomers();
        System.out.println(Arrays.toString(newProduct.getCustomers().toArray()));
        transaction.commit();
    }
}

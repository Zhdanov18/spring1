package com.geekbrains.dao;

import com.geekbrains.models.Customer;
import com.geekbrains.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDao {
    public Customer findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession().get(Customer.class, id);
    }

    public Customer findByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.createNamedQuery("Customer.findByName", Customer.class)
                .setParameter("name", name).getSingleResult();
        transaction.commit();
        return customer;
    }

    public List<Customer> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Customer> customers = (List<Customer>) session.createQuery("From Customer").list();
        transaction.commit();
        return customers;
    }

    public void save(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
    }

    public void update(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
    }

    public void delete(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(customer);
        transaction.commit();
    }
}

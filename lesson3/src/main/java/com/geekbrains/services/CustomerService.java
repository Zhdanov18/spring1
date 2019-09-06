package com.geekbrains.services;

import com.geekbrains.dao.CustomerDao;
import com.geekbrains.models.Customer;
import com.geekbrains.models.Product;

import java.util.List;

public class CustomerService {
    private CustomerDao customerDao = new CustomerDao();

    public CustomerService() {
    }

    public Customer findCustomer(Long id) {
        return customerDao.findById(id);
    }

    public Customer findCustomer(String name) {
        return customerDao.findByName(name);
    }

    public List<Customer> findAllCustomers() {
        return customerDao.findAll();
    }

    public void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerDao.delete(customer);
    }

    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }

    public void showProducts(Customer customer) { customerDao.showProducts(customer); }

    public void buy(Long customer_id, Product product) { customerDao.buy(customer_id, product); }

    public void buy(Long customer_id, List<Product> product) { customerDao.buy(customer_id, product); }
}

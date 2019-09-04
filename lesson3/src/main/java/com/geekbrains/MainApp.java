package com.geekbrains;

import com.geekbrains.models.Customer;
import com.geekbrains.models.Product;
import com.geekbrains.services.CustomerService;
import com.geekbrains.services.ProductService;
import com.geekbrains.utils.HibernateSessionFactoryUtil;

import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        try {
            CustomerService customerService = new CustomerService();
            ProductService productService = new ProductService();

//заполнение таблиц
            List<Customer> customers = Arrays.asList(new Customer("Bob"), new Customer("Jack"), new Customer("Mike"));
            customers.forEach(customerService::saveCustomer);

            List<Product> products = Arrays.asList(new Product("milk", 60), new Product("bread", 40), new Product("apple", 100));
            products.forEach(productService::saveProduct);

//продажа
            Customer customer1 = customerService.findCustomer("Bob");
            Product product1 = productService.findProduct("milk");
            customer1.addProduct(product1);
            customerService.updateCustomer(customer1);

            Customer customer2 = customerService.findCustomer("Jack");
            List<Product> product2 = productService.findAllProducts();
            customer2.setProducts(product2);
            customerService.updateCustomer(customer2);

            customers.get(2).addProduct(products.get(2));
            customerService.updateCustomer(customers.get(2));

//какие товары покупал клиент
            System.out.println(customer1);
            System.out.println(Arrays.toString(customer1.getProducts().toArray()));

            System.out.println(customer2);
            System.out.println(Arrays.toString(customer2.getProducts().toArray()));

//какие клиенты покупали товар
            System.out.println(product1);
            System.out.println(Arrays.toString(product1.getCustomers().toArray()));

//удаление
            Customer customer3 = customerService.findCustomer("Mike");
            customerService.deleteCustomer(customer3);

            Product product3 = productService.findProduct("apple");
            productService.deleteProduct(product3);
        } finally {
            HibernateSessionFactoryUtil.closeSessionFactory();
        }
    }
}

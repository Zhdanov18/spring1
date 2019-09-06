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
            customerService.buy(customers.get(0).getId(), products.get(0));
            customerService.buy(customers.get(1).getId(), products);
            customerService.buy(customers.get(2).getId(), products.get(2));

//какие товары покупал клиент
            customerService.showProducts(customers.get(0));
            customerService.showProducts(customers.get(1));

//какие клиенты покупали товар
            productService.showCustomers(products.get(0));

//удаление
            customerService.deleteCustomer(customers.get(2));
            productService.deleteProduct(products.get(2));

        } finally {
            HibernateSessionFactoryUtil.closeSessionFactory();
        }
    }
}

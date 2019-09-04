package com.geekbrains.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "products_customers",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    ) private List<Product> products;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        if(products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
        '}';
    }
}

//Без fetch = FetchType.EAGER вот такая ошибка. Help!!!!
//    Exception in thread "main" org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.geekbrains.models.Customer.products, could not initialize proxy - no Session
//        at org.hibernate.collection.internal.AbstractPersistentCollection.throwLazyInitializationException(AbstractPersistentCollection.java:606)
//        at org.hibernate.collection.internal.AbstractPersistentCollection.withTemporarySessionIfNeeded(AbstractPersistentCollection.java:218)
//        at org.hibernate.collection.internal.AbstractPersistentCollection.initialize(AbstractPersistentCollection.java:585)
//        at org.hibernate.collection.internal.AbstractPersistentCollection.write(AbstractPersistentCollection.java:409)
//        at org.hibernate.collection.internal.PersistentBag.add(PersistentBag.java:374)
//        at com.geekbrains.models.Customer.addProduct(Customer.java:58)
//        at com.geekbrains.MainApp.main(MainApp.java:32)

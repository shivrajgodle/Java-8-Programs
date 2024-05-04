package org.example.java8.streamApi;

import java.util.ArrayList;
import java.util.List;

class Product {
    private int id;
    private String name;
    private float price;

    Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}


public class reduceEx {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<Product>();

        products.add(new Product(1,"Mac m1",10000));
        products.add(new Product(2,"DELL",10000));
        products.add(new Product(3,"HP",10000));
        products.add(new Product(4,"Lenavo",10000));
        products.add(new Product(5,"accer",10000));

    }
}

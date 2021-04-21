package ru.geekbrains.hiber.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.hiber.entities.Product;
import ru.geekbrains.hiber.repositories.ProductRepository;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    private ProductRepository productRepository;

    public void  run() {
        List<Product> products = productRepository.list();
        System.out.println("List of products\n");
        System.out.println(products + "\n");
    }
}

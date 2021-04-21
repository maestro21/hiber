package ru.geekbrains.hiber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.hiber.entities.Product;
import ru.geekbrains.hiber.repositories.ProductRepository;
import ru.geekbrains.hiber.services.ShopService;

import java.util.List;

@SpringBootApplication
public class HiberApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiberApplication.class, args);
        ShopService shopService = new ShopService();
        shopService.run();
    }

}

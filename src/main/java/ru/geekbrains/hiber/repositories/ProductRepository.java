package ru.geekbrains.hiber.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.hiber.entities.Product;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class ProductRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public ProductRepository(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    public List<Product> list() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> items = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            return items;
        }
    }


    public void create(String title, int cost) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = new Product(title, cost);
            session.save(product);
            session.getTransaction().commit();
            System.out.println("Created product: " + product);
        }
    }

    public void read(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println("Reading product with id " + id + ":" + product);
            session.getTransaction().commit();
        }
    }

    public void update(Long id, int newCost) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println("Product before update: " + product);
            product.setCost(newCost);
            session.getTransaction().commit();
            System.out.println("Product after update: " + product);
        }
    }

    public void delete(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
            System.out.println("Deleted product: " + product);
        }
    }
}

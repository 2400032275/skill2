package com.klu.HibernateInventory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.HibernateInventory.entity.Product;
import com.klu.HibernateInventory.util.HibernateUtil;

public class ProductDAO {

    // CREATE
    public void addProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(product);

        tx.commit();
        session.close();
    }

    // READ
    public Product getProduct(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    // UPDATE
    public void updateProduct(int id, double newPrice, int newQuantity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product product = session.get(Product.class, id);
        if (product != null) {
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);
            session.update(product);
        } else {
            System.out.println("Product not found!");
        }

        tx.commit();
        session.close();
    }

    // DELETE
    public void deleteProduct(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product product = session.get(Product.class, id);
        if (product != null) {
            session.delete(product);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }

        tx.commit();
        session.close();
    }
}
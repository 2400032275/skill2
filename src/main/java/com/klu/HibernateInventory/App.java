package com.klu.HibernateInventory;

import java.util.Scanner;
import com.klu.HibernateInventory.dao.ProductDAO;
import com.klu.HibernateInventory.entity.Product;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        int choice;

        do {
            System.out.println("\n===== Hibernate CRUD Menu =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Product by ID");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    sc.nextLine();   // clear buffer
                    String name = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    dao.addProduct(new Product(name, desc, price, qty));
                    System.out.println("Product Added Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    Product p = dao.getProduct(id);

                    if (p != null) {
                        System.out.println("Product Details:");
                        System.out.println("ID: " + p.getId());
                        System.out.println("Name: " + p.getName());
                        System.out.println("Description: " + p.getDescription());
                        System.out.println("Price: " + p.getPrice());
                        System.out.println("Quantity: " + p.getQuantity());
                    } else {
                        System.out.println("Product Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID to Update: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();

                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();

                    dao.updateProduct(updateId, newPrice, newQty);
                    System.out.println("Product Updated Successfully!");
                    break;

                case 4:
                    System.out.print("Enter Product ID to Delete: ");
                    int deleteId = sc.nextInt();

                    dao.deleteProduct(deleteId);
                    System.out.println("Product Deleted Successfully!");
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
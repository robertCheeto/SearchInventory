package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Product> inventory = getInventory();

        System.out.println("We have the following items in stock: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product product = inventory.get(i);
            System.out.printf("ID: %d | Item: %s | Price: $%.2f\n", product.getId(), product.getName(), product.getPrice());
        } // end of for loop

    } // end of main()

    // https://www.bezkoder.com/java-sort-arraylist-of-objects/ <- good reference for sorting arrays and putting
    // various data types into an ArrayList if a constructor is being used
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        inventory.add(new Product(001, "Hammer", 2.49f));
        inventory.add(new Product(002, "Nails", 1.99f));
        inventory.add(new Product(003, "Screwdriver", 3.29f));
        inventory.add(new Product(004, "Picture Frame", 5.89f));
        inventory.add(new Product(005, "Gum - 12 Pack", 0.99f));

        return inventory;

    } // end of getInventory

}

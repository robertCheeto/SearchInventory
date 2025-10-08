package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        displayMenu();
        int userInput = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("\n*****\nLoading Menu...\n*****\n");

        switch (userInput) {
            case(1):
                ArrayList<Product> inventory = getInventory();
                System.out.println("We have the following items in stock: \n");
                for (Product product : inventory) {
                    System.out.printf("ID: %d | Item: %s | Price: $%.2f\n", product.getId(), product.getName(), product.getPrice());
                } // end of for loop
            case(2):
                System.out.print("Enter a Product ID you'd like to search for: ");
                productSearch();

        }


    } // end of main()

    // https://www.bezkoder.com/java-sort-arraylist-of-objects/ <- good reference for sorting arrays and putting
    // various data types into an ArrayList if a constructor is being used
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input = "";

            while ((input = bufReader.readLine()) != null) {
                String[] parsedList = input.split("\\|");

                int id = Integer.parseInt(parsedList[0]);
                String name = parsedList[1];
                float price = Float.parseFloat(parsedList[2]);

                inventory.add(new Product(id, name, price));

                Collections.sort(inventory, Comparator.comparing(Product::getName));
                // ask Topher about this function and how it works

            } // end of while loop
            bufReader.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        } // end of try-catch

        return inventory;
    } // end of getInventory

    public static void displayMenu() {
        System.out.println("*****\nWelcome to Bunnings Mate\n*****");
        System.out.println("1) - List All Products");
        System.out.println("2) - Lookup Product by ID");
        System.out.println("3) - Find All Products within Price Range");
        System.out.println("4) - Add New Product");
        System.out.println("5) - Quit the Program");
        System.out.print("\nPlease enter your choice here: ");
    } // end of displayMenu()

    public static ArrayList<Product> productSearch() {
        // wonder if I need to have the array list filled in main for this method to work


    } // end of productSearch()

}

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
        ArrayList<Product> inventory = getInventory();

        System.out.println("We have the following items in stock: \n");
        for (Product product : inventory) {
            System.out.printf("ID: %d | Item: %s | Price: $%.2f\n", product.getId(), product.getName(), product.getPrice());
        } // end of for loop
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

}

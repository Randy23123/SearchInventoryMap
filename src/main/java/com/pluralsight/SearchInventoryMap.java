package com.pluralsight;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
public class SearchInventoryMap {
    public static HashMap<Integer, Product> inventory =
            new HashMap<Integer, Product>();
    public static void main(String[] args) throws IOException {
        loadInventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("What item # are you interested in ? ");
            int id = scanner.nextInt();
            Product matchedProduct = inventory.get(id);
            if (matchedProduct == null) {
                System.out.println("We don't carry that product");
                return;
            }
            System.out.printf("We carry %s and the price is $%.2f", matchedProduct.getName(), matchedProduct.getPrice());

            System.out.println("\nAre there anymore items you would like:");
            String item = scanner.next();
            if (item.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private static void loadInventory() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
        BufferedReader buffReader = new BufferedReader(fileReader);
        String input;

        String productName;
        int productID;
        double productPrice;
        while ((input = buffReader.readLine()) != null){
            String[] temp = input.split("\\|");
            productID = Integer.parseInt(temp[0]);
            productName = temp[1];
            productPrice = Double.parseDouble(temp[2]);
            inventory.put(productID,new Product(productID, productName, productPrice));
        }
    }
}
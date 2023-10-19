package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SearchInventoryMap {
    public static void main(String[] args) throws IOException {
        ArrayList<Map> inventory = getInventory();
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
            inventory.add(new Map(productID, productName, productPrice));
        }

        System.out.println("We carry: ");

        for (Map p : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f\n", p.getId(), p.getName(), p.getPrice());
        }
    }
    private static ArrayList<Map> getInventory() {
        return new ArrayList<>();
    }
}

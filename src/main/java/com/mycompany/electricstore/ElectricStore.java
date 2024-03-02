/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.electricstore;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rahul & Xin
 */
public class ElectricStore {

    public static void addMoreAddOns(HashMap<Integer, String> addOnMap) {
        for (HashMap.Entry<Integer, String> entry : addOnMap.entrySet()) {
            Integer key = entry.getKey();
            String[] value = entry.getValue().split(",");
            System.out.println(key + ".  " + value[0] + " $" + value[1]);
        }
    }

    public static HashMap<String, Double> returnPriceMap(String fileName) throws FileNotFoundException {
        File inputFile = new File(fileName);
        Scanner fileReader = new Scanner(inputFile);
        HashMap<String, Double> products = new HashMap<>();
        while (fileReader.hasNextLine()) {
            String fileData = fileReader.nextLine();
            Object[] fileDataArray = fileData.split(" ");
            products.put(fileDataArray[0].toString(), Double.valueOf(fileDataArray[1].toString()));
        }
        return products;
    }

    public static Equipment returnBasicProduct(String name) {
        Equipment equipment = null;
        switch (name) {
            case "Laptop" ->
                equipment = new BasicLaptop();
            case "Printer" ->
                equipment = new Printer();
            case "Scanner" ->
                equipment = new Scaner();
            case "Desktop" ->
                equipment = new Desktop();
        }
        return equipment;
    }

    public static Boolean checkAddons(String productName) throws FileNotFoundException {
        Boolean hasAddons = false;
        String subscribersFile = FilePaths.PRODUCTADDONS.getPath();

        File inputFile = new File(subscribersFile);
        Scanner fileReader = new Scanner(inputFile);
        while (fileReader.hasNextLine()) {
            String[] itemArray = fileReader.nextLine().split(" ");
            if (productName.equals(itemArray[0])) {
                hasAddons = true;
            }
        }
        fileReader.close();
        return hasAddons;
    }

    public static Equipment getAddOn(Equipment equipment, String addOnName) {
        String[] addOn = addOnName.split(",");
        switch (addOn[0]) {
            case "SSD(250GB)" ->
                equipment = new SSD(equipment, Double.valueOf(addOn[1]));
            case "Mouse" ->
                equipment = new Mouse(equipment, Double.valueOf(addOn[1]));
            case "Keyboard" ->
                equipment = new Keyboard(equipment, Double.valueOf(addOn[1]));
            case "LaptopCover" ->
                equipment = new LaptopCover(equipment, Double.valueOf(addOn[1]));
            case "Earphones" ->
                equipment = new Earphones(equipment, Double.valueOf(addOn[1]));
            case "1YearWarranty" ->
                equipment = new Waranty(equipment, Double.valueOf(addOn[1]));
            case "HardDisk(1TB)" ->
                equipment = new HardDisk(equipment, Double.valueOf(addOn[1]));
            case "Speakers" ->
                equipment = new Speaker(equipment, Double.valueOf(addOn[1]));
            case "Cartridge" ->
                equipment = new Cartridge(equipment, Double.valueOf(addOn[1]));
            default -> {
            }
        }
        return equipment;
    }

    public static Equipment purchaseAddons(Equipment equipment, String productName, Scanner scanner) throws FileNotFoundException {
        String productAddons = FilePaths.PRODUCTADDONS.getPath();
        File inputFile = new File(productAddons);
        Scanner fileReader = new Scanner(inputFile);
        String[] addOns = null;
        while (fileReader.hasNextLine()) {
            String[] addOnArray = fileReader.nextLine().split(" ");
            if (addOnArray[0].equals(productName)) {
                addOns = addOnArray;
            }
        }

        HashMap<Integer, String> addOnMap = new HashMap<>();
        Integer count = 1;
        for (int i = 1; i < addOns.length; i++) {
            addOnMap.put(count, addOns[i]);
            count++;
        }

        System.out.println("Please povide the number for addon you wish to purchase or enter 0 to return to the previous menu");
        addMoreAddOns(addOnMap);

        String addOnNum = scanner.next();
        while (!addOnNum.equals("0")) {
            String addOn = addOnMap.get(Integer.valueOf(addOnNum));
            equipment = getAddOn(equipment, addOn);
            System.out.println("item added successfully.");
            System.out.println("Do you wish to add more items? y/n");
            String addMoreItems = scanner.next();
            if (addMoreItems.equals("y")) {
                System.out.println("Please povide the number for addon you wish to purchase or enter 0 to return to the previous menu");
                addMoreAddOns(addOnMap);
                addOnNum = scanner.next();
            } else {
                addOnNum = "0";
            }

        }
        return equipment;
    }

    public static void viewSubscribers() throws FileNotFoundException, IOException {
        // reads subscribers from a file and displays their names, also writes those names to an output file
        String subscribersFile = FilePaths.SUBSCRIBERS.getPath();
        File inputFile = new File(subscribersFile);
        Scanner fileReader = new Scanner(inputFile);
        String fileData = "***********Subscribers***********\n";

        while (fileReader.hasNextLine()) {
            fileData += fileReader.nextLine() + "\n";
        }

        System.out.println(fileData);
        fileReader.close();
    }

    public static void viewProducts() throws FileNotFoundException, IOException {
        // reads products from a file and displays those products along with their prices
        String subscribersFile = FilePaths.BASICPRODUCTS.getPath();
        File inputFile = new File(subscribersFile);
        Scanner fileReader = new Scanner(inputFile);
        String fileData = "***********Products***********\n";

        while (fileReader.hasNextLine()) {
            String[] itemArray = fileReader.nextLine().split(" ");
            fileData += itemArray[0] + " $" + itemArray[1] + "\n";
            System.out.println(itemArray[0] + " $" + itemArray[1] + "\n");
        }

        fileReader.close();
    }

    public static void updateSubscribers() throws FileNotFoundException {
        Store store = new Store();
        File subscribers = new File(FilePaths.SUBSCRIBERS.getPath());
        String discountInfo = "";
        File discountInfoFile = new File(FilePaths.DISCOUNTINFO.getPath());
        Scanner fileReader = new Scanner(discountInfoFile);
        while (fileReader.hasNextLine()) {
            discountInfo = fileReader.nextLine();
        }
        fileReader = new Scanner(subscribers);
        while (fileReader.hasNextLine()) {
            String fileData = fileReader.nextLine();
            Customer customer = new Customer();
            customer.setName(fileData);
            customer.setName(fileData);
            store.subscribe(customer);
        }
        File equipments = new File(FilePaths.PRODUCTPRICES.getPath());
        fileReader = new Scanner(equipments);
        ArrayList<String[]> products = new ArrayList<>();
        while (fileReader.hasNextLine()) {
            String[] fileData = fileReader.nextLine().split(" ");
            fileData[1] = "  $" + fileData[1] + "\n";
            products.add(fileData);
        }
        store.setProducts(products);
        store.setDiscountInfo(discountInfo);
        store.notifyObservers();
        System.out.println("Subscribers have been notified\n");
    }

    public static void createOrders(Scanner scanner) throws FileNotFoundException, IOException {
        // function used to create orders
        String inputFileName = FilePaths.BASICPRODUCTS.getPath();
        // store product name and price in hashmap
        HashMap<String, Double> productPrices = returnPriceMap(inputFileName);
        HashMap<Integer, String> products = new HashMap<>();
        Integer count = 1;
        // create key, value pair for product and product id
        for (HashMap.Entry<String, Double> product : productPrices.entrySet()) {
            products.put(count, product.getKey() + " $" + product.getValue());
            count++;
        }

        // display menu to user for selecting the product they want
        System.out.println("Please povide the number for product you wish to purchase or enter 0 to return to the previous menu");
        for (HashMap.Entry<Integer, String> entry : products.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ".  " + value);
        }

        // prepare object of the product selected by user
        String productNum = "99";
        while (!productNum.equals("0")) {
            productNum = scanner.next();
            switch (productNum) {
                case "1" -> {
                    System.out.println("here");
                    String productName = products.get(Integer.valueOf(productNum));
                    productName = productName.split(" ")[0];
                    System.out.println(productName);
                    Equipment equipment = returnBasicProduct(productName);
                    equipment.setBasicPrice(productPrices.get(productName));
                    equipment.setPricingStrategy(new DiscountRate(10.0));
                    // check whether product has addons
                    Boolean hasAddons = checkAddons(productName);
                    if (hasAddons == true) {
                        equipment = purchaseAddons(equipment, productName, scanner);
                    }
                    System.out.println("Order created successfully");
                    String message = equipment.getDescription() + "\nAmount: $" + equipment.getPrice();
                    FileWriter fileWriter = new FileWriter(FilePaths.ORDEROUTPUT.getPath(), true);
                    BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
                    bufferWriter.write(message);
                    bufferWriter.newLine();
                    bufferWriter.close();
                    productNum = "0";
                }
                case "2" -> {
                    String productName = products.get(Integer.valueOf(productNum));
                    productName = productName.split(" ")[0];
                    System.out.println(productName);
                    Equipment equipment = returnBasicProduct(productName);
                    equipment.setBasicPrice(productPrices.get(productName));
                    equipment.setPricingStrategy(new NormalRate());
                    // check whether product has addons
                    Boolean hasAddons = checkAddons(productName);
                    if (hasAddons == true) {
                        equipment = purchaseAddons(equipment, productName, scanner);
                    }
                    System.out.println("Order created successfully");
                    String message = equipment.getDescription() + "\nAmount: $" + equipment.getPrice();
                    FileWriter fileWriter = new FileWriter(FilePaths.ORDEROUTPUT.getPath(), true);
                    BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
                    bufferWriter.write(message);
                    bufferWriter.newLine();
                    bufferWriter.close();
                    productNum = "0";
                }
                case "3" -> {
                    String productName = products.get(Integer.valueOf(productNum));
                    productName = productName.split(" ")[0];
                    System.out.println(productName);
                    Equipment equipment = returnBasicProduct(productName);
                    equipment.setBasicPrice(productPrices.get(productName));
                    equipment.setPricingStrategy(new NormalRate());
                    // check whether product has addons
                    Boolean hasAddons = checkAddons(productName);
                    if (hasAddons == true) {
                        equipment = purchaseAddons(equipment, productName, scanner);
                    }
                    System.out.println("Order created successfully");
                    String message = equipment.getDescription() + "\nAmount: $" + equipment.getPrice();
                    FileWriter fileWriter = new FileWriter(FilePaths.ORDEROUTPUT.getPath(), true);
                    BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
                    bufferWriter.write(message);
                    bufferWriter.newLine();
                    bufferWriter.close();
                    productNum = "0";
                }
                case "4" -> {
                    String productName = products.get(Integer.valueOf(productNum));
                    productName = productName.split(" ")[0];
                    System.out.println(productName);
                    Equipment equipment = returnBasicProduct(productName);
                    equipment.setBasicPrice(productPrices.get(productName));
                    equipment.setPricingStrategy(new NormalRate());
                    // check whether product has addons
                    Boolean hasAddons = checkAddons(productName);
                    if (hasAddons == true) {
                        equipment = purchaseAddons(equipment, productName, scanner);
                    }
                    System.out.println("Order created successfully");
                    String message = equipment.getDescription() + "\nAmount: $" + equipment.getPrice();
                    FileWriter fileWriter = new FileWriter(FilePaths.ORDEROUTPUT.getPath(), true);
                    BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
                    bufferWriter.write(message);
                    bufferWriter.newLine();
                    bufferWriter.close();
                    productNum = "0";
                }
                case "0" ->
                    System.out.println("returning to previous menu");
                default ->
                    System.out.println("Invalid option");
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Welcome to electric store management system\n");
        Scanner scanner = new Scanner(System.in);
        String choice = "init";

        try {
            while (!choice.equals("quit")) {
                System.out.println("Please povide the number for the action you wish to perform or type quit to terminate");
                System.out.println("1. View Subscribers\n2. View Products\n3. Update Subscribers\n4. Create an order");
                choice = scanner.next();
                switch (choice) {
                    case "1" -> {
                        viewSubscribers();
                    }
                    case "2" -> {
                        viewProducts();
                    }
                    case "3" -> {
                        updateSubscribers();
                    }
                    case "4" -> {
                        createOrders(scanner);
                    }
                    case "quit" ->
                        System.out.println("terminating");
                    default ->
                        System.out.println("Invalid option");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ElectricStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        scanner.close();
    }
}

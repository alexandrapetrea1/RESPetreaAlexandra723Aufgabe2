package Ui;

import Controller.ShinobiController;
import Model.Product;
import Model.Character;

import java.util.*;

public class ShinobiUi {
    private final Scanner scanner;
    private final ShinobiController controller;

    public ShinobiUi(ShinobiController controller) {
        this.scanner = new Scanner(System.in);
        this.controller = controller;
    }

    public void start() {
        while (true) {
            System.out.println("\nSchinobi Administration System");
            System.out.println("1. Product Administration");
            System.out.println("2. Character Administration");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Avoid scanner issues

            switch (choice) {
                case 1 -> productAdministration();
                case 2 -> characterAdministration();
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void productAdministration() {
        while (true) {
            System.out.println("\nProduct Administration");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Get Product by Name");
            //System.out.println("6. Sort Products for Character by Price");
            System.out.println("9. Back");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addProductUI();
                case 2 -> viewProductsUi();
                case 3 -> updateProductUI();
                case 4 -> deleteProductUI();
                case 5 -> getProductById();
                //case 6 -> sortProductsFromCharacterUi();
                case 9 -> { return; }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }


    private void characterAdministration() {
        while (true) {
            System.out.println("\nCharacter Administration");
            System.out.println("1. Add Character");
            System.out.println("2. View All Characters");
            System.out.println("3. Update Character");
            System.out.println("4. Delete Character");
            System.out.println("5. Get Character by ID");
            System.out.println("7. Add Product to Character");
            System.out.println("8. Filter Characters by Region");
            System.out.println("9. View Characters with Products from a Specific Region");
            System.out.println("11. Back");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addCharacterUI();
                case 2 -> viewCharactersUI();
                case 3 -> updateCharacterUI();
                case 4 -> deleteCharacterUI();
                case 5 -> getCharacterById();
                case 7 -> addProductToCharacterUi();
                case 8 -> filterCharactersByRegionUi();
                case 9 -> getCharactersByProductRegionUi();
                case 11 -> { return; }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void getCharactersByProductRegionUi() {
        System.out.print("Enter region name: ");
        String region = scanner.nextLine();
        List<Character> characters = controller.getCharactersByProductRegion(region);

        if (characters.isEmpty()) {
            System.out.println("No characters found.");
        } else {
            System.out.println("Characters who own products from " + region + ":");
            characters.forEach(System.out::println);
        }
    }




    private void filterCharactersByRegionUi() {
        System.out.print("Enter region to filter by: ");
        String region = scanner.nextLine();
        List<Character> filteredCharacters = controller.getCharacterByPlace(region);

        if (filteredCharacters.isEmpty()) {
            System.out.println("No characters found.");
        } else {
            System.out.println("Characters from " + region + ":");
            filteredCharacters.forEach(System.out::println);
        }
    }





    private void addCharacterUI() {
        System.out.print("Enter Character ID: ");
        int characterId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Character name: ");
        String name = scanner.nextLine();
        System.out.print("Enter origin: ");
        String origin = scanner.nextLine();

        controller.addCharacter(characterId, name, origin);
        System.out.println("Character added successfully.");
    }

    private void viewCharactersUI() {
        List<Character> characters = controller.getAllCharacters();
        if (characters.isEmpty()) {
            System.out.println("No characters available.");
        } else {
            for (Character character : characters) {
                System.out.println(character);
            }
        }
    }

    private void updateCharacterUI() {
        System.out.print("Enter Character ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new region: ");
        String region = scanner.nextLine();

        controller.updateCharacter(new Character(id, name, region));
        System.out.println("Character updated successfully.");
    }

    private void deleteCharacterUI() {
        System.out.print("Enter Character ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        controller.deleteCharacter(id);
        System.out.println("Character deleted successfully.");
    }

    private void getCharacterById() {
        System.out.print("Enter Character ID: ");
        int characterId = scanner.nextInt();
        scanner.nextLine();

        Character character = controller.getCharacterById(characterId);
        if (character != null) {
            System.out.println(character);
        } else {
            System.out.println("Character not found.");
        }
    }



    private void addProductToCharacterUi() {
        System.out.print("Enter Character ID: ");
        int characterId = scanner.nextInt();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        controller.addProductToCharacter(characterId, name);
    }

    private void addProductUI() {
        System.out.print("Enter Product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter origin region: ");
        String originRegion = scanner.nextLine();

        controller.addProduct(name, price, originRegion);
        System.out.println("Product added successfully.");
    }

    private void viewProductsUi() {
        List<Product> products = controller.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            products.forEach(System.out::println);
        }
    }

    private void getProductById() {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        Product product = controller.getProductByName(name);

        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found.");
        }
    }

    private void updateProductUI() {
        System.out.println("Enter Product Name: ");
        String name = scanner.nextLine();
        Product product = controller.getProductByName(name);
        System.out.print("Enter new name: ");
        String nume = scanner.nextLine();
        System.out.print("Enter new price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter new origin region: ");
        String originRegion = scanner.nextLine();

        controller.updateProduct(new Product(nume, price, originRegion));
        System.out.println("Product updated successfully.");
    }

    private void deleteProductUI() {
        System.out.print("Enter Product Name to delete: ");
        String name = scanner.nextLine();
        controller.deleteProduct(name);
        System.out.println("Product deleted successfully.");
    }
}

package Controller;

import Model.Product;
import Model.Character;
import Repository.CharacterRepository;
import Repository.ProductRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * GameController manages the business logic of the Game of Thrones trading system.
 */

public class ShinobiController {
    private ProductRepository productRepo;
    private CharacterRepository characterRepo;

    /**
     * Constructs the GameController with given repositories.
     *
     * @param productRepo   The product repository.
     * @param characterRepo The character repository.
     */
    public ShinobiController(ProductRepository productRepo, CharacterRepository characterRepo) {
        this.productRepo = productRepo;
        this.characterRepo = characterRepo;
    }

    /**
     * Adds a new product.
     */
    public void addProduct( String name, double price, String region){
        productRepo.add(new Product( name, price, region));
    }


    /**
     * Updates a product.
     */
    public void updateProduct(Product product) {
        productRepo.update(product);
    }


    /**
     * Deletes a product by ID.
     */
    public void deleteProduct(String name) {
        Product product = productRepo.findByIdentifier(name);
        if (product != null) {
            productRepo.remove(product);
        }else {
            System.out.println("Product with name " + name + " not found.");
        }
    }



    /**
     * Finds a product by ID.
     */
    public Product getProductByName(String name) {
        return productRepo.findByIdentifier(name);
    }


    /**
     * Returns all products.
     */
    public List<Product> getAllProducts() {
        return productRepo.getAll();
    }


    /**
     * Adds a product to a character's inventory.
     */
    public void addProductToCharacter(int characterId, String name) {
        Character character = characterRepo.findByIdentifier(characterId);
        Product product = productRepo.findByIdentifier(name);
        if (character != null && product != null) {
            character.addProduct(product);
            System.out.println("Product added to Character successfully.");
        } else {
            System.out.println("Product or Character not found.");
        }

    }

    /**
     * Adds a new character.
     */
    public void addCharacter(int characterId, String name, String origin_region ) {
        characterRepo.add(new Character(characterId, name,origin_region));
    }


    /**
     * Updates a character.
     */
    public void updateCharacter(Character character) {
        characterRepo.update(character);
    }

    /**
     * Deletes a character by ID.
     */
    public void deleteCharacter(int id) {
        Character character = characterRepo.findByIdentifier(id);
        if (character != null) {
            characterRepo.remove(character);
        }else {
            System.out.println("Character with ID " + id + " not found.");
        }
    }

    /**
     * Finds a character by ID.
     */
    public Character getCharacterById(int id) {
        return characterRepo.findByIdentifier(id);
    }


    /**
     * Returns all characters.
     */
    public List<Character> getAllCharacters() {
        return characterRepo.getAll();
    }


    /**
     * Returns all characters from a given origin place.
     */
    public List<Character> getCharacterByPlace(String originRegion) {
        List<Character> filteredCharacters = new ArrayList<>();
        for (Character character : characterRepo.getAll()) {
            if (character.getOriginPlace().equalsIgnoreCase(originRegion)) {
                filteredCharacters.add(character);
            }
        }
        return filteredCharacters;
    }



}

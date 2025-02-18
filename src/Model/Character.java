package Model;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a character in the Game of Thrones trading network.
 */
public class Character {
    private int characterId;
    private String name;
    private String originPlace;
    private List<Product> products;


    /**
     * Constructs a new Character with the given parameters.
     *
     * @param characterId Unique identifier of the character.
     * @param name        Name of the character.
     * @param originPlace The place where the character originates.
     */
    public Character(int characterId, String name, String originPlace) {
        this.characterId = characterId;
        this.name = name;
        this.originPlace = originPlace;
        products = new ArrayList<>();
    }


    /**
     * Gets the character ID.
     *
     * @return character ID.
     */
    public int getCharacterId() {
        return characterId;
    }


    /**
     * Sets the character ID.
     *
     * @param characterId New character ID.
     */
    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }


    /**
     * Gets the name of the character.
     *
     * @return character name.
     */
    public String getName() {
        return name;
    }


    /**
     * Sets a new name for the character.
     *
     * @param name New character name.
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets the place of origin of the character.
     *
     * @return character's origin place.
     */
    public String getOriginPlace() {
        return originPlace;
    }

    /**
     * Sets a new place of origin for the character.
     *
     * @param originPlace New place of origin.
     */
    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    /**
     * Gets the list of products owned by the character.
     *
     * @return list of products.
     */
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    /**
     * Sets the list of products owned by the character.
     *
     * @param products New list of products.
     */
    public void setProducts(List<Product> products) {
        this.products = new ArrayList<>(products);
    }


    /**
     * Returns a string representation of the character.
     *
     * @return formatted string with character details.
     */
    @Override
    public String toString() {
        return "Character [ID=" + characterId + ", Name=" + name + ", Origin=" + originPlace +
                ", Products=" + products + "]";
    }

    /**
     * Adds a product to the character's inventory.
     *
     * @param product Product to add.
     */
    public void addProduct(Product product) {
        this.products.add(product);
    }


}

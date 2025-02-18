package Model;


/**
 * Represents a product in the Game of Thrones trading network.
 */
public class Product {
    private String name;
    private double price;
    private String region;

    /**
     * Constructs a new Product with the given parameters.
     *
     * @param name      Name of the product.
     * @param price     Price of the product.
     * @param region    Region where the product originates.
     */

    public Product( String name, double price, String region) {
        this.name = name;
        this.price = price;
        this.region = region;

    }


    public String getName() {
        return name;
    }

    /**
     * Sets a new name for the product.
     *
     * @param name New product name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the product.
     *
     * @return product price.
     */
    public double getPrice() {
        return price;
    }


    /**
     * Sets a new price for the product.
     *
     * @param price New product price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the region of origin of the product.
     *
     * @return product region.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets a new region for the product.
     *
     * @param region New product region.
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Returns a string representation of the product.
     *
     * @return formatted string with product details.
     */
    @Override
    public String toString() {
        return "Product [ Name=" + name + ", Price=" + price + ", Region=" + region + "]";
    }
}

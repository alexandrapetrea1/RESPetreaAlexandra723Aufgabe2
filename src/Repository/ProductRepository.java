package Repository;


import Model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository for managing products in the Game of Thrones trading network.
 */

public class ProductRepository implements IRepository<Product,String> {
    private List<Product> products = new ArrayList<>();


    /**
     * Adds a new product to the repository.
     *
     * @param product The product to add.
     */
    @Override
    public void add(Product product) {
        products.add(product);
    }


    /**
     * Removes a product from the repository.
     *
     * @param product The product to remove.
     */
    @Override
    public void remove(Product product) {
        products.remove(product);
    }

    /**
     * Returns a list of all products in the repository.
     * A copy of the list is returned to prevent external modifications.
     *
     * @return List of products.
     */
    @Override
    public List<Product> getAll() {
        return products;
    }


    /**
     * Finds a product by ID.
     *
     * @param name The ID of the product.
     * @return The product if found, otherwise null.
     */
    @Override
    public Product findByIdentifier(String name) {
        return products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Updates an existing product in the repository.
     * If the product is found, its name, price, and region are updated.
     *
     * @param product The product with updated values.
     */
    @Override
    public void update(Product product) {
        Product existing = findByIdentifier(product.getName());
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setRegion(product.getRegion());
        }
    }
}

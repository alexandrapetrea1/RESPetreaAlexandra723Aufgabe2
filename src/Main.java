import Controller.ShinobiController;
import Model.Product;
import Repository.CharacterRepository;
import Repository.ProductRepository;
import Ui.ShinobiUi;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CharacterRepository characterRepo = new CharacterRepository();
        ProductRepository productRepo = new ProductRepository();
        ShinobiController controller = new ShinobiController(productRepo, characterRepo);

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Kunai", 50.0, "Konoha"));
        productList.add(new Product("Shuriken", 30.0, "Konoha"));
        productList.add(new Product("Schwert", 200.0, "Kirigakure"));
        productList.add(new Product("Heiltrank", 100.0, "Sunagakure"));
        productList.add(new Product("Sprengsiegel", 75.0, "Iwagakure"));
        productList.add(new Product("Riesenfächer", 300.0, "Sunagakure"));
        productList.add(new Product("Giftklinge", 150.0, "Kirigakure"));
        productList.add(new Product("Explosionskugel", 250.0, "Iwagakure"));
        productList.add(new Product("Schattendolch", 180.0, "Konoha"));
        productList.add(new Product("Wasserperle", 90.0, "Kirigakure"));


        for (Product p : productList) {
            productRepo.add(p);
        }

        List<Model.Character> characterList = new ArrayList<>();

        Model.Character c1 = new Model.Character(1, "Naruto Uzumaki", "Konoha");
        c1.addProduct(productList.get(8)); // Schattendolch
        c1.addProduct(productList.get(5)); // Riesenfächer

        Model.Character c2 = new Model.Character(2, "Gaara", "Sunagakure");
        c2.addProduct(productList.get(2)); // Schwert
        c2.addProduct(productList.get(4)); // Sprengsiegel
        c2.addProduct(productList.get(6)); // Giftklinge
        c2.addProduct(productList.get(1)); // Shuriken

        Model.Character c3 = new Model.Character(3, "Kisame Hoshigaki", "Kirigakure");
        c3.addProduct(productList.get(1)); // Shuriken
        c3.addProduct(productList.get(2)); // Schwert
        c3.addProduct(productList.get(3)); // Heiltrank
        c3.addProduct(productList.get(7)); // Explosionskugel
        c3.addProduct(productList.get(9)); // Wasserperle

        Model.Character c4 = new Model.Character(4, "Deidara", "Iwagakure");
        c4.addProduct(productList.get(0)); // Kunai
        c4.addProduct(productList.get(4)); // Sprengsiegel
        c4.addProduct(productList.get(7)); // Explosionskugel
        c4.addProduct(productList.get(9)); // Wasserperle

        Model.Character c5 = new Model.Character(5, "Itachi Uchiha", "Konoha");
        c5.addProduct(productList.get(8)); // Schattendolch
        c5.addProduct(productList.get(6)); // Giftklinge
        c5.addProduct(productList.get(2)); // Schwert
        c5.addProduct(productList.get(7)); // Explosionskugel

        characterRepo.add(c1);
        characterRepo.add(c2);
        characterRepo.add(c3);
        characterRepo.add(c4);
        characterRepo.add(c5);

        ShinobiUi ui = new ShinobiUi(controller);
        ui.start();
    }
}

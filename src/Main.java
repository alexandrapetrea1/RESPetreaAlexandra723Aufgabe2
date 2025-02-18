import Ui.ShinobiUi;
import Controller.ShinobiController;
import Repository.ProductRepository;
import Repository.CharacterRepository;

public class Main {
    public static void main(String[] args) {
        CharacterRepository characterRepo = new CharacterRepository();
        ProductRepository productRepo = new ProductRepository();
        ShinobiController controller = new ShinobiController(productRepo, characterRepo);
        ShinobiUi ui = new ShinobiUi(controller);
        ui.start();
    }
}

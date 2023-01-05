import controller.Controller;
import view.UI;

public class Main {

    public static void main(String[] args) {
        UI view = new UI();

        new Controller(view);
    }
}
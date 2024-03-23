package src;

import src.Controller.UserController;
import src.Utils.Config;

public class Main {
    public static void main(String[] args) {

        UserController userController = new UserController();
        userController.Application();

        Config.closeScannerInput();
        return;
    }
}

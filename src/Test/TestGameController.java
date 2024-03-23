package src.Test;

import src.Controller.GameController;
import src.Utils.Config;
import src.Utils.HandleData;

public class TestGameController {
    public static void main(String[] args) {
        //String path = "src/Data/UserTemp/v/9x9.txt";
        String path = "src/Data/User/admin/testStageGame.txt";
        GameController gameController = new GameController(HandleData.readDataFromFile(path), "admin");
        gameController.Application();
        if (Config.getScannerInput() != null) {
            Config.closeScannerInput();
        }
        return;
    }
}

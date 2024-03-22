package src.Test;

import src.Controller.GameController;
import src.Utils.HandleData;

public class TestGameController {
    public static void main(String[] args) {
        //String path = "src/Data/UserTemp/v/9x9.txt";
        String path = "src/Data/UserTemp/v/test.txt";
        GameController gameController = new GameController(HandleData.readDataFromFile(path), "V");
        gameController.Application();
        return;
    }
}

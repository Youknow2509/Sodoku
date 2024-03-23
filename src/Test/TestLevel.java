package src.Test;

import src.Controller.LevelController;
import src.Utils.Config;

public class TestLevel {
    public static void main(String[] args) {
        LevelController levelController = new LevelController("admin");
        levelController.Application();

        Config.closeScannerInput();
        return;
    }
}

package src.Test;

import src.Controller.LevelController;

public class TestLevel {
    public static void main(String[] args) {
        LevelController levelController = new LevelController("admin");
        levelController.Application();
        return;
    }
}

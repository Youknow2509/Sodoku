package src.Controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import src.Model.ChangeScene;
import src.Model.Game;

public class LevelController {

    public void level1(MouseEvent e) {
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai
        ChangeScene c = new ChangeScene(stage, "/src/View/Game.fxml");
        c.change(12, 3, "Level 1");
    }

    public void level2(MouseEvent e) {
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai
        ChangeScene c = new ChangeScene(stage, "/src/View/Game.fxml");
        c.change(20, 5, "Level 2");
    }

    public void level3(MouseEvent e) {
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai
        ChangeScene c = new ChangeScene(stage, "/src/View/Game.fxml");
        c.change(30, 6, "Level 3");
    }

    public void developTest(MouseEvent e) {
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai
        ChangeScene c = new ChangeScene(stage, "/src/View/GameDevelop.fxml");
        c.change();
    }

    public void backtomain(MouseEvent e) {
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai
        ChangeScene c = new ChangeScene(stage, "/src/View/MainGame.fxml");
        c.change();
    }
}
package src.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import src.Model.ChangeScene;

public class MainGameController {

    public void playgame(MouseEvent e) {
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai
        ChangeScene c = new ChangeScene(stage, "/src/View/Level.fxml");
        c.change();
    }

    public void exitgame(MouseEvent e) {
        System.exit(0);
    }

    public void contact(MouseEvent e) {
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai
        ChangeScene c = new ChangeScene(stage, "/src/View/Contact.fxml");
        c.change();
    }
}
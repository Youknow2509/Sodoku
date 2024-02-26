package src.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import src.Model.ChangeScene;

public class ContactController {

    public void backtomain(MouseEvent e) {
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        ChangeScene c = new ChangeScene(stage, "/src/View/MainGame.fxml");
        c.change();
    }
}
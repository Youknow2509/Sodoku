package src.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    // Var fxml
    @FXML
    private AnchorPane anchorPane;

    // Var

    //
    public void initialize() {

    }
    // play new game
    public void playNewGame(ActionEvent e) {
        changeStage("PlayNew");
    }

    // play continue game
    public void playContinueGame(ActionEvent e) {
        changeStage("ListGameUsers/ListGameUsers");
    }

    // Exit
    public void exit(ActionEvent e) {
        System.exit(0);
    }

    // change stage
    private void changeStage(String name) {
        String path = "/src/View/" + name + ".fxml";

        try {
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

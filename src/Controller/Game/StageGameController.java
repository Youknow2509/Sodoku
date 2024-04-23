package src.Controller.Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class StageGameController {
    // Var fxml
    @FXML
    private Text TextStage;
    @FXML
    private AnchorPane anchorPane;

    // Var
    private String s;
    private Stage stageGame;
    // Init
    public void initialize(int n, Stage stage) {
        switch (n) {
            case 1:
                s = "WIN";
                break;
            case 0:
                s = "LOSE";
                break;
            default:
                s = "ERROR";
                break;
        }
        stageGame = stage;
        TextStage.setText(s);

    }

    //
    @FXML
    public void goHome(ActionEvent event) {
        helpGoHome();
    }

    @FXML
    public void Exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    // Help go Home
    private void helpGoHome() {
        try {
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            stage.close();

            Parent root = FXMLLoader.load(getClass().getResource("/src/View/Home.fxml"));
            stageGame.setScene(new Scene(root));
            stageGame.centerOnScreen();
            stageGame.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

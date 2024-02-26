package src;

import src.Controller.GameController;
import src.Model.ChangeScene;
import src.Model.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage primaryStage){
        System.out.println("Start Game");
        ChangeScene c = new ChangeScene(primaryStage, "/src/View/MainGame.fxml");
        c.change();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

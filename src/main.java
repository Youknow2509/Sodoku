package src;

import src.Model.ChangeScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage primaryStage){
        System.out.println("StartGame");
        ChangeScene c = new ChangeScene(primaryStage, "/src/View/MainGame.fxml");
        c.change();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

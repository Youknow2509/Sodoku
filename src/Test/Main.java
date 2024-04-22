package src.Test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.Controller.Game.GameController;
import src.DataGame.Handle.HandleData;
import src.DataGame.Handle.HandleDataSql;
import src.Utils.CoppyValueNodeGame;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        String nameFile = "Home.fxml";

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/" + nameFile));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Test View");
        stage.show();
        stage.centerOnScreen();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

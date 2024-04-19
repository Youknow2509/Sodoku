package src.Test;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        String nameFile = "Game9x9.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/" + nameFile));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Test View");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

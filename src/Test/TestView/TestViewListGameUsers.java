package src.Test.TestView;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.Controller.GameController;
import src.Utils.CoppyValueNodeGame;

public class TestViewListGameUsers extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        String nameFile = "ListGameUsers.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../View/ListGameUsers/" + nameFile));
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

package src.Test.TestView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.Controller.GamController;

public class TestViewGame extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        int SIZE = 16;
        String nameFile = "Game" + SIZE + "x" + SIZE + ".fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../View/" + nameFile));
        Parent root = loader.load();
        GamController controller = loader.getController();
        controller.initialize(SIZE);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Test View");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package src.Test.TestView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        stage.centerOnScreen();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

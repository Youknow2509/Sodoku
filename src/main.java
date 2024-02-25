package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage primaryStage){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainGame.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 720, 648); // 3840, 2160 | 720, 648 | 1080, 972 | 1920, 1080

            primaryStage.setScene(scene);
            primaryStage.setTitle("Game Sudoku");
            primaryStage.show();

        } catch (Exception e) {
            System.out.println("Err: " + e);
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}

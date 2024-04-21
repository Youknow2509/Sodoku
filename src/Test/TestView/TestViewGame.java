package src.Test.TestView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.Controller.GameController;
import src.DataGame.Handle.HandleDataSql;
import src.DataGame.Handle.HandleDta;
import src.Utils.CoppyValueNodeGame;

public class TestViewGame extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        HandleDta handleDta = new HandleDataSql();
        int SIZE = 9;
        String nameFile = "Game" + SIZE + "x" + SIZE + ".fxml";

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../View/" + nameFile));
        Parent root = loader.load();
        GameController controller = loader.getController();
        controller.initialize(CoppyValueNodeGame.coppyGame(handleDta.getGame().get(0)));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Test View");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

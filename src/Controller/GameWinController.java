package src.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.Model.ChangeScene;

public class GameWinController {

    public void backtolevel(ActionEvent e) {
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai
        ChangeScene c = new ChangeScene(stage, "/src/View/level/level.fxml");
        c.change();
    }

    public void exitGame(ActionEvent e) {
        System.out.print("exit");
        System.exit(0);
    }

}
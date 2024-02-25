package src.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameLoseController {
    public void backtolevel(ActionEvent e) {
        System.out.println("Back to level");

        try {
            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/level/level.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 720, 648);

            stage.setScene(scene);
            stage.setTitle("Game Sudoku");
            stage.show();

        } catch (Exception err) {
            System.out.println("Err: " + err);
        }
    }

    public void exitGame(ActionEvent e) {
        System.out.print("exit");
        System.exit(0);
    }
}
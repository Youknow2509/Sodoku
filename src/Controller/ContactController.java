package src.Controller.;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ContactController {

    public void backtomain(MouseEvent e) {

        System.out.println("Contact back to main");


        try {
            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/maingame.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 720, 648);

            stage.setScene(scene);
            stage.setTitle("Game Sudoku");
            stage.show();

        } catch (Exception err) {
            System.out.println("Err: " + err);
        }

    }
}
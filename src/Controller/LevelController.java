package src.Controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LevelController {

    public void level1(MouseEvent e) {

        System.out.println("Click play level 1");

        try {
            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/game/game.fxml"));

            Parent root = loader.load();

            gameControler g = loader.getController();

            g.load(12, 3, "Level 1"); // Số ô trống là 12, mặc định tôi để là 1 lên cần thêm 11 ô nữa

            Scene scene = new Scene(root, 720, 648);

            stage.setScene(scene);
            stage.show();

        } catch (IOException err) {
            err.printStackTrace();
            System.exit(0);
        }

    }

    public void level2(MouseEvent e) {

        System.out.println("Click play level 2");

        try {
            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/game/game.fxml"));

            Parent root = loader.load();

            gameControler g = loader.getController();

            g.load(20, 5, "Level 2"); // Số ô trống là 20, mặc định tôi để là 1 lên cần thêm 19 ô nữa

            Scene scene = new Scene(root, 720, 648);

            stage.setScene(scene);
            stage.show();

        } catch (IOException err) {
            err.printStackTrace();
            System.exit(0);
        }

    }

    public void level3(MouseEvent e) {

        System.out.println("Click play level 3");

        try {
            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/game/game.fxml"));

            Parent root = loader.load();

            gameControler g = loader.getController();

            g.load(30, 6, "Level 2"); // Số ô trống là 30, mặc định tôi để là 1 lên cần thêm 19 ô nữa

            Scene scene = new Scene(root, 720, 648);

            stage.setScene(scene);
            stage.show();

        } catch (IOException err) {
            err.printStackTrace();
            System.exit(0);
        }

    }

    public void developTest(MouseEvent e) {

        System.out.println("Click play developTest");

        try {
            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/level/develop.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root, 720, 648);

            stage.setScene(scene);
            stage.show();

        } catch (IOException err) {
            err.printStackTrace();
            System.exit(0);
        }

    }

    public void backtomain(MouseEvent e) {

        System.out.println("Click back to main");

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
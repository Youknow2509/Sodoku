package src.Controller;

import application.assest.SudokuGenerator;
import application.game.gameControler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameDevelopController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField otrong;
    @FXML
    private TextField err;
    @FXML
    private Label inputErr;

    private SudokuGenerator sg = new SudokuGenerator();
    private int[][] res = new int[9][9];
    int nErr;
    int nOtrong;
    boolean check1 = false;
    boolean check2 = false;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        res = sg.generateSudoku();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String name = "#arr" + String.valueOf(i) + String.valueOf(j);
                Label label = (Label)anchorPane.lookup(name);
                label.setText(String.valueOf(res[i][j]));
            }
        }
    }
    private boolean isNumber(String str) {
        return str.matches("\\d+");
    }
    private void setErr() {
        String s = err.getText();
        if (isNumber(s)) {
            nErr = Integer.parseInt(s);
            check1 = true;
        }
        else {
            inputErr.setText("Vui lòng nhập đúng định dạng");
        }
    }
    private void setOtrong() {
        String s = err.getText();
        if (isNumber(s)) {
            nOtrong = Integer.parseInt(s);
            check2 = true;
        }
        else {
            inputErr.setText("Vui lòng nhập đúng định dạng");
        }
    }

    public void nextToGame(ActionEvent e) {
        setOtrong();
        setErr();
        if (check1 && check2) {
            try {
                Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/game/game.fxml"));

                Parent root = loader.load();

                gameControler g = loader.getController();
                // Xu li yeu cau

                g.load(nOtrong, nErr, "TEST", res);

                Scene scene = new Scene(root, 720, 648);

                stage.setScene(scene);
                stage.show();

            } catch (IOException err) {
                err.printStackTrace();
                System.exit(0);
            }
        }

    }
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
}
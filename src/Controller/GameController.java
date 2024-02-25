package src.Controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import application.assest.SudokuGenerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label labelLevel;
    @FXML
    private Label labelErr;

    private Map<String, Label> arrLabel = new HashMap<>();
    private Map<String, Button> arrButtonNumber = new HashMap<>();

    SudokuGenerator sudokuGenerator = new SudokuGenerator();
    int[][] solution = new int[9][9];
    int[][] mission = new int[9][9];
    Label labelClicked; // dùng để đổi màu
    int rowLabelClicked;// lưu địa chỉ label vừa chọn
    int colLabelClicked;// lưu địa chỉ label vừa chọn
    int err = 0;
    int otrong = 0;
    boolean setValue = false;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        System.out.println("creat game");

        // Khoi tao mang gia tri
        solution = sudokuGenerator.generateSudoku();
        mission = sudokuGenerator.coppyArray2d(solution);

        load(otrong, err, "Test");
    }

    public void load(int otrong, int err, String labelLevel) {
        sudokuGenerator.removeDigits(mission, otrong);
        setLabelLevel(labelLevel);
        setLabelErr(err);
        setOtrong(otrong);
        // Dung hashmap truy xuat cac phan tu Label va gan cac su kien cho cac label
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                final int row = i;
                final int col = j;
                String name = "#arr" + String.valueOf(row) + String.valueOf(col);
                Label label = (Label)anchorPane.lookup(name);
                arrLabel.put(name, label);
                if (mission[row][col] != 0) {
                    arrLabel.get(name).setText(String.valueOf(mission[row][col]));
                } else {
                    arrLabel.get(name).setText("");
                }
                label.setOnMouseClicked(event -> {
                    handleClickLabel(row, col, event);
                });
            }
        }
        // Dung de truy xuat va gan su kien cho Button nunmber
        for (int i = 1; i <= 9; i++) {
            final int number = i;
            String name = "#number" + String.valueOf(i);
            Button button = (Button)anchorPane.lookup(name);
            arrButtonNumber.put(name, button);
            button.setOnMouseClicked(e -> {
                handleClickNumber(number, e);
            });
        }
    }

    public void load(int otrong, int err, String labelLevel, int[][] res) {
        System.out.println("Game Devolop");
        solution = res;
        mission = sudokuGenerator.coppyArray2d(solution);
        sudokuGenerator.removeDigits(mission, otrong);
        setLabelLevel(labelLevel);
        setLabelErr(err);
        setOtrong(otrong);
        // Dung hashmap truy xuat cac phan tu Label va gan cac su kien cho cac label
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                final int row = i;
                final int col = j;
                String name = "#arr" + String.valueOf(row) + String.valueOf(col);
                Label label = (Label)anchorPane.lookup(name);
                arrLabel.put(name, label);
                if (mission[row][col] != 0) {
                    arrLabel.get(name).setText(String.valueOf(mission[row][col]));
                } else {
                    arrLabel.get(name).setText("");
                }
                label.setOnMouseClicked(event -> {
                    handleClickLabel(row, col, event);
                });
            }
        }
        // Dung de truy xuat va gan su kien cho Button nunmber
        for (int i = 1; i <= 9; i++) {
            final int number = i;
            String name = "#number" + String.valueOf(i);
            Button button = (Button)anchorPane.lookup(name);
            arrButtonNumber.put(name, button);
            button.setOnMouseClicked(e -> {
                handleClickNumber(number, e);
            });
        }
    }

    private void handleClickLabel(int i, int j, MouseEvent e) {

        System.out.println( i + " " + j + " " + e.getSource());

        Label click = (Label) e.getSource();
        changeTextFill(click, i, j);
        if (click.getText() == "") {
            setValue = true;
        }
        checkStatusGame(e);
    }

    private void handleClickNumber(int n, MouseEvent e) {
        Button b = (Button) e.getSource();
        System.out.println(b);

        if (setValue) {
            mission[rowLabelClicked][colLabelClicked] = n;
            if (mission[rowLabelClicked][colLabelClicked] == solution[rowLabelClicked][colLabelClicked]) {
                labelClicked.setText(String.valueOf(n));
                otrong--;
            } else {
                mission[rowLabelClicked][colLabelClicked] = 0;
                err--;
                labelErr.setText(String.valueOf(err));
            }
            checkStatusGame(e);
            setValue = false;
        }
    }

    private void checkStatusGame(MouseEvent e) {
        if (otrong == 0) { // win
            System.out.println("win");

            try {
                Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/stateGame/gameWin.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root, 720, 648);

                stage.setScene(scene);
                stage.show();

            } catch (Exception err) {
                System.out.println("Err: " + err);
            }
        }
        if (err == 0) { // lose
            System.out.println("lose");

            try {
                Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/stateGame/gameLose.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root, 720, 648);

                stage.setScene(scene);
                stage.show();

            } catch (Exception err) {
                System.out.println("Err: " + err);
            }
        }
    }

    private void changeTextFill(Label l, int row, int col) {
        if (labelClicked != null) {

            unsetFillText(rowLabelClicked, colLabelClicked);
        }
        if (l != labelClicked) {

            setFillText(row, col);

            labelClicked = l;
            rowLabelClicked = row;
            colLabelClicked = col;
        } else {

            unsetFillText(row, col);

            labelClicked = null;
        }
    }

    private void setFillText(int row, int col) {
        fillText("-fx-text-fill: #FF9900;"
                        + "-fx-font-weight: 800;"
                ,row, col);
    }
    private void unsetFillText(int row, int col) {
        fillText("-fx-text-fill: #000000;"
                        + "-fx-font-weight: 800;"
                ,row, col);
    }

    private void fillText(String s, int row, int col) {
        for (int i = 0; i < 9; i++) {
            String name1 = "#arr" + String.valueOf(row) + String.valueOf(i);
            String name2 = "#arr" + String.valueOf(i) + String.valueOf(col);
            arrLabel.get(name1).setStyle(s);
            arrLabel.get(name2).setStyle(s);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String name = "#arr" + String.valueOf(row - row%3 + i) + String.valueOf(col - col%3 + j);
                arrLabel.get(name).setStyle(s );
            }
        }
    }

    public void setLabelLevel(String s) {
        if (labelLevel != null) {
            labelLevel.setText(s);

        }
    }
    public void setLabelErr(int n) {
        if (labelErr != null) {
            labelErr.setText(String.valueOf(n));
        }
        err = n;
    }
    public void setOtrong(int n) {
        otrong = n;
        System.out.println(otrong);
    }

    public void hoantac(ActionEvent e) {
        System.out.println("Click hoan tac");
    }
    public void xoa(ActionEvent e) {
        System.out.println("Click xoa");
    }
    public void ghichu(ActionEvent e) {
        System.out.println("Click ghi chu");
    }

    public void backtochoselevel(ActionEvent e) {
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
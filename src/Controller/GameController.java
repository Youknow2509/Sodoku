package src.Controller;

import src.Model.ChangeScene;
import src.Model.Game;
import src.Model.NodeGame;

import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameController {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label labelLevel;
    @FXML
    private Label labelErr;
    // Biến trong game
    final Game game = new Game();
    private Map<String, Label> arrLabel = new HashMap<>();
    private Map<String, Button> arrButtonNumber = new HashMap<>();
    NodeGame [][] solution;
    NodeGame [][] mission;
    int err = 1;
    int otrong = 10;

    Label labelClicked; // dùng để đổi màu
    int rowLabelClicked;// lưu địa chỉ label vừa chọn
    int colLabelClicked;// lưu địa chỉ label vừa chọn
    boolean setValue = false;

    public void initialize(int n, int err, String level) {

        initElements(n);

        initVC(err, level);
    }
    public void initVC(int err, String level) {
        this.err = err;
        setLabelLevel(level);
        setLabelErr(err);
        setOtrong(otrong);
        initBroad();
        initNumber();
    }
    // Khởi tạo các mảng giá trị
    public void initElements(int n) {
        game.initData(n);

        solution = game.getBoardRes();
        mission = game.getBoardMissing();

        otrong = n;
    }
    // Khởi tạo và gắn sự kiện vào các label
    private void initBroad() {
        // Dung hashmap truy xuat cac phan tu Label va gan cac su kien cho cac label
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                final int row = i;
                final int col = j;
                String name = "#arr" + String.valueOf(row) + String.valueOf(col);
                Label label = (Label)anchorPane.lookup(name);
                arrLabel.put(name, label);
                if (mission[row][col].getValue() != 0) {
                    arrLabel.get(name).setText(String.valueOf(mission[row][col].getValue()));
                } else {
                    arrLabel.get(name).setText("");
                }
                label.setOnMouseClicked(event -> {
                    handleClickLabel(row, col, event);
                });
            }
        }
    }
    // Khởi tạo và gắn sự kiện vào các number
    private void initNumber() {
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
    // Xử lý sự kiện khi click vào label
    private void handleClickLabel(int i, int j, MouseEvent e) {

        Label click = (Label) e.getSource();
        changeTextFill(click, i, j);
        if (click.getText() == "") {
            setValue = true;
        }
        checkStatusGame(e);
    }
    // Xử lý sự kiện khi click vào number
    private void handleClickNumber(int n, MouseEvent e) {
        Button b = (Button) e.getSource();
        if (setValue) {
            mission[rowLabelClicked][colLabelClicked].setValue(n);
            if (mission[rowLabelClicked][colLabelClicked].getValue() == solution[rowLabelClicked][colLabelClicked].getValue()) {
                labelClicked.setText(String.valueOf(n));
                otrong--;
            } else {
                mission[rowLabelClicked][colLabelClicked].setValue(0);
                err--;
                labelErr.setText(String.valueOf(err));
            }
            checkStatusGame(e);
            setValue = false;
            changeTextFill(labelClicked, rowLabelClicked, colLabelClicked);
        }
    }
    // Kiểm tra trạng thái game
    private void checkStatusGame(MouseEvent e) {
        if (otrong == 0) { // win
            System.out.println("win");

            try {
                Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/View/GameWin.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root, 720, 648);

                stage.setScene(scene);
                stage.show();

            } catch (Exception err) {
                System.out.println("Err: " + err);
            }
        }
        if (err <= 0) { // lose
            System.out.println("lose");

            try {
                Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/View/GameLose.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root, 720, 648);

                stage.setScene(scene);
                stage.show();

            } catch (Exception err) {
                System.out.println("Err: " + err);
            }
        }
    }
    // Đổi màu label khi click
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
        for (int i = 0; i < game.getN(); i++) {
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
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        ChangeScene c = new ChangeScene(stage, "/src/View/Level.fxml");;
        c.change();
    }

    public NodeGame[][] getSolution() {
        return solution;
    }

    public void setSolution(NodeGame[][] solution) {
        this.solution = solution;
    }

    public NodeGame[][] getMission() {
        return mission;
    }

    public void setMission(NodeGame[][] mission) {
        this.mission = mission;
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public int getOtrong() {
        return otrong;
    }
}


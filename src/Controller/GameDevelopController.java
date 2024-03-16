package src.Controller;

import src.Model.ChangeScene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import src.Model.Generator;
import src.Model.NodeGame;
import src.Model.Game;

public class GameDevelopController {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField otrong;
    @FXML
    private TextField err;
    @FXML
    private Label inputErr;
    // Biến trong game
    final Game game = new Game(0);
    private NodeGame[][] res;
    private NodeGame[][] mission;

    obj objErr = new obj();
    obj objOtrong = new obj();

    @FXML
    public void initialize() {

        res = game.getBoardRes();
        objErr.setT(err);
        objOtrong.setT(otrong);

        for (int i = 0; i < Generator.getSize(); i++) {
            for (int j = 0; j < Generator.getSize(); j++) {
                String name = "#arr" + String.valueOf(i) + String.valueOf(j);
                Label label = (Label)anchorPane.lookup(name);
                label.setText(String.valueOf(res[i][j].getValue()));
            }
        }
    }
    private boolean isNumber(String str) {
        return str.matches("\\d+");
    }

    private void setTextField(obj o) {
        String s = (o.getT()).getText();
        if (isNumber(s)) {
            o.setN(Integer.parseInt(s));
            o.setB(true);
        }
    }

    public void nextToGame(ActionEvent e) {
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai
        setTextField(objErr);
        setTextField(objOtrong);
        if (objErr.getB() && objOtrong.getB()) {
            game.initMission(objOtrong.getN());
            mission = game.getBoardMissing();
            ChangeScene c = new ChangeScene(stage, "/src/View/Game.fxml");
            c.change(res, mission, objOtrong.getN(), objErr.getN(), "Develop");
        } else {
            inputErr.setText("Vui lòng nhập đúng định dạng");
        }
    }
    public void backtolevel(ActionEvent e) {
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow(); // Lay stage hien tai
        ChangeScene c = new ChangeScene(stage, "/src/View/Level.fxml");
        c.change();
    }
}

class obj {
    private boolean b = false;
    private int n;

    private TextField t;

    public obj(boolean b, int text, TextField t) {
        this.b = b;
        this.n = text;
    }

    public obj() {
    }

    public boolean getB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public TextField getT() {
        return t;
    }

    public void setT(TextField t) {
        this.t = t;
    }
}
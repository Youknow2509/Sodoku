package src.Controller.Game;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import src.DataGame.Handle.HandleData;
import src.DataGame.Handle.HandleDataSql;
import src.Obj.UserGame;
import src.Utils.GetTimeCurrent;
import src.Utils.String_Data;

public class InputName {
    // Var fxml
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField nameGame;
    @FXML
    private ImageView save;
    @FXML
    private ImageView back;

    // Var
    private UserGame userGame;
    private HandleData handleData;
    // Init
    public void initialize(UserGame userGame) {
        this.userGame = userGame;

        handleData = new HandleDataSql();
    }

    @FXML
    public void save(MouseEvent e) {
        String name = nameGame.getText();
        if (name != null && name.length() > 0) {
            handleData.addGameUser(userGame.getIdGame(), userGame.getIdUser(), name,
                    userGame.getTypeGame(), GetTimeCurrent.getTimeCurrent(), userGame.getError(),
                    userGame.getEmpty(), String_Data.DataToString(userGame.getData()));
            helpBack();
        }
    }

    @FXML
    public void back(MouseEvent e) {
        helpBack();
    }

    public void helpBack() {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }
}

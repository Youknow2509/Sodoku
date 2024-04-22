package src.Controller.ListGameUsers;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import src.DataGame.Handle.HandleData;
import src.DataGame.Handle.HandleDataSql;
import src.Obj.UserGame;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import src.Utils.GetTimeCurrent;
import src.Utils.String_Data;


public class EditGameUserController {
    // Var fxml
    @FXML
    private Text gameId;
    @FXML
    private Text date;
    @FXML
    private Text typeGame;
    @FXML
    private ImageView save;
    @FXML
    private Text name;
    @FXML
    private ImageView back;
    @FXML
    private TextField nameEdit;
    @FXML
    private Text error;
    @FXML
    private Text userId;
    @FXML
    private Text empty;
    // Var
    private UserGame userGame;
    private TableView<UserGame> tableView;
    private HandleData handleData;
    // init
    public void initialize(UserGame userGame, TableView<UserGame> tableView) {

        this.userGame = userGame;
        this.tableView = tableView;

        setValueDefault();

        handleData = new HandleDataSql();
    }

    // Set value default
    public void setValueDefault() {
        gameId.setText(String.valueOf(userGame.getIdGame()));
        userId.setText(String.valueOf(userGame.getIdUser()));
        name.setText(userGame.getName());
        typeGame.setText(String.valueOf(userGame.getTypeGame()));
        date.setText(userGame.getDate());
        empty.setText(String.valueOf(userGame.getEmpty()));
        error.setText(String.valueOf(userGame.getError()));
    }

    // Handle back to list game user
    public void backToGameUser(MouseEvent event) {
        closePopup();
    }

    // Handle update game user
    public void updateGameUser(MouseEvent event) {
        String nameNew = nameEdit.getText();
        if (!nameNew.isEmpty()) {

            userGame.setName(nameNew);
            name.setText(userGame.getName());

            handleData.updateGameUser(userGame.getIdUserGame(), userGame.getIdGame(), userGame.getIdUser()
                    , userGame.getName()
                    , userGame.getTypeGame(), userGame.getDate(), userGame.getError(), userGame.getEmpty()
                    , String_Data.DataToString(userGame.getData()));

            // Debug
//            System.out.println("Update game user: " + "\n IDGameUser: " + userGame.getIdUserGame()
//                        + "\n IDGame: " + userGame.getIdGame() + "\n IDUser: " + userGame.getIdUser()
//                        + "\n Name: " + userGame.getName() + "\n TypeGame: " + userGame.getTypeGame()
//                        + "\n Date: " + userGame.getDate() + "\n Error: " + userGame.getError() + "\n Empty: " + userGame.getEmpty());

            tableView.refresh();

            closePopup();

        }
    }

    // Help close popup
    private void closePopup() {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
    }
}

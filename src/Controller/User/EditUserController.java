package src.Controller.User;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.DataGame.Handle.HandleData;
import src.DataGame.Handle.HandleDataSql;
import src.Obj.User;


public class EditUserController {
    // Var fxml
    @FXML
    private ImageView save;
    @FXML
    private ImageView back;
    @FXML
    private TextField nameEdit;
    @FXML
    private Text name;
    @FXML
    private Text userID;

    // Var
    private User user;
    private TableView<User> tableView;
    private HandleData handleData;

    // Init
    public void initialize(User user, TableView<User> tableView) {
        this.user = user;
        this.tableView = tableView;

        setValueDefault();

        handleData = new HandleDataSql();

    }

    // Set value default
    private void setValueDefault() {
        name.setText(user.getUserName());
        userID.setText(String.valueOf(user.getIdUser()));
    }


    public void updateUser(MouseEvent event) {
        String nameNew = nameEdit.getText();
        if (!nameNew.isEmpty()) {

            user.setUserName(nameNew);
            name.setText(user.getUserName());

            handleData.updateUser(user.getIdUser(), user.getUserName());

            tableView.refresh();

            closePopup();

        }
    }

    public void back(MouseEvent event) {
        closePopup();
    }

    // Help close popup
    private void closePopup() {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
    }
}

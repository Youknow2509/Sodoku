package src.Controller.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.Controller.LevelController;
import src.DataGame.Handle.HandleData;
import src.DataGame.Handle.HandleDataSql;
import src.Obj.User;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UsersController implements Initializable {
    // Var fxml
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, String> colName;
    @FXML
    private TableColumn<User, Integer> colID;

    // Var
    private ObservableList<User> observableList;
    private HandleData handleData = new HandleDataSql();
    private List<User> listUser;

    // Init
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listUser = handleData.getUser();

        tableView.setPlaceholder(new Label("Không có dữ liệu !!!")); // hoặc bất kỳ nội dung nào bạn muốn


        observableList = FXCollections.observableArrayList(
                listUser
        );
        colName.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
        colID.setCellValueFactory(new PropertyValueFactory<User, Integer>("idUser"));


        tableView.setItems(observableList);
    }
    // Go to level
    public void play(MouseEvent event) {
        User user = tableView.getSelectionModel().getSelectedItem();
        if (user != null) {
            try {
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/src/View/Level.fxml"));
                Parent parent = loader.load();

                LevelController controller = loader.getController();
                controller.initialize(user);

                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.setResizable(false);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Del user
    public void delUser(MouseEvent event) {
        User user = tableView.getSelectionModel().getSelectedItem();
        if (user != null) {
            observableList.remove(user);
            handleData.deleteUser(user.getIdUser());
        }
    }

    // Edit user
    public void editUser(MouseEvent event) throws IOException {
        User user = tableView.getSelectionModel().getSelectedItem();
        if (user != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/View/User/EditUser.fxml"));
            Parent root = loader.load();

            EditUserController controller = loader.getController();
            controller.initialize(user, tableView);

            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait();
            popupStage.centerOnScreen();
            popupStage.setResizable(false);
        }
    }

    // Back to after
    public void back(MouseEvent event) {
        try {
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/src/View/PlayNew.fxml"));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

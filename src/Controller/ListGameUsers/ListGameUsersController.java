package src.Controller.ListGameUsers;

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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.Controller.Game.GameController;
import src.DataGame.Handle.HandleData;
import src.DataGame.Handle.HandleDataSql;
import src.Obj.Game;
import src.Obj.User;
import src.Obj.UserGame;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListGameUsersController implements Initializable {
    // Var fxml
    @FXML
    private TableView<UserGame> tableView;
    @FXML
    private TableColumn<UserGame, String> colName;
    @FXML
    private TableColumn<UserGame, Integer> colTypeGame;
    @FXML
    private TableColumn<UserGame, String> colDate;
    @FXML
    private TableColumn<UserGame, Integer> colHealth;
    @FXML
    TableColumn<UserGame, Integer> colEmpty;

    @FXML
    private ImageView backToHome;

    @FXML
    private ImageView del;
    @FXML
    private ImageView play;

    // Var
    private ObservableList<UserGame> observableList;
    private HandleData handleData = new HandleDataSql();
    private List<UserGame> listUserGame;

    // Init
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listUserGame = handleData.getGameUser();

        tableView.setPlaceholder(new Label("Không có dữ liệu !!!")); // hoặc bất kỳ nội dung nào bạn muốn


        observableList = FXCollections.observableArrayList(
                listUserGame
        );
        colName.setCellValueFactory(new PropertyValueFactory<UserGame, String>("name"));
        colTypeGame.setCellValueFactory(new PropertyValueFactory<UserGame, Integer>("typeGame"));
        colDate.setCellValueFactory(new PropertyValueFactory<UserGame, String>("date"));
        colHealth.setCellValueFactory(new PropertyValueFactory<UserGame, Integer>("error"));
        colEmpty.setCellValueFactory(new PropertyValueFactory<UserGame, Integer>("empty"));

        tableView.setItems(observableList);
    }

    // Delete
    public void delete(MouseEvent event) {
        UserGame userGame = tableView.getSelectionModel().getSelectedItem();
        if (userGame != null) {
            observableList.remove(userGame);
            handleData.deleteGameUser(userGame.getIdUserGame());
        }
    }

    // Edit
    public void edit(MouseEvent event) throws IOException {
        UserGame userGame = tableView.getSelectionModel().getSelectedItem();
        if (userGame != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/View/ListGameUsers/EditGameUser.fxml"));
            Parent root = loader.load();

            EditGameUserController controller = loader.getController();
            controller.initialize(userGame, tableView);

            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait();
            popupStage.centerOnScreen();
            popupStage.setResizable(false);
        }
    }

    // Play
    public void play(MouseEvent event) throws IOException {
        UserGame userGame = tableView.getSelectionModel().getSelectedItem();
        if (userGame != null) {
            User user = handleData.getUserById(userGame.getIdUser());
            Game game = handleData.getGameById(userGame.getIdGame());

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/src/View/Game/Game" + userGame.getTypeGame() + "x" + userGame.getTypeGame() + ".fxml"));
            Parent studentViewParent = loader.load();
            Scene scene = new Scene(studentViewParent);

            GameController controller = loader.getController();
            controller.initialize(userGame);

            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
        }
    }

    // Back
    public void back(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/src/View/Home.fxml"));
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

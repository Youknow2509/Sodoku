package src.Controller;

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
import javafx.stage.Stage;
import src.DataGame.Handle.HandleData;
import src.DataGame.Handle.HandleDataSql;
import src.Obj.Game;
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
        observableList.remove(userGame);
        if (userGame != null) {
            // todo fix xoa tren may va tren database
            //handleData.deleteGameUser(userGame.getIdGame(), userGame.getIdUser());
        }
    }
    // Play
    public void play(MouseEvent event) throws IOException {
        UserGame userGame = tableView.getSelectionModel().getSelectedItem();
        if (userGame != null) {
            // todo
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/src/View/Game" + userGame.getTypeGame() + "x" + userGame.getTypeGame() + ".fxml"));
            Parent studentViewParent = loader.load();
            Scene scene = new Scene(studentViewParent);
            GameController controller = loader.getController();
            controller.initialize(new Game(userGame.getIdGame(), userGame.getTypeGame(), 1, userGame.getError(), userGame.getEmpty(), userGame.getData()));
            stage.setScene(scene);
        }

    }
}

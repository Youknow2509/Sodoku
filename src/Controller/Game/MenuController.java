package src.Controller.Game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.DataGame.Handle.HandleData;
import src.DataGame.Handle.HandleDataSql;
import src.Obj.UserGame;
import src.Utils.GetTimeCurrent;
import src.Utils.String_Data;

import java.io.IOException;
import java.util.Optional;

public class MenuController {
    // Var fxml
    @FXML
    private HBox hBox;
    @FXML
    private Button tiepTuc;
    @FXML
    private Button luu;
    @FXML
    private Button quayLaiHome;

    // Var
    private Stage stageGame;
    private UserGame userGame;
    private HandleData handleData;
    // Init
    public void initialize(Stage stageGame, UserGame userGame) {

        this.stageGame = stageGame;
        this.userGame = userGame;

        handleData = new HandleDataSql();
    }

    // Handle Event tiepTuc
    public void tiepTuc(MouseEvent e) {
        Stage stage = (Stage) hBox.getScene().getWindow();
        stage.close();
    }

    // Handle Event luu
    public void luu(MouseEvent event) {
        UserGame userGameTemp = handleData.getUserGameById(userGame.getUser().getIdUser());
        if (userGameTemp == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/View/Game/InputName.fxml"));
                Parent root = loader.load();

                InputName inputName = loader.getController();
                inputName.initialize(userGame);

                Stage popupStage = new Stage();
                popupStage.initModality(Modality.APPLICATION_MODAL);
                popupStage.setScene(new Scene(root));
                popupStage.showAndWait();
                popupStage.centerOnScreen();
                popupStage.setResizable(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            handleData.updateGameUser(userGameTemp.getIdUserGame() , userGameTemp.getIdGame(),
                    userGameTemp.getIdUser(), userGameTemp.getName(),
                    userGameTemp.getTypeGame(), GetTimeCurrent.getTimeCurrent(),
                    userGameTemp.getError(), userGameTemp.getEmpty()
                    , String_Data.DataToString(userGameTemp.getData()));
        }
        helpGoToHome();
    }

    // Handle Event quayLaiHome
    public void quayLaiHome(MouseEvent event) {
        helpGoToHome();
    }

    // Helpper go to home
    private void helpGoToHome() {
        try {
            Stage stage = (Stage) hBox.getScene().getWindow();
            stage.close();

            Parent root = FXMLLoader.load(getClass().getResource("/src/View/Home.fxml"));
            stageGame.setScene(new Scene(root));
            stageGame.centerOnScreen();
            stageGame.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

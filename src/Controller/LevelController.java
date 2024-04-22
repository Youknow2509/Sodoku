package src.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import src.Controller.Game.GameController;
import src.DataGame.Handle.HandleData;
import src.DataGame.Handle.HandleDataSql;
import src.Obj.Game;
import src.Obj.User;
import src.Obj.UserGame;
import src.Utils.GetTimeCurrent;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class LevelController {
    // Var fxml
    @FXML
    private AnchorPane anchorPane;

    // Var
    private User user;
    private Game game;
    private UserGame userGame;
    private HandleData handleData;
    // Init
    public void initialize(User user) {

        this.user = user;

        this.handleData = new HandleDataSql();
    }

    // Play game 9x
    public void playGame9_1(ActionEvent e) {
        List<Game> games = handleData.getGameByTypeGameAndLevel(9, 1);
        game = randomGame(games);
        changeStageToGame(user, game);
    }
    public void playGame9_2(ActionEvent e) {
        List<Game> games = handleData.getGameByTypeGameAndLevel(9, 2);
        game = randomGame(games);
        changeStageToGame(user, game);
    }
    public void playGame9_3(ActionEvent e) {
        List<Game> games = handleData.getGameByTypeGameAndLevel(9, 3);
        game = randomGame(games);
        changeStageToGame(user, game);
    }

    // Play game 16x
    public void playGame16_1(ActionEvent e) {
        List<Game> games = handleData.getGameByTypeGameAndLevel(16, 1);
        game = randomGame(games);
        changeStageToGame(user, game);
    }
    public void playGame16_2(ActionEvent e) {
        List<Game> games = handleData.getGameByTypeGameAndLevel(16, 2);
        game = randomGame(games);
        changeStageToGame(user, game);
    }
    public void playGame16_3(ActionEvent e) {
        List<Game> games = handleData.getGameByTypeGameAndLevel(16, 3);
        game = randomGame(games);
        changeStageToGame(user, game);
    }

    // Back to home
    public void backToHome(MouseEvent e) {
        try {
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/View/Home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Helper change stage
    private void changeStageToGame(User user, Game game) {
        int SIZE = game.getSize();
        String path = "/src/View/Game/Game" + SIZE + "x" + SIZE + ".fxml";

        try {
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent root = loader.load();

            GameController gameController = loader.getController();
            gameController.initialize(user, game);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Help random game
    private Game randomGame(List<Game> games) {
        Game game = null;
        Random random = new Random();
        int index = random.nextInt(games.size());
        game = games.get(index);
        return game;
    }
}

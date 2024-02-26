package src.Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.Controller.GameController;

public class ChangeScene {
    private String path;
    private Stage stage;
    private int width = 720;
    private int height = 648;
    private String title = "Game Sudoku";

    public ChangeScene(Stage stage, String path) {
        this.path = path;
        this.stage = stage;
    }

    public ChangeScene(Stage stage, String title, int width, int height, String path) {
        this.path = path;
        this.stage = stage;
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public ChangeScene() {
        super();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void change() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent root = loader.load();
            Scene scene = new Scene(root, width, height); // 3840, 2160 | 720, 648 | 1080, 972 | 1920, 1080
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();

        } catch (Exception e) {
            System.out.println("Err: " + e);
            System.exit(0);
        }
    }
    public void change(int n, int err, String titleLevel) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent root = loader.load();
            GameController game = loader.getController();
            game.initialize(n, err, titleLevel);
            Scene scene = new Scene(root, width, height); // 3840, 2160 | 720, 648 | 1080, 972 | 1920, 1080
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();

        } catch (Exception e) {
            System.out.println("Err: " + e);
            System.exit(0);
        }
    }
    public void change(NodeGame[][] res, NodeGame[][] mession, int n, int err, String titleLevel) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent root = loader.load();
            GameController game = loader.getController();

            game.setSolution(res);
            game.setMission(mession);
            game.setOtrong(n);
            game.initVC(err, titleLevel);

            Scene scene = new Scene(root, width, height); // 3840, 2160 | 720, 648 | 1080, 972 | 1920, 1080
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();

        } catch (Exception e) {
            System.out.println("Err: " + e);
            System.exit(0);
        }
    }
}

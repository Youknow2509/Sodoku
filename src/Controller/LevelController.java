package src.Controller;

import src.Model.Game;
import src.Utils.HandleData;
import java.io.File;
import java.util.InputMismatchException;
import java.util.Random;
import src.Utils.Config;
import src.View.Level;
public class LevelController { 
    // Variables
    private final String path = "src/Data/Game/";
    private final Level levelView = new Level();
    // Variables input  
    private String typeGame;
    private String level;
    private String user;
    private int tG, l;
    // Constructor
    public LevelController() {
        super();
    }
    public LevelController(String user) {
        super();
        this.user = user;
    }
    // Applicaton
    public void Application() {
        levelView.menuApplication();
        typeGame = (Config.getScannerInput()).nextLine();
        try {
            tG = Integer.parseInt(typeGame);
            if (tG != 1 && tG != 2) {
                   levelView.inputMenuApplicationError();
                Application();
            }
        } catch (NumberFormatException e) {
            levelView.inputNumberFormatError();
            Application();
        }
        if (tG == 1) {
            handleTypeGame9x9();
        } else {
            handleTypeGame16x16();
        }
    }
    // Handle typeGame 9x9
    private void handleTypeGame9x9() {
        levelView.chooseTypeGame();
        level = (Config.getScannerInput()).nextLine();
        try {
            l = Integer.parseInt(level);
            if (l != 1 && l != 2 && l != 3) {
                levelView.inputTypeGameError();
                handleTypeGame9x9();
            }
        } catch (NumberFormatException e) {
            levelView.inputNumberFormatError();
            handleTypeGame9x9();
        }
        if (l == 1) {
            LevelToGame(path + "9x9/Ez/");
        } else if (l == 2) {
            LevelToGame(path + "9x9/Medial");
        } else {
            LevelToGame(path + "9x9/Hard");
        }
    }
    // Handle typeGame 16x16
    private void handleTypeGame16x16() {
        levelView.chooseTypeGame();
        level = (Config.getScannerInput()).nextLine();
        try {
            l = Integer.parseInt(level);
            if (l != 1 && l != 2 && l != 3) {
                levelView.inputTypeGameError();
                handleTypeGame9x9();
            }
        } catch (NumberFormatException e) {
            levelView.inputNumberFormatError();
            handleTypeGame9x9();
        }
        if (l == 1) {
            LevelToGame(path + "16x16/Ez/");
        } else if (l == 2) {
            LevelToGame(path + "16x16/Medial");
        } else {
            LevelToGame(path + "16x16/Hard");
        }
    }
    // Level to Game
    private void LevelToGame(String path) {
        Game game = ChooseGameFromPath(path);
        GameController gameController = new GameController(game, user);
        gameController.Application();
    }
    // Choose game from path
    private Game ChooseGameFromPath(String path) {
        File file = new File(path);
        File[] listFile = file.listFiles();
        int sizeListFile = listFile.length;
        Random random = new Random();
        int index = random.nextInt(sizeListFile);
        String pathFile = listFile[index].getAbsolutePath();
        return HandleData.readDataFromFile(pathFile);
    }
    // Getters and Setters

    public String getPath() {
        return path;
    }

    public Level getLevelView() {
        return levelView;
    }

    public String getTypeGame() {
        return typeGame;
    }

    public void setTypeGame(String typeGame) {
        this.typeGame = typeGame;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int gettG() {
        return tG;
    }

    public void settG(int tG) {
        this.tG = tG;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }
}

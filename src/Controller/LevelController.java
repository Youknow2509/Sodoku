package src.Controller;

import src.Model.Game;
import src.Utils.HandleData;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class LevelController {
    // Variables
    private final String path = "src/Data/Game/";
    private Scanner scanner = null;
    //
    private int typeGame;
    private int level;
    private String user;
    // Constructor
    public LevelController() {
        super();
    }
    public LevelController(String user, int typeGame, int level) {
        super();
        this.typeGame = typeGame;
        this.level = level;
        this.user = user;
    }
    // Applicaton
    public void Application() {
        scanner = new Scanner(System.in);
        System.out.println("Vui lòng chọn loại game: 9x9, 16x16.");
        System.out.println("1. 9x9");
        System.out.println("2. 16x16");
        System.out.print("Chọn: ");
        try {
            typeGame = scanner.nextInt();
            if (typeGame != 1 && typeGame != 2) {
                System.out.println("Vui lòng chọn 1 hoặc 2.");
                Application();
            }
        } catch (InputMismatchException e) {
            System.out.println("Vui lòng nhập số nguyên.");
            Application();
        }
        if (typeGame == 1) {
            handleTypeGame9x9();
        } else {
            handleTypeGame16x16();
        }
    }
    // Handle typeGame 9x9
    private void handleTypeGame9x9() {
        System.out.println("Vui lòng chọn mức độ:");
        System.out.println("1. Dễ");
        System.out.println("2. Trung bình");
        System.out.println("3. Khó");
        System.out.print("Chọn: ");
        try {
            level = scanner.nextInt();
            if (level != 1 && level != 2 && level != 3) {
                System.out.println("Vui lòng chọn 1, 2 hoặc 3.");
                handleTypeGame9x9();
            }
        } catch (InputMismatchException e) {
            System.out.println("Vui lòng nhập số nguyên.");
            handleTypeGame9x9();
        }
        if (level == 1) {
            LevelToGame(path + "9x9/Ez/");
        } else if (level == 2) {
            LevelToGame(path + "9x9/Hard");
        } else {
            LevelToGame(path + "9x9/Medial");
        }
    }
    // Handle typeGame 16x16
    private void handleTypeGame16x16() {
        System.out.println("Vui lòng chọn mức độ:");
        System.out.println("1. Dễ");
        System.out.println("2. Trung bình");
        System.out.println("3. Khó");
        System.out.print("Chọn: ");
        try {
            level = scanner.nextInt();
            if (level != 1 && level != 2 && level != 3) {
                System.out.println("Vui lòng chọn 1, 2 hoặc 3.");
                handleTypeGame9x9();
            }
        } catch (InputMismatchException e) {
            System.out.println("Vui lòng nhập số nguyên.");
            handleTypeGame9x9();
        }
        if (level == 1) {
            LevelToGame(path + "16x16/Ez/");
        } else if (level == 2) {
            LevelToGame(path + "16x16/Hard");
        } else {
            LevelToGame(path + "16x16/Medial");
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

    public int getTypeGame() {
        return typeGame;
    }

    public void setTypeGame(int typeGame) {
        this.typeGame = typeGame;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

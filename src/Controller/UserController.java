package src.Controller;

import src.Model.Game;
import src.Utils.Config;
import src.Utils.HandleData;
import src.View.Level;
import src.View.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class UserController {  // TODO tất cả chuyển hiển thị sang View
    // Variables
    private String pathRoot = "src/Data/User";
    private User userView = null;
    private boolean loop = true;
    private GameController gameController = null;
    private LevelController levelController = null;
    //
    private String path = "";
    // Variable input
    private String user = null;
    private String nameFile = null;
    private String typeGame = null;
    private String choose = null;
    private int c;

    // Constructor
    public UserController() {
        super();
        readFolder(pathRoot);
        userView = new User();
    }
    // Application
    public void Application() {
        while (loop) {
            userView.viewApplication();
            choose = Config.getScannerInput().nextLine();

            try {
                c = Integer.parseInt(choose);
                if (c < 1 || c > 4) {
                    System.out.println("Hãy điển giá trị từ 1 đến 4 !!!");
                    Application();
                }
            } catch (NumberFormatException e) {
                System.out.println("Hãy điển giá trị 'nguyên' từ 1 đến 4 !!!");
                Application();
            }

            switch (c) {
                case 1:
                    playContinue();
                    break;
                case 2:
                    playNew();
                    break;
                case 3:
                    showDataUser();
                    break;
                case 4:
                    loop = false;
                    System.out.println("Exit !!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Biến c không hợp lệ !!!");
                    break;
            }
        }
    }
    // Chơi tiếp dữ liệp cũ
    private void playContinue() {
        printFolderData();
        if (countUser() == 0) {
            userView.requestCreateUser();
        } else {
            userView.requestInputNameUser();
            user = Config.getScannerInput().nextLine();
            if (countDataofUser(user) == 0 || (HandleData.getDATA()).get(user) == null) {
                userView.notifyUserNoData();
                return;
            }
            userView.requestInputNameFile();
            nameFile = Config.getScannerInput().nextLine();
            if (!(HandleData.getDATA()).get(user).contains(nameFile + ".txt")) {
                userView.notifyFileNoExist();
                return;
            }
            path = pathRoot + "/" + user + "/" + nameFile + ".txt";
            gameController = new GameController(HandleData.readDataFromFile(path), user);
            gameController.Application();
            return;
        }
    }
    // Chơi mới
    private void playNew() {
        userView.requestInputNameUser();
        user = Config.getScannerInput().nextLine();
        levelController = new LevelController(user);
        levelController.Application();
        return;
    }
    // Hiển thị dữ liệu người dùng
    private void showDataUser() {
        printFolderData();
        userView.optionDataUser();
        choose = Config.getScannerInput().nextLine();

        try {
            c = Integer.parseInt(choose);
            if (c < 1 || c > 3) {
                System.out.println("Hãy điển giá trị từ 1 đến 3 !!!");
                showDataUser();
            }
        } catch (NumberFormatException e) {
            System.out.println("Hãy điển giá trị 'nguyên' từ 1 đến 3 !!!");
            showDataUser();
        }
        if (c == 1) {
            System.out.println("Nhập tên người dùng cần xoá dữ liệu: ");
            user = Config.getScannerInput().nextLine();
            try {
                HandleData.deleteUser(user);
            } catch (NullPointerException e) {
                System.out.println("Không tồn tại user: " + user);
                showDataUser();
            }
            showDataUser();
        } else if (c == 2) {
            System.out.println("Nhập tên người dùng cần xoá dữ liệu: ");
            user = Config.getScannerInput().nextLine();
            System.out.println("Nhập tên file cần xoá: ");
            nameFile = Config.getScannerInput().nextLine();
            try {
                HandleData.deleteFileData(user, nameFile);
            } catch (NullPointerException e) {
                System.out.println("Không tìm thấy file");
                showDataUser();
            }
        } else {
            return;
        }
    }


    // Help functoin :
    // Đọc dữ liệu trong Folder
    private void readFolder(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File [] lFiles = file.listFiles();
            for (File f : lFiles) { // Duyệt các Folder
                if (f.isDirectory()) {
                    String nameFolder = f.getName();
                    (HandleData.getDATA()).put(nameFolder, new ArrayList<>());
                    for (File f1 : f.listFiles()) { // Duyệt các file trong Folder
                        if (f1.isFile() && f1.getName().contains(".txt")){ // Lọc file .txt
                            String nameFile = f1.getName();
                            (HandleData.getDATA()).get(nameFolder).add(nameFile);
                        }
                    }
                }
            }
        }
    }
    // In dữ liệu trong Folder
    private void printFolderData() {
        int index = 1;
        System.out.println("Dữ liệu có " + countUser() + " người dùng.");
        for (Map.Entry<String, ArrayList<String>> entry : (HandleData.getDATA()).entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            System.out.print("Người dùng " + index + " '" + key + "', " + countDataofUser(entry.getKey()) + " dữ liệu: ");
            index++;
            for (String s : value) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private int countUser() {
        return (HandleData.getDATA()).size();
    }
    // Help Print Folder Data - Trả về số lượng dữ liệu của từng User
    private int countDataofUser(String user) {
        try {
            return (HandleData.getDATA()).get(user).size();

        } catch (NullPointerException e) {
            return 0;
        }
    }
    // Getter and Setter

    public String getPathRoot() {
        return pathRoot;
    }

    public void setPathRoot(String pathRoot) {
        this.pathRoot = pathRoot;
    }

    public User getUserView() {
        return userView;
    }

    public void setUserView(User userView) {
        this.userView = userView;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public LevelController getLevelController() {
        return levelController;
    }

    public void setLevelController(LevelController levelController) {
        this.levelController = levelController;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getTypeGame() {
        return typeGame;
    }

    public void setTypeGame(String typeGame) {
        this.typeGame = typeGame;
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}

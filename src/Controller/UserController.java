package src.Controller;

import src.Model.Game;
import src.Utils.HandleData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class UserController {  // TODO chuyển hiển thị sang View
    // Variables
    private Map<String, ArrayList<String>> DATA = new Hashtable<String, ArrayList<String>>();
    private String pathRoot = "src/Data/User/";
    private Scanner scanner = null;
    //
    private boolean loop = true;
    private String user = null;
    private String nameFile = null;
    // Constructor
    public UserController() {
        super();
        readFolder(pathRoot);
    }
    // Application
    public void Application() {
        int chooses = 0;
        printFolderData();
        System.out.println("Bạn muốn chơi tiếp hay tạo mới User ?");
        System.out.println("1: Chơi tiếp.\n2: Tạo mới.\n3: Thoát.");
        System.out.print("Chọn: ");
        scanner = new Scanner(System.in);
        try {
            chooses = scanner.nextInt();
            if (chooses != 1 && chooses != 2 && chooses != 3) {
                System.out.println("Vui lòng chọn 1, 2 hoặc 3 !!!");
                Application();
            }
        } catch (InputMismatchException e) {
            System.out.println("Vui lòng nhập số nguyên !!!");
            scanner.nextLine(); // Xoá dữ liệu lỗi
            Application();
        }
        scanner.nextLine();
        if (chooses == 1) {
            if (countUser() == 0) {
                System.out.println("Không có User nào, vui lòng chọn 2 tạo mới User !!!");
                Application();
            } else {
                printFolderData();
                System.out.println("Chọn User để chơi: ");
                user = scanner.nextLine();
                System.out.println("Chọn file game: ");
                nameFile = scanner.nextLine();
                String path = pathRoot + user + "/" + nameFile + ".txt";

                    Game game = HandleData.readDataFromFile(path);
                    GameController gameController = new GameController(HandleData.readDataFromFile(path), user);
                    gameController.Application();

            }
        } else if (chooses == 2) {
            System.out.print("Tạo mới User: ");
            user = scanner.nextLine();
            HandleData.createUser(user);
            LevelController levelController = new LevelController(user);
            levelController.Application();
        } else {
            System.out.println("Goodbye !!!");
            System.exit(0);
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
                    DATA.put(nameFolder, new ArrayList<>());
                    for (File f1 : f.listFiles()) { // Duyệt các file trong Folder
                        if (f1.isFile() && f1.getName().contains(".txt")){ // Lọc file .txt
                            String nameFile = f1.getName();
                            DATA.get(nameFolder).add(nameFile);
                        }
                    }
                }
            }
        }
    }
    // In dữ liệu trong Folder
    private void printFolderData() {
        int index = 1;
        System.out.println("Data hava: " + countUser() + " users.");
        for (Map.Entry<String, ArrayList<String>> entry : DATA.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            System.out.print("User " + index + " " + key + ", " + countDataofUser(entry.getKey()) + " file: ");
            index++;
            for (String s : value) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private int countUser() {
        return DATA.size();
    }
    // Help Print Folder Data - Trả về số lượng dữ liệu của từng User
    private int countDataofUser(String user) {
        return DATA.get(user).size();
    }
    // Help createFileData - Trả về định dạng tên : typeGame_idGame (typeGame: 9x9, 16x16, 25x25, idGame: 1, 2, 3, ...)
    private String formatName(String typeGame, int idGame) {
        return typeGame + "_" + String.valueOf(idGame);
    }
    // Help createFileData - Trả về tên file mới, chọn idGame thích hợp để tạo file mới
    private String createNameFile(String nameUser, String typeGame) {
        int idGame = 1;
        String nameFile = formatName(typeGame, idGame);;
        ArrayList<String> listFile = null;
        try {
            listFile = DATA.get(nameUser);
        } catch (NullPointerException e) {
            System.out.println("Trong du lieu khong co user: " + nameUser + "!!!\n Hay tao moi user !!!");
        }
        if (listFile != null) {
            for (int i = 0; i < listFile.size(); i++) {
                nameFile = formatName(typeGame, idGame);
                if (listFile.get(i).equals(nameFile + ".txt")) {
                    idGame++;
                }
            }
        }
        nameFile = formatName(typeGame, idGame);
        return nameFile;
    }
    // Getter and Setter

}

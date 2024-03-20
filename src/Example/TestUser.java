package src.Example;

import javafx.util.Pair;

import javax.xml.crypto.Data;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;

public class TestUser {
    private static Map<String, ArrayList<String>> DATA = new Hashtable<String, ArrayList<String>>();
    // Đọc dữ liệu
    private static void readData(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File [] lFiles = file.listFiles();
            for (File f : lFiles) { // Duyệt các Folder
                if (f.isDirectory()) {
                    String nameFolder = f.getName();
                    DATA.put(nameFolder, new ArrayList<>());
                    for (File f1 : f.listFiles()) { // Duyệt các file trong Folder
                        if (f1.isFile()) {
                            String nameFile = f1.getName();
                            DATA.get(nameFolder).add(nameFile);
                        }
                    }
                }
            }
        }
    }
    // In dữ liệu
    private static void printData() {
        System.out.println("Data hava: " +countUser() + " users.");
        for (Map.Entry<String, ArrayList<String>> entry : DATA.entrySet()) {
            System.out.print("User " + entry.getKey() + ": " + cDataofUser(entry.getKey()) + " file: ");
            for (String s : entry.getValue()) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
    }
    // Trả về số lượng User
    private static int countUser() {
        return DATA.size();
    }
    // Trả về số lượng dữ liệu của từng User
    private static int cDataofUser(String user) {
        return DATA.get(user).size();
    }
    // Tạo User trong file và thêm vào Data
    private static void createUser(String user) {
        String path = "src/Data/UserTemp/" + user;
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
            DATA.put(user, new ArrayList<>());
        }
    }
    // Xoá User trong file và trong Data
    private static void deleteUser(String user) {
        String path = "src/Data/UserTemp/" + user;
        File file = new File(path);
        if (file.exists()) {
            file.delete();
            DATA.remove(user);
        } else {
            System.out.println("Khong ton tai user: " + user);
        }
    }
    // Trả về định dạng tên
    private static String formatName(String nameUser, String typeGame, int idGame) {
        return nameUser + "_" + typeGame + "_" + String.valueOf(idGame);
    }
    // Trả về tên file mới
    private static String createNameFile(String nameUser, String typeGame) {
        int idGame = 1;
        String nameFile = formatName(nameUser, typeGame, idGame);;
        for (int i = 0; i < DATA.get(nameUser).size(); i++) {
            nameFile = formatName(nameUser, typeGame, idGame);
            if (DATA.get(nameUser).get(i).contains(nameFile)) {
                idGame++;
            } else {
                break;
            }
        }
        return nameFile;
    }
    // Thêm dữ liệu vào User
    private static void createData(String data) {
        String [] t = data.split("_");
        String user = t[0], typeGame = t[1];
        String fileName = createNameFile(user, typeGame);
        String path = "src/Data/UserTemp/" + user + "/" + fileName + ".txt";
        BufferedWriter writer = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            writer = new BufferedWriter(fileWriter);
            writer.write("Test create data."); // Dữ liệu sẽ đc thêm vào file
            DATA.get(user).add(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // Xoá dữ liệu trong User
    private static void deleteData(String data) { // TODO : dont test  this function 
        String [] t = data.split("_");
        String user = t[0], typeGame = t[1], idGame = t[2];
        String fileName = formatName(user, typeGame, Integer.parseInt(idGame));
        File file = new File("src/Data/UserTemp/" + user + "/" + fileName);
        try {
            file.delete();
            DATA.get(user).remove(data);
        } catch (NullPointerException e) {
            System.out.println("File not found.");
        }
    }
    public static void main(String[] args) {
        String path = "src/Data/UserTemp";
        File file = new File(path);
        System.out.println();
        System.out.println("Information: ");

        readData(path);
        printData();

        createData("User1_Game1");

    }
}

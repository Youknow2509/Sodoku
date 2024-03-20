package src.Example;

import javafx.util.Pair;
import src.Model.NodeGame;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.*;

public class TestUser {
    private static Map<String, ArrayList<String>> DATA = new Hashtable<String, ArrayList<String>>();
    private static String pathRoot = "src/Data/UserTemp";
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
                        if (f1.isFile() && f1.getName().contains(".txt")){ // Lọc file .txt
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
        int index = 1;
        System.out.println("Data hava: " +countUser() + " users.");
        for (Map.Entry<String, ArrayList<String>> entry : DATA.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            System.out.print("User " + index + " " + key + ", " + cDataofUser(entry.getKey()) + " file: ");
            index++;
            for (String s : value) {
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
        String path = pathRoot + "/" + user;
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
            DATA.put(user, new ArrayList<>());
        } else {
            System.out.println("User da ton tai: " + user);
        }
    }
    // Xoá User trong file và trong Data
    private static void deleteUser(String user) {
        String path = pathRoot + "/" + user;
        File file = new File(path);
        if (file.exists()) {
            File [] lFiles = file.listFiles();
            for (File f : lFiles) {
                f.delete();
            }
            file.delete();
            DATA.remove(user);
        } else {
            System.out.println("Khong ton tai user: " + user);
        }
    }
    // Trả về định dạng tên
    private static String formatName(String typeGame, int idGame) {
        return typeGame + "_" + String.valueOf(idGame);
    }
    // Trả về tên file mới
    private static String createNameFile(String nameUser, String typeGame) {
        int idGame = 1;
        String nameFile = formatName(typeGame, idGame);;
        ArrayList<String> listFile = null;
        try {
            listFile = DATA.get(nameUser);
        } catch (NullPointerException e) {
            System.out.println("Khong tim thay user.");
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
    // Thêm dữ liệu vào User
    private static void createData(String user, String typeGame) {
        String fileName = createNameFile(user, typeGame);
        String path = pathRoot + "/" + user + "/" + fileName + ".txt";
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
                DATA.get(user).add(fileName);
            } catch (IOException e) {
                createUser(user);
                createData(user, typeGame);
            }
        } else {
            System.out.println("File da ton tai: " + fileName);
        }
    }
    // Xoá dữ liệu trong User
    private static void deleteData(String user, String data) {
        File file = new File(pathRoot + "/" + user + "/" + data + ".txt");
        try {
            file.delete();
            DATA.get(user).remove(data);
        } catch (NullPointerException e) {
            System.out.println("Khong tim thay file de xoa.");
        }
    }
    // Truyền dữ liệu vào file
    private static void writeData(String path, NodeGame [][] nodeGame, int otorng, int luotsai) {
        BufferedWriter writer = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            writer = new BufferedWriter(fileWriter);
            writer.write(nodeGameToData(nodeGame, otorng, luotsai));
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
    // NodeGame -> data
    private static String nodeGameToData(NodeGame[][] nodeGame, int otorng, int luotsai) {
        String res = "";
        int size = nodeGame.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                res += nodeGame[i][j].getValue() + " ";
            }
            res += "\n";
        }
        res += otorng + " " + luotsai;
        return res;
    }
    public static void main(String[] args) {
        runTest();
    }
    private static void runTest() {
        System.out.println();
        String input = "";
        Scanner scanner = new Scanner(System.in);
        Boolean loop = true;
        while (loop) {
            readData(pathRoot);
            printData();
            System.out.println("1. Create User.");
            System.out.println("2. Delete User.");
            System.out.println("3. Create Data.");
            System.out.println("4. Delete Data.");
            System.out.println("5. Show Data.");
            System.out.println("6. Exit.");
            System.out.print("Choose: ");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.print("Nhap ten user: ");
                    String user = scanner.nextLine();
                    createUser(user);
                    break;
                case "2":
                    System.out.print("Nhap ten user: ");
                    user = scanner.nextLine();
                    deleteUser(user);
                    break;
                case "3":
                    System.out.print("Nhap ten user: ");
                    user = scanner.nextLine();
                    System.out.print("Nhap loai game: ");
                    String typeGame = scanner.nextLine();
                    createData(user, typeGame);
                    break;
                case "4":
                    System.out.print("Nhap ten user: ");
                    user = scanner.nextLine();
                    System.out.print("Nhap ten file: ");
                    String data = scanner.nextLine();
                    deleteData(user, data);
                    break;
                case "5":
                    //
                    break;
                case "6":
                    loop = false;
                    break;
                default:
                    System.out.println("Nhap sai.");
                    break;
            }
        }
        scanner.close();
        return;
    }
}

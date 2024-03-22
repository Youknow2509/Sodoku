package src.Utils;

import src.Model.Game;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class HandleData {
    // Variables
    public static String pathRoot = "src/Data/UserTemp"; // Đường dẫn đến thư mục chứa dữ liệu
    public static Map<String, ArrayList<String>> DATA = new Hashtable<String, ArrayList<String>>(); // Lưu trữ dữ liệu từ Folder
    
    // Tạo User trong file và thêm vào Data
    public static void createUser(String user) {
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
    public static void deleteUser(String user) {
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
    // Thêm file dữ liệu vào User - Tạo file mới và chưa truyền dữ liệu
    public static void createFileData(String user, String typeGame) {
        String fileName = createNameFile(user, typeGame);
        String path = pathRoot + "/" + user + "/" + fileName + ".txt";
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
                DATA.get(user).add(fileName);
            } catch (IOException e) {
                createUser(user);
                createFileData(user, typeGame);
            }
        } else {
            System.out.println("File da ton tai: " + fileName);
        }
    }
    // Xoá file dữ liệu trong User
    public static void deleteFileData(String user, String nameFile) {
        File file = new File(pathRoot + "/" + user + "/" + nameFile + ".txt");
        try {
            file.delete();
            DATA.get(user).remove(nameFile);
        } catch (NullPointerException e) {
            System.out.println("Khong tim thay file de xoa.");
        }
    }
    // Truyền dữ liệu vào file
    public static void writeDataToFile(String path, Game g) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(g);
        } catch (NotSerializableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // Trả về dữ liệu từ file
    public static Game readDataFromFile(String path) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Game g = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            g = (Game) ois.readObject();
        } catch (EOFException e) {
            System.out.println("Het file.");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Khong tim thay file.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Khong tim thay class.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Khong tim thay file.");
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return g;
    }
    // Help functions
    private static String createNameFile(String nameUser, String typeGame) {
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
    // Help createFileData - Trả về định dạng tên : typeGame_idGame (typeGame: 9x9, 16x16, 25x25, idGame: 1, 2, 3, ...)
    private static String formatName(String typeGame, int idGame) {
        return typeGame + "_" + String.valueOf(idGame);
    }
}

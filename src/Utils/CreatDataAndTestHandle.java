package src.Utils;

import src.Model.Game;
import src.Utils.GeneratorGame;
import src.View.ShowGame;
import java.io.*;
import java.util.*;

public class CreatDataAndTestHandle {
    // Variables
    private static Map<String, ArrayList<String>> DATA = new Hashtable<String, ArrayList<String>>(); // Lưu trữ dữ liệu từ Folder
    private static String pathRoot = "src/Data/UserTemp"; // Đường dẫn đến thư mục chứa dữ liệu
    private static Game game = null; // Dữ liệu game
    private static ShowGame showGame = null; // Thêm vào để đọc dữ liệu ra để kiểm tra ( Để test )
    private static GeneratorGame generatorGame = null; // Thêm để tạo ra dữ liệu để (truyền , xuất), đọc dữ liệu ra để kiểm tra ( Để test )

    // Method :
    // Quét Folder
    private static void readFolder(String path) {
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
    private static void printFolderData() {
        int index = 1;
        System.out.println("Data hava: " +countUser() + " users.");
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
    // Thêm file dữ liệu vào User - Tạo file mới và chưa truyền dữ liệu
    private static void createFileData(String user, String typeGame) {
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
    private static void deleteFileData(String user, String nameFile) {
        File file = new File(pathRoot + "/" + user + "/" + nameFile + ".txt");
        try {
            file.delete();
            DATA.get(user).remove(nameFile);
        } catch (NullPointerException e) {
            System.out.println("Khong tim thay file de xoa.");
        }
    }
    // Truyền dữ liệu vào file
    private static void writeDataToFile(String path, Game g) {
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
    private static Game readDataFromFile(String path) {
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

    // Help functoin :
    // Help Print Folder Data - Trả về số lượng User
    private static int countUser() {
        return DATA.size();
    }
    // Help Print Folder Data - Trả về số lượng dữ liệu của từng User
    private static int countDataofUser(String user) {
        return DATA.get(user).size();
    }
    // Help createFileData - Trả về định dạng tên : typeGame_idGame (typeGame: 9x9, 16x16, 25x25, idGame: 1, 2, 3, ...)
    private static String formatName(String typeGame, int idGame) {
        return typeGame + "_" + String.valueOf(idGame);
    }
    // Help createFileData - Trả về tên file mới, chọn idGame thích hợp để tạo file mới
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

    public static void main(String[] args) {
        //String path = "src/Data/UserTemp/v/test.txt";
        //GeneratorGame generatorGame = new GeneratorGame(9, 3, 12, 3);
        //showGame = new ShowGame(generatorGame.getGame());
        //writeDataToFile("src/Data/UserTemp/v/test.txt", generatorGame.getGame());
        //showGame = new ShowGame(readDataFromFile(path));
        //showGame.show();
        runTest();
    }
    private static void runTest() {
        System.out.println();
        // Variables temp
        String chooses = "";

        String path = "";

        String user = "";

        String typeGame = "";
        String nameFile = "";

        String size = "";
        String oTrong = "";
        String luotsai = "";

        // Scanner
        Scanner scanner = new Scanner(System.in);
        // Var loop
        Boolean loop = true;
        while (loop) {
            readFolder(pathRoot);
            printFolderData();

            System.out.println("1. Tạo người dùng mới.");
            System.out.println("2. Tạo file lưu trữ dữ liệu.");
            System.out.println("3. Random ra dữ liệu.");
            System.out.println("4. Truyền dữ liệu 'vào' file người dùng.");
            System.out.println("5. In ra màn hình dữ liệu trong file người dùng");
            System.out.println("6. Xuất dữ liệu thành file");
            System.out.println("7. Xoá người dùng.");
            System.out.println("8. Xoá file lưu trữ dữ liệu.");
            System.out.println("9. Exit.");
            System.out.print("Choose: ");
            chooses = scanner.nextLine();

            switch (chooses) {
                case "1": // Tạo người dùng mới
                    System.out.print("Nhập tên người dùng cần tạo: ");
                    user = scanner.nextLine();
                    createUser(user);
                    break;
                case "2": // Tạo file lưu trữ dữ liệu
                    System.out.print("Nhập tên người dùng file: ");
                    user = scanner.nextLine();
                    System.out.print("Nhập loại game (9x9, 16x16, 25x25, v.v): ");
                    typeGame = scanner.nextLine();
                    createFileData(user, typeGame);
                    break;
                case "3": // Random ra dữ liệu
                    System.out.print("Nhập kích thước game (9x9, 16x16, 25x25, v.v): ");
                    size = scanner.nextLine();
                    System.out.print("Nhập số ô trống: ");
                    oTrong = scanner.nextLine();
                    System.out.print("Nhập số lượt sai: ");
                    luotsai = scanner.nextLine();
                    try {
                        generatorGame = new GeneratorGame(Integer.parseInt(size), (int) Math.sqrt(Integer.parseInt(size)), Integer.parseInt(oTrong), Integer.parseInt(luotsai));
                    } catch (NumberFormatException e) {
                        System.out.println("Vui lòng nhập số nguyên !!!");
                        break;
                    }
                    game  = generatorGame.getGame();
                    showGame = new ShowGame(game);
                    showGame.show();
                    break;
                case "4": // Truyền dữ liệu 'vào' file người dùng
                    if (game == null) {
                        System.out.println("Chưa có dữ liệu game !!!");
                    } else {
                        System.out.print("Nhập tên người dùng: ");
                        user = scanner.nextLine();
                        System.out.print("Nhập tên file: ");
                        nameFile = scanner.nextLine();
                        path = pathRoot + "/" + user + "/" + nameFile + ".txt";
                        writeDataToFile(path, game);
                    }
                    break;
                case "5": // In ra màn hình dữ liệu trong file người dùng
                    System.out.print("Nhập tên người dùng: ");
                    user = scanner.nextLine();
                    System.out.print("Nhập tên file: ");
                    nameFile = scanner.nextLine();
                    path = pathRoot + "/" + user + "/" + nameFile + ".txt";
                    showGame = new ShowGame(readDataFromFile(path));
                    showGame.show();
                    break;
                case "6": // Xuất dữ liệu thành file
                    if (game == null) {
                        System.out.println("Chưa có dữ liệu game !!!");
                    } else {
                        System.out.print("Nhập tên người dùng nhận dữ liệu: ");
                        user = scanner.nextLine();
                        System.out.print("Nhập tên file chứa dữ liệu: ");
                        nameFile = scanner.nextLine();
                        path = pathRoot + "/" + user + "/" + nameFile + ".txt";
                        writeDataToFile(path, game);
                    }
                    break;
                case "7": // Xoá người dùng
                    System.out.print("Nhập tên người dùng cần xoá: ");
                    user = scanner.nextLine();
                    deleteUser(user);
                    break;
                case "8": // Xoá file lưu trữ dữ liệu
                    System.out.print("Nhập tên người dùng: ");
                    user = scanner.nextLine();
                    System.out.print("Nhập tên file xoá: ");
                    nameFile = scanner.nextLine();
                    deleteFileData(user, nameFile);
                    break;
                case "9": // Exit
                    System.out.println("Thoát chương trình !!!");
                    loop = false;
                    break;
                default:
                    System.out.println("Vui lòng chọn đúng giá trị !!!");
                    break;
            }
        }
        scanner.close();
        return;
    }
}

package src.Example;

import src.Model.Game;
import src.Model.GeneratorGame;
import src.View.ShowGame;
import java.io.*;
import java.util.*;

public class TestUser {
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
    private static void writeData(String path, Game g) {
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
    private static Game readData(String path) {
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
        //writeData("src/Data/UserTemp/v/test.txt", generatorGame.getGame());
        //showGame = new ShowGame(readData(path));
        //showGame.show();
        runTest();
    }
    private static void runTest() {
        System.out.println();
        // Variables temp
        String input = "";

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
            System.out.println("5. Thêm dữ liệu vào file người dùng."); // TODO viết tiếp phần hiển thị loop, các phương thức đã check ok
            System.out.println("3. Xoá dữ liệu người dùng.");
            System.out.println("4. Xoá file lưu trữ dữ liệu.");
            System.out.println("6. Doc du lieu tu data va hien thi."); // Sau khi doc du lieu luu ra game
            System.out.println("7. Xuat du lieu ra data");
            System.out.println("10. Exit.");
            System.out.print("Choose: ");
            input = scanner.nextLine();
            switch (input) {
                case "1": // Create User
                    System.out.print("Nhap ten user: ");
                    user = scanner.nextLine();
                    createUser(user);
                    break;
                case "2": // Delete User
                    System.out.print("Nhap ten user: ");
                    user = scanner.nextLine();
                    deleteUser(user);
                    break;
                case "3": // Create file store data
                    System.out.print("Nhap ten user: ");
                    user = scanner.nextLine();
                    System.out.print("Nhap loai game: ");
                    typeGame = scanner.nextLine();
                    createFileData(user, typeGame);
                    break;
                case "4": // Delete file store data
                    System.out.print("Nhap ten user: ");
                    user = scanner.nextLine();
                    System.out.print("Nhap ten file: ");
                    nameFile = scanner.nextLine();
                    deleteFileData(user, nameFile);
                    break;
                case "5": // Them data vao user
                    System.out.print("Nhap ten user: ");
                    user = scanner.nextLine();
                    System.out.print("Nhap ten file data: ");
                    nameFile = scanner.nextLine();
                    path = pathRoot + "/" + user + "/" + nameFile + ".txt";
                    writeData(path, game);
                    break;
                case "6": // Doc du lieu tu data va hien thi
                    System.out.print("Nhap ten user: ");
                    user = scanner.nextLine();
                    System.out.print("Nhap ten file: ");
                    nameFile = scanner.nextLine();
                    path = pathRoot + "/" + user + "/" + nameFile + ".txt";
                    game = readData(path);
                    showGame = new ShowGame(game);
                    showGame.show();
                    break;
                case "7": // Xuat du lieu ra data
                    System.out.print("Nhap ten user: ");
                    user = scanner.nextLine();
                    System.out.print("Nhap ten file: ");
                    nameFile = scanner.nextLine();
                    path = pathRoot + "/" + user + "/" + nameFile + ".txt";
                    writeData(path, game);
                    break;
                case "8": // Generate data and show
                    System.out.println("Nhap loai game: ");
                    size = scanner.nextLine();
                    System.out.println("Nhap so o trong:");
                    oTrong = scanner.nextLine();
                    System.out.println("Nhap so luot sai:");
                    luotsai = scanner.nextLine();
                    int SIZE = 0;
                    int OTRONG = 0;
                    int LUOTSAI = 0;
                    try {
                        SIZE = Integer.parseInt(size);
                        OTRONG = Integer.parseInt(oTrong);
                        LUOTSAI = Integer.parseInt(luotsai);
                    } catch (NumberFormatException e) {
                        System.out.println("Nhap sai dinh dang.");
                        break;
                    }
                    generatorGame = new GeneratorGame(SIZE, (int) Math.sqrt(SIZE), OTRONG, LUOTSAI);
                    showGame = new ShowGame(generatorGame.getGame());
                    showGame.show();
                    break;
                case "9": // Exit
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

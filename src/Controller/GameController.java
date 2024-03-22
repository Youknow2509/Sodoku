package src.Controller;

import src.Model.Game;
import src.Model.NodeGame;
import src.Model.Validate;
import src.Utils.HandleData;
import src.Utils.InputException;
import src.View.MainGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {
    // Variables
    private MainGame mainGame = null;
    private Scanner scanner = null;
    private Validate validate = null;
    private String path = "src/Data/User/";
    //
    private Game game = null;
    private String userName = null;
    private String typeGame = null;
    private String fileName = null;
    //
    private boolean loop = true;
    private int row, col, value;
    // Constructor
    public GameController(){super();}
    public GameController(Game game, String userName){
        super();
        this.game = game;
        this.userName = userName;
        this.typeGame = createTypeGame(game.getSize());

        mainGame = new MainGame(game);
        validate = new Validate(game);
    }
    // Application functions
    public void Application(){
        scanner = new Scanner(System.in);
        System.out.println();
        while (loop) {
            mainGame.showGame();
            // Nhap vi tri hang cot
            nhapHang();
            nhapCot();
            // Kiểm tra đã chọn đúng ô chưa, nếu chưa bắt nhập lại
            if ((game.getListNodeGame())[row][col].getValue() == 0) {
                nhapGiatri();
                // Kiểm tra giá trị nhập vào có hợp lệ không:
                // - Đúng: Thay đổi giá trị, giảm số ô trống.
                // - Sai:  Giảm số lượt còn lại.
                NodeGame nodeTemp = new NodeGame(row, col, value);
                if (validate.ValidateSafe(nodeTemp)) {
                    (game.getListNodeGame())[row][col].setValue(value);
                    game.giamOtrong();
                } else {
                    mainGame.inputError();
                    game.giamLuotsai();
                }
            } else {
                System.out.println("Hay chon dung vi tri trong");
            }
            checkLoop();
        }
    }
    // Menu
    public void menu(){
        int choose = 2;
        System.out.println("1. Save and back to user");
        System.out.println("2. Continue");
        System.out.println("3. Exit");
        System.out.print("Chon: ");
        try {
            choose = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Vui lòng nhập số nguyên.");
            scanner.nextLine(); // Xóa dòng không hợp lệ khỏi input
            menu();
        }
        switch (choose){
            case 1:
                scanner.nextLine();
                System.out.print("Tên file bạn muốn lưu: ");
                fileName = scanner.nextLine();
                HandleData.createFileData(userName, fileName);
                HandleData.writeDataToFile(path + "/" + userName + "/" + fileName + ".txt", game);
                backToUser();
                scanner.close();
                break;
            case 2:
                Application();
                break;
            case 3:
                scanner.close();
                System.out.println("Goodbye " + userName + "!");
                System.exit(0);
                break;
            default:
                System.out.println("Vui lòng chọn giá trị từ 1 đến 3.");
                menu();
                break;
        }
    }

    // Help functions
    // Back to user
    private void backToUser(){
        UserController userController = new UserController();
        userController.Application();
    }
    // Kiểm tra game đã kết thúc chưa
    private void checkLoop(){
        if (game.getOtrong() == 0) {
            loop = false;
            scanner.close();
            mainGame.gameWin();
            backToUser();
        }
        if (game.getLuotsai() == 0) {
            mainGame.gameOver();
            scanner.close();
            loop = false;
            backToUser();
        }
    }
    private String createTypeGame(int type){
        String t = String.valueOf(type);
        return t + "x" + t;
    }
    private void nhapHang() {
        mainGame.inputRow();
        try {
            row = scanner.nextInt();
            if (row < 0 || row >= game.getSize()) {
                throw new InputException("Vui long nhap toa do trong khoang 0 den " + (game.getSize() - 1));
            }
        } catch (InputException e) {
            System.out.println(e.getMessage());
            nhapHang();
        } catch (InputMismatchException e) {
            String input = scanner.nextLine();// Lưu giá trị và Xóa dòng không hợp lệ khỏi input
            input = input.toLowerCase();
            if (input.equals("menu")) {
                menu();
            } else {
                System.out.println("Vui lòng nhập số nguyên.");
                nhapHang();
            }
        }
    }
    private void nhapCot() {
        mainGame.inputCol();
        try {
            col = scanner.nextInt();
            if (col < 0 || col >= game.getSize()) {
                throw new InputException("Vui long nhap toa do trong khoang 0 den " + (game.getSize() - 1));
            }
        } catch (InputException e) {
            System.out.println(e.getMessage());
            nhapCot();
        } catch (InputMismatchException e) {
            String input = scanner.nextLine();// Lưu giá trị và Xóa dòng không hợp lệ khỏi input
            input = input.toLowerCase();
            if (input.equals("menu")) {
                menu();
            } else {
                System.out.println("Vui lòng nhập số nguyên.");
                nhapCot();
            }
        }
    }
    private void nhapGiatri() {
        mainGame.inputValue();
        try {
            value = scanner.nextInt();
            if (value < 1 || value > game.getSize()) {
                throw new InputException("Vui long nhap gia tri trong khoang 1 den " + game.getSize());
            }
        } catch (InputException e) {
            System.out.println(e.getMessage());
            nhapGiatri();
        } catch (InputMismatchException e) {
            String input = scanner.nextLine();// Lưu giá trị và Xóa dòng không hợp lệ khỏi input
            input = input.toLowerCase();
            if (input.equals("menu")) {
                menu();
            } else {
                System.out.println("Vui lòng nhập số nguyên.");
                nhapGiatri();
            }
        }
    }
    // Getters and Setters

    public MainGame getCmdMainGame() {
        return mainGame;
    }

    public void setCmdMainGame(MainGame mainGame) {
        this.mainGame = mainGame;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Validate getValidate() {
        return validate;
    }

    public void setValidate(Validate validate) {
        this.validate = validate;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTypeGame() {
        return typeGame;
    }

    public void setTypeGame(String typeGame) {
        this.typeGame = typeGame;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

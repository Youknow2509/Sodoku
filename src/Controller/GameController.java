//package src.Controller;
//
//import src.Model.Game;
//import src.Model.NodeGame;
//import src.Model.Validate;
//import src.View.ClearScreen;
//import src.View.ShowGame;
//import src.View.StageGame;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//import src.Utils.InputException;
//
//public class GameController {
//    // Khai bao cac doi tuong can thiet
//    public static final Game game = new Game();
//    //private final ShowGame showListNodeGame = new ShowGame();
//    private final Validate validate = new Validate();
//    private Scanner input = new Scanner(System.in);
//    private final ClearScreen clearScreen = new ClearScreen();
//    private final StageGame stageGame = new StageGame();
//    // Bien trong game
//    public static int otrong;
//    public static boolean g = true;
//    public static int c = 3;
//    private int size = 9;
//    public int x, y, value; // Toa do va gia tri nhap vao
//
//    public GameController() {
//        otrong = Game.getOtrong();
//        size = Game.getSize();
//    }
//    public void run() {
//        NodeGame [][] arr = Game.getBoardRes();
//        while (g && c > 0 && otrong > 0) {
//            clearScreen.run();
//            showListNodeGame.show(arr);
//            stageGame.stage();
//
//            nhapHang();
//            nhapCot();
//            if (arr[x][y].getValue() == 0) {
//                nhapGiatri();
//                if (validate.ValidateSafe(arr, new NodeGame(x, y, value))) {
//                    arr[x][y].setValue(value);
//                    otrong--;
//                } else {
//                    c--;
//                }
//            } else {
//                System.out.println("Hay chon dung vi tri trong");
//            }
//            if (otrong == 0) {
//                stageGame.gameWin();
//                break;
//            }
//            if (c == 0) {
//                stageGame.gameOver();
//                break;
//            }
//        }
//        input.close();
//        return;
//    }
//    private void nhapHang() {
//        stageGame.inputR();
//        try {
//            x = input.nextInt();
//
//            if (x < 0 || x >= size || y < 0 || y >= size) {
//                throw new InputException("Vui long nhap toa do trong khoang 0 den " + (size - 1));
//            }
//        } catch (InputException e) {
//            System.out.println(e.getMessage());
//            nhapHang();
//        } catch (InputMismatchException e) {
//            System.out.println("Vui lòng nhập số nguyên.");
//            String ip = input.nextLine();
//            if (ip.equals("menu")) { // input.nextLine(); // Xóa dòng không hợp lệ khỏi input
//                System.out.println("Ban da chon menu");
//            } else if (ip.equals("q")) {
//                System.out.println("Ban da chon thoat");
//                System.exit(0);
//            } else{
//                nhapHang();
//            }
//        }
//    }
//    private void nhapCot() {
//        stageGame.inputC();
//        try {
//            y = input.nextInt();
//            if (x < 0 || x >= size || y < 0 || y >= size) {
//                throw new InputException("Vui long nhap toa do trong khoang 0 den " + (size - 1));
//            }
//        } catch (InputException e) {
//            System.out.println(e.getMessage());
//            nhapCot();
//        } catch (InputMismatchException e) {
//            System.out.println("Vui lòng nhập số nguyên.");
//            String ip = input.nextLine();
//            if (ip.equals("menu")) { // input.nextLine(); // Xóa dòng không hợp lệ khỏi input
//                System.out.println("Ban da chon menu");
//            } else if (ip.equals("q")) {
//                System.out.println("Ban da chon thoat");
//                System.exit(0);
//            } else{
//                nhapCot();
//            }
//        }
//    }
//    private void nhapGiatri() {
//        stageGame.inputV();
//        try {
//            value = input.nextInt();
//            if (value < 1 || value > size) {
//                throw new InputException("Vui long nhap gia tri trong khoang 1 den " + size);
//            }
//        } catch (InputException e) {
//            System.out.println(e.getMessage());
//            nhapGiatri();
//        } catch (InputMismatchException e) {
//            System.out.println("Vui lòng nhập số nguyên.");
//            String ip = input.nextLine();
//            if (ip.equals("menu")) { // input.nextLine(); // Xóa dòng không hợp lệ khỏi input
//                System.out.println("Ban da chon menu");
//            } else if (ip.equals("q")) {
//                System.out.println("Ban da chon thoat");
//                System.exit(0);
//            } else{
//                nhapGiatri();
//            }
//        }
//    }
//}

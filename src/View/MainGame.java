package src.View;


import src.Model.Game;

public class MainGame { // TODO vẫn thiếu hiển thị cuả loop Application
    // Variables
    Game game = null;
    ShowGame showGame = null;
    // Constructor
    public MainGame() {
        super();
    }
    public MainGame(Game game) {
        super();
        this.game = game;
        showGame = new ShowGame(game);
    }
    // Name file save
    public void nameFileSave() {
        System.out.print("Tên file bạn muốn lưu: ");
    }
    // Hien thi menu
    public void showMenu() {
        System.out.println("1. Save Game");
        System.out.println("2. Continue Game");
        System.out.println("3. Back To Home");
        System.out.println("4. Exit");
        System.out.print("Choose: ");
    }
    // Hien thi listnodegame, o trong, so luot sai
    public void showGame() {
        showGame.show();
    }
    // Hien thi nhap hang
    public void inputRow() {
        System.out.print("Nhap toa do hang: ");
    }
    // Hien thi nhap cot
    public void inputCol() {
        System.out.print("Nhap toa do cot: ");
    }
    // Hien thi nhap gia tri
    public void inputValue() {
        System.out.print("Nhap gia tri: ");
    }
    // Thong bao nhap sai gia tri
    public void inputValueError() {
        System.out.println("Nhap sai gia tri!");
    }
    // Thong bao nhap sai vi tri
    public void inputPositionError() {
        System.out.println("Hay chon dung vi tri trong");
    }
    // Thong bao nhap sai dinh dang so
    public void inputNumberFormatError() {
        System.out.println("Vui long nhap so nguyen.");
    }
    // Thong bao game win
    public void gameWin() {
        System.out.println("Win!");
    }
    // Thong bao game over
    public void gameOver() {
        System.out.println("Game Over!");
    }
    // Goodbye user
    public void goodbye(String userName) {
        System.out.println("Goodbye " + userName + "!");
    }
}

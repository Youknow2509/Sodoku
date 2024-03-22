package src.View;


import src.Model.Game;

public class CmdMainGame { // TODO vẫn thiếu hiển thị cuả loop Application
    // Variables
    Game game = null;
    ShowGame showGame = null;
    // Constructor
    public CmdMainGame() {
        super();
    }
    public CmdMainGame(Game game) {
        super();
        this.game = game;
        showGame = new ShowGame(game);
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
    public void inputError() {
        System.out.println("Nhap sai gia tri!");
    }
    // Thong bao game win
    public void gameWin() {
        System.out.println("Win!");
    }
    // Thong bao game over
    public void gameOver() {
        System.out.println("Game Over!");
    }
}

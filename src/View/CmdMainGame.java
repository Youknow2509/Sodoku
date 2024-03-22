package src.View;


import src.Model.Game;

public class CmdMainGame { // TODO vẫn thiếu hiển thị cuả loop Application
    // Variables
    Game game = null;
    // Constructor
    public CmdMainGame() {
        super();
    }
    public CmdMainGame(Game game) {
        super();
        this.game = game;
    }

    public void inputRow() {
        System.out.print("Nhap toa do x: ");
    }
    public void inputCol() {
        System.out.print("Nhap toa do y: ");
    }
    public void inputValue() {
        System.out.print("Nhap gia tri: ");
    }
    public void gameWin() {
        System.out.println("Win!");
    }
    public void gameOver() {
        System.out.println("Game Over!");
    }
}

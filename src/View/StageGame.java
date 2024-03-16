package src.View;

import src.Controller.GameController;

public class StageGame {

    public void stage() {
        System.out.println("So lan sai con lai: " + GameController.c + "\nSo o trong con lai: " + GameController.otrong);
    }
    public void inputRC() {
        System.out.print("Nhap toa do x, y: ");
    }
    public void inputV() {
        System.out.print("Nhap gia tri: ");
    }
    public void gameWin() {
        System.out.println("Win!");
    }
    public void gameOver() {
        System.out.println("Game Over!");
        GameController.g = false;
        System.exit(0);
    }
}

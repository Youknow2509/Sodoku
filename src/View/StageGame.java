package src.View;

import src.Controller.GameController;

public class StageGame {

    public void stage() {
        System.out.println("So lan sai con lai: " + GameController.c + "\nSo o trong con lai: " + GameController.otrong);
    }
    public void inputR() {
        System.out.print("Nhap toa do x: ");
    }
    public void inputC() {
        System.out.print("Nhap toa do y: ");
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

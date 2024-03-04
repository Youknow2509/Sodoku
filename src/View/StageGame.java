package src.View;

import src.Controller.GameTest;
import src.Model.Game;

import java.util.Scanner;

public class StageGame {

    public void stage() {
        System.out.println("So lan sai con lai: " + GameTest.c + "\nSo o trong con lai: " + GameTest.otrong);
    }
    public void inputRC(Scanner input) {
        System.out.print("Nhap toa do x, y: ");
        GameTest.x = input.nextInt();
        GameTest.y = input.nextInt();
    }
    public void inputV(Scanner input) {
        System.out.print("Nhap gia tri: ");
        GameTest.value = input.nextInt();
    }
    public void gameWin() {
        System.out.println("Win!");
    }
    public void gameOver() {
        System.out.println("Game Over!");
        GameTest.g = false;
        System.exit(0);
    }
}

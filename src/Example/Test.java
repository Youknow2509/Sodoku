package src.Example;

import java.util.Scanner;

import src.Model.Game;
import src.Model.NodeGame;
import src.Model.Validate;
import src.View.ShowArray2d;

public class Test {
    private static void cleanScreen() {
        // Kiem tra he dieu hanh cua nguoi xu dung
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.out.print("\f");
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            System.out.print("\033[H\033[2J");
        }
    }

    private static boolean checkLocation(NodeGame [][] arr, int x, int y) {
        if (x >= 0 && x <= 8 && y >= 0 && y <= 8 && arr[x][y].getValue() == 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        final Game game = new Game();
        final ShowArray2d showArray2D = new ShowArray2d();
        final Validate validate = new Validate();
        final Scanner input = new Scanner(System.in);

        int otrong;
        boolean g = true;
        int c = 3;
        int x, y, value;

        cleanScreen();
        System.out.println("Game Sodoku\nNhap so luong o trong thich hop !\n");

        do {
            System.out.print("Nhap tu 1 den 33: ");
            otrong = input.nextInt();
        } while (otrong < 0 || otrong > 33);

        game.initData(otrong);

        NodeGame [][] arr = game.getBoardMissing();

        while (g && c > 0 && otrong > 0) {

            cleanScreen();
            showArray2D.show(arr);

            System.out.println("So lan sai con lai: " + c + "\nSo o trong con lai: " + otrong);
            System.out.print("Nhap toa do x, y: ");
            x = input.nextInt();
            y = input.nextInt();

            if (checkLocation(arr, x, y)) {
                System.out.print("Nhap gia tri: ");
                value = input.nextInt();

                if (validate.ValidateSafe(arr, new NodeGame(x, y, value))) {
                    arr[x][y].setValue(value);
                    otrong--;
                } else {
                    c--;
                }
            }
            if (c == 0) {
                System.out.println("Game Over!");
                g = false;
                System.exit(0);
            }
        }
        System.out.println("Win!");
        input.close(); // Dong scanner tranh tinh trang do di vung nho]
    }
}

package src.Controller;

import src.Model.Game;
import src.Model.NodeGame;
import src.Model.Validate;
import src.View.ClearScreen;
import src.View.ShowArray2d;
import src.View.StageGame;

import java.util.Scanner;

public class GameTest {
    // Khai bao cac doi tuong can thiet
    public static final Game game = new Game();
    private final ShowArray2d showArray2D = new ShowArray2d();
    private final Validate validate = new Validate();
    private final Scanner input = new Scanner(System.in);
    private final ClearScreen clearScreen = new ClearScreen();
    private final StageGame stageGame = new StageGame();
    // Bien trong game
    public static int otrong;
    public static boolean g = true;
    public static int c = 3;
    public static int x, y, value; // Toa do va gia tri nhap vao
    public GameTest(int otrong, int err) {
        this.otrong = otrong;
        this.c = err;
    }
    public GameTest() {
        this.otrong = 10;
    }
    private boolean checkLocation(NodeGame [][] arr, int x, int y) {
        if (x >= 0 && x <= 8 && y >= 0 && y <= 8 && arr[x][y].getValue() == 0) {
            return true;
        }
        return false;
    }
    public void run() {
        game.initData(otrong);
        NodeGame [][] arr = game.getBoardMissing();
        while (g && c > 0 && otrong > 0) {
            clearScreen.run();
            showArray2D.show(arr);
            stageGame.stage();
            stageGame.inputRC(input);
            if (checkLocation(arr, x, y)) {
                stageGame.inputV(input);
                if (validate.ValidateSafe(arr, new NodeGame(x, y, value))) {
                    arr[x][y].setValue(value);
                    otrong--;
                } else {
                    c--;
                }
            }
            if (c == 0) {
                stageGame.gameOver();
            }
        }
        stageGame.gameWin();
        input.close(); // Dong scanner tranh tinh trang do di vung nho]
    }
}

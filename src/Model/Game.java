package src.Model;

import src.Data.DataLoad;
import src.View.ShowArray2d;

public class Game {
    // Attributes
    private static NodeGame [][] boardRes;
    private static int size;
    private static int sizeBox;
    private static int otrong;
    private final ShowArray2d showArray2D = new ShowArray2d();
    private final DataLoad dataLoad = new DataLoad();
    // Constructor
    public Game() {
        dataLoad.load("src/Data/Game/g1/Ez/1.txt");
        otrong = 10;
        boardRes = dataLoad.getArr();
        size = dataLoad.getSize();
        sizeBox = dataLoad.getSizeBox();
    }
    public Game(int n) {

    }

    // Getters and Setters
    public static NodeGame[][] getBoardRes() {
        return boardRes;
    }

    public static void setBoardRes(NodeGame[][] b) {
        boardRes = b;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        Game.size = size;
    }

    public static int getSizeBox() {
        return sizeBox;
    }

    public static void setSizeBox(int sizeBox) {
        Game.sizeBox = sizeBox;
    }

    public static int getOtrong() {
        return otrong;
    }

    public static void setOtrong(int otrong) {
        Game.otrong = otrong;
    }
}

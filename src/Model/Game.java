package src.Model;

import src.View.ShowArray2d;

public class Game {
    // Attributes
    private NodeGame [][] boardRes;
    private NodeGame [][] boardMission;

    private int n;
    private final Generator generator = new Generator(9);
    private final ShowArray2d showArray2D = new ShowArray2d();

    // Constructor
    public Game() {
    }
    public Game(int n) {
        initData(n);
    }

    // Getters and Setters

    public NodeGame[][] getBoardRes() {
        return boardRes;
    }

    public void setBoardRes(NodeGame[][] boardRes) {
        this.boardRes = boardRes;
    }

    public NodeGame[][] getBoardMissing() {
        return boardMission;
    }

    public void setBoardMissing(NodeGame[][] boardMissing) {
        this.boardMission = boardMissing;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void show() {
        showArray2D.show(boardMission);
    }

    public void initMission(int n) {
        boardMission = generator.coppyArray2d(boardRes);
        generator.removeDigits(boardMission, n);
    }
    public void initData(int n) {
        boardRes = generator.GeneratorGame();
        initMission(n);
        this.n = n;
    }

}

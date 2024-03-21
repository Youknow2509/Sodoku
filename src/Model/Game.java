package src.Model;

import java.io.Serializable;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L;

    // Attributes
    private NodeGame [][] listNodeGame = null;
    private int size = 0;
    private int sizeBox = 0;
    private int otrong = 0;
    private int luotsai = 0;
    // Constructor
    public Game() {
        super();
    }
    public Game(NodeGame [][] listNodeGame, int size, int sizeBox, int otrong, int luotsai) {
        super();
        this.listNodeGame = listNodeGame;
        this.size = size;
        this.sizeBox = sizeBox;
        this.otrong = otrong;
        this.luotsai = luotsai;
    }
    // Getters and Setters
    public NodeGame [][] getListNodeGame() {
        return listNodeGame;
    }
    public void setListNodeGame(NodeGame [][] listNodeGame) {
        this.listNodeGame = listNodeGame;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getSizeBox() {
        return sizeBox;
    }
    public void setSizeBox(int sizeBox) {
        this.sizeBox = sizeBox;
    }
    public int getOtrong() {
        return otrong;
    }
    public void setOtrong(int otrong) {
        this.otrong = otrong;
    }
    public int getLuotsai() {
        return luotsai;
    }
    public void setLuotsai(int luotsai) {
        this.luotsai = luotsai;
    }
    // To String
    @Override
    public String toString() {
        return "Game{" +
                "listNodeGame=" + listNodeGame +
                ", size=" + size +
                ", sizeBox=" + sizeBox +
                ", otrong=" + otrong +
                ", luotsai=" + luotsai +
                '}';
    }
}

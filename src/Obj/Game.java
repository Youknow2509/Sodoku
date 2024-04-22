package src.Obj;

import src.Model.NodeGame;

import java.io.Serializable;
import java.util.Arrays;

public class Game implements Serializable {
    // Attributes
    private NodeGame[][] listNodeGame = null;
    private int size = 0;
    private int sizeBox = 0;
    private int otrong = 0;
    private int luotsai = 0;
    private int iDGame;
    private int levelGame;
    // Constructor
    public Game(int GameID, int TypeGame, int Level, int Error, int Empty, NodeGame[][] Data) {
        super();
        this.iDGame = GameID;
        this.size = TypeGame;
        this.levelGame = Level;
        this.luotsai = Error;
        this.otrong = Empty;
        this.listNodeGame = Data;

        sizeBox = (int) Math.sqrt(size);
    }
    public Game(NodeGame [][] listNodeGame, int size, int sizeBox, int otrong, int luotsai) {
        super();
        this.listNodeGame = listNodeGame;
        this.size = size;
        this.sizeBox = sizeBox;
        this.otrong = otrong;
        this.luotsai = luotsai;
    }
    // Giam so o trong
    public void giamOtrong() {
        otrong--;
    }
    // Giam so luot sai
    public void giamLuotsai() {
        luotsai--;
    }
    // Tang so o trong
    public void tangOtrong() {
        otrong++;
    }
    // Tang so luot sai
    public void tangLuotsai() {
        luotsai++;
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

    // Adapter Getter and Setter GameId, TypeGame, Level, Error, Data
    public int getIDGame() {
        return iDGame;
    }
    public void setIDGame(int iDGame) {
        this.iDGame = iDGame;
    }
    public void setTypeGame(int typeGame) {
        setSize(typeGame);
    }
    public int getTypeGame() {
        return getSize();
    }
    public int getLevel() {
        return levelGame;
    }
    public void setLevel(int levelGame) {
        this.levelGame = levelGame;
    }
    public int getError() {
        return getLuotsai();
    }
    public void setError(int error) {
        setLuotsai(error);
    }
    public NodeGame [][] getData() {
        return listNodeGame;
    }
    public void setData(NodeGame [][] data) {
        setListNodeGame(data);
    }
    public int getEmpty() {
        return getOtrong();
    }
    public void setEmpty(int empty) {
        setOtrong(empty);
    }

    // To String
    @Override
    public String toString() {
        return "Game{" +
                "iDGame=" + iDGame +
                ", listNodeGame=" + Arrays.toString(listNodeGame) +
                ", size=" + size +
                ", sizeBox=" + sizeBox +
                ", otrong=" + otrong +
                ", luotsai=" + luotsai +
                ", levelGame=" + levelGame +
                '}';
    }
}

package src.Obj;

import src.Model.NodeGame;

import java.util.Arrays;

public class UserGame {
    // Var
    private int idUser;
    private int idGame;
    private String date;
    private int error;
    private NodeGame [][] data;

    // Constructor
    public UserGame() {
        super();
    }

    public UserGame(int idUser, int idGame, String date, int error, NodeGame[][] data) {
        super();
        this.idUser = idUser;
        this.idGame = idGame;
        this.date = date;
        this.error = error;
        this.data = data;
    }

    // Getters and Setters
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public NodeGame[][] getData() {
        return data;
    }

    public void setData(NodeGame[][] data) {
        this.data = data;
    }

    // To String
    @Override
    public String toString() {
        return "UserGame{" +
                "idUser=" + idUser +
                ", idGame=" + idGame +
                ", date='" + date + '\'' +
                ", error=" + error +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}

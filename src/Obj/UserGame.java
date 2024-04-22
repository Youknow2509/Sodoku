package src.Obj;

import src.DataGame.Handle.HandleData;
import src.DataGame.Handle.HandleDataSql;
import src.Model.NodeGame;
import src.Utils.GetTimeCurrent;

import java.util.Arrays;

public class UserGame {
    // Var
    private int idUserGame;
    private int idUser;
    private int idGame;
    private String date;
    private int typeGame;
    private String name;
    private int error;
    private int empty;
    private NodeGame [][] data;

    private HandleData handleData;

    // Constructor
    public UserGame(User user, Game game, String name) {
        super();
        this.idUser = user.getIdUser();
        this.idGame = game.getIDGame();
        this.name = name;
        this.typeGame = game.getTypeGame();
        this.date = GetTimeCurrent.getTimeCurrent();
        this.error = game.getError();
        this.empty = game.getEmpty();
        this.data = game.getListNodeGame();

        handleData = new HandleDataSql();
    }
    public UserGame(int idUserGame , int idUser, int idGame, String name, int typeGame, String date, int error, int empty, NodeGame[][] data) {
        super();
        this.idUserGame = idUserGame;
        this.idUser = idUser;
        this.idGame = idGame;
        this.name = name;
        this.typeGame = typeGame;
        this.date = date;
        this.error = error;
        this.empty = empty;
        this.data = data;

        handleData = new HandleDataSql();
    }

    // Get Game
    public Game getGame() {
        Game game = handleData.getGameById(idGame);
        game.setError(error);
        game.setEmpty(empty);
        game.setListNodeGame(data);
        return game;
    }
    // Get User
    public User getUser() {
        return handleData.getUserById(idUser);
    }
    // Getters and Setters
    public int getIdUserGame() {
        return idUserGame;
    }

    public void setIdUserGame(int idUserGame) {
        this.idUserGame = idUserGame;
    }

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

    public int getTypeGame() {
        return typeGame;
    }

    public void setTypeGame(int typeGame) {
        this.typeGame = typeGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public int getEmpty() {
        return empty;
    }

    public void setEmpty(int empty) {
        this.empty = empty;
    }

    public NodeGame[][] getData() {
        return data;
    }

    public void setData(NodeGame[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserGame{" +
                "idUserGame=" + idUserGame +
                ", idUser=" + idUser +
                ", idGame=" + idGame +
                ", date='" + date + '\'' +
                ", typeGame=" + typeGame +
                ", name='" + name + '\'' +
                ", error=" + error +
                ", empty=" + empty +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}

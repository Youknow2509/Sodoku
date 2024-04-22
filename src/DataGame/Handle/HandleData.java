package src.DataGame.Handle;

import src.Obj.Game;
import src.Obj.User;
import src.Obj.UserGame;

import java.util.List;

public interface HandleData {
    // Them Users
    void addUsers(String username);
    // Them du lieu game chinh
    void addGame(int typeGame, int level, int err, int empty, String data);
    // Them du lieu game nguoi dung
    void addGameUser(int gameId, int userId, String name, int type, int err, int empty, String data);
    // Xoa du lieu game chinh
    void deleteGame(int gameId);
    // Xoa du lieu game nguoi dung
    void deleteGameUser(int idUserGame);
    // Xoa nguoi dung
    void deleteUser(int userId);
    // Cap nhat du lieu game chinh
    void updateGame(int gameId, int typeGame, int level, int err, int empty, String data);
    // Cap nhat du lieu game nguoi dung
    void updateGameUser(int idUserGame, int gameId, int userId, String name, int typeGame, String Date, int err, int empty, String data);
    // Cap nhat nguoi dung
    void updateUser(int userId, String username);
    // Lay du lieu game chinh
    List<Game> getGame();
    // Lay du lieu game nguoi dung
    List<UserGame> getGameUser();
    // Lay nguoi dung
    List<User> getUser();
}

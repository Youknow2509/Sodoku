package src.DataGame.Handle;

import java.util.List;

public interface HandleDta {
    // Them Users
    void addUsers(String username);
    // Them du lieu game chinh
    void addGame(int typeGame, int level, int err, String data);
    // Them du lieu game nguoi dung
    void addGameUser(int gameId, int userId, int err, String data);
    // Xoa du lieu game chinh
    void deleteGame(int gameId);
    // Xoa du lieu game nguoi dung
    void deleteGameUser(int gameId, int userId);
    // Xoa nguoi dung
    void deleteUser(int userId);
    // Cap nhat du lieu game chinh
    void updateGame(int gameId, int typeGame, int level, int err, String data);
    // Cap nhat du lieu game nguoi dung
    void updateGameUser(int gameId, int userId, int typeGame, int err, String data);
    // Cap nhat nguoi dung
    void updateUser(int userId, String username);
    // Lay du lieu game chinh
    List<String> getGame();
    // Lay du lieu game nguoi dung
    List<String> getGameUser();
    // Lay nguoi dung
    List<String> getUser();
}

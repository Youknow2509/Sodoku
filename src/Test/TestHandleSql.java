package src.Test;

import src.DataGame.Handle.HandleDataSql;
import src.DataGame.Handle.HandleDta;
import src.Obj.Game;
import src.Obj.User;
import src.Obj.UserGame;

import java.util.List;

public class TestHandleSql {

    // Show list string
    private static void showListUser(List<User> list) {
        if (list.size() == 0) {
            System.out.println("Khong co du lieu trong bang User");
            return;
        }
        for (User s : list) {
            System.out.println(s);
        }
    }

    private static void showListGame(List<Game> list) {
        if (list.size() == 0) {
            System.out.println("Khong co du lieu trong bang Game");
            return;
        }
        for (Game s : list) {
            System.out.println(s);
        }
    }

    private static void showListGameUser(List<UserGame> list) {
        if (list.size() == 0) {
            System.out.println("Khong co du lieu trong bang UserGame");
            return;
        }
        for (UserGame s : list) {
            System.out.println(s);
        }
    }

    // Main
    public static void main(String [] arg) {
        HandleDta handleDta = new HandleDataSql();

        List<User> lUsers = handleDta.getUser();
        List<Game> lGame = handleDta.getGame();
        List<UserGame> lGameUser = handleDta.getGameUser();

        showListUser(lUsers);
        showListGame(lGame);
        showListGameUser(lGameUser);

        return;
    }
}

package src.Test;

import src.DataGame.Handle.HandleDataSql;
import src.DataGame.Handle.HandleData;
import src.Obj.Game;
import src.Obj.User;
import src.Obj.UserGame;
import src.Utils.GetTimeCurrent;

import java.util.Date;
import java.util.List;

public class TestHandleSql {

    // Show list string
    private static void showListUser(List<User> list) {
        if (list.size() == 0) {
            System.out.println("Khong co du lieu trong bang User");
            System.out.println();
            return;
        }
        for (User s : list) {
            System.out.println(s);
            System.out.println();
        }
    }

    private static void showListGame(List<Game> list) {
        if (list.size() == 0) {
            System.out.println("Khong co du lieu trong bang Game");
            System.out.println();
            return;
        }
        for (Game s : list) {
            System.out.println(s);
            System.out.println();
        }
    }

    private static void showListGameUser(List<UserGame> list) {
        if (list.size() == 0) {
            System.out.println("Khong co du lieu trong bang UserGame");
            System.out.println();
            return;
        }
        for (UserGame s : list) {
            System.out.println(s);
            System.out.println();
        }
    }

    // Main
    public static void main(String [] arg) {
        HandleData handleData = new HandleDataSql();

        List<User> lUsers = handleData.getUser();
        List<Game> lGame = handleData.getGame();
        List<UserGame> lGameUser = handleData.getGameUser();

        showListUser(lUsers);
        showListGame(lGame);
        showListGameUser(lGameUser);

        //handleData.updateGameUser(1, 3, 2, "abc", 9, GetTimeCurrent.getTimeCurrent(), 3, 10, "5 4 8 0 2 3 0 7 9 vVv 9 2 0 4 5 6 1 3 8 vVv 1 3 6 7 0 9 2 0 5 vVv 2 1 3 5 4 7 8 9 6 vVv 4 6 5 0 9 0 3 0 7 vVv 7 8 9 3 6 0 4 5 2 vVv 3 5 1 0 7 2 9 8 4 vVv 6 9 4 8 0 5 7 2 3 vVv 8 7 2 0 3 4 5 6 1 vVv ");

        return;
    }
}

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

//        showListUser(lUsers);
//        showListGame(lGame);
//        showListGameUser(lGameUser);

        System.out.println(handleData.getMaxID("Users"));
        System.out.println(handleData.getMaxID("Games"));
        System.out.println(handleData.getMaxID("UserGames"));

        return;
    }
}

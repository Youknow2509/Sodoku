package src.Test;

import src.DataGame.Handle.HandleDataSql;
import src.DataGame.Handle.HandleData;
import src.Obj.Game;
import src.Obj.User;
import src.Obj.UserGame;
import src.Utils.GetTimeCurrent;

import java.text.SimpleDateFormat;
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
    public static void main(String[] arg) {
        HandleData handleData = new HandleDataSql();

        List<User> lUsers = handleData.getUser();
        List<Game> lGame = handleData.getGame();
        List<UserGame> lGameUser = handleData.getGameUser();

//        showListUser(lUsers);
//        showListGame(lGame);
//        showListGameUser(lGameUser);

        //handleData.updateGameUser(11, 10, 1, "abc", 9, GetTimeCurrent.getTimeCurrent(), 4, 16, "11\t10\t1\tGame ok 16\t16\t2024-04-23 08:01:10.597\t4\t16\t10 2 13 5 1 3 4 6 7 8 9 11 12 14 0 16 vVv 1 4 12 3 2 5 7 8 6 14 15 16 9 10 11 13 vVv 14 8 15 6 9 10 11 16 1 2 12 13 3 4 5 7 vVv 7 16 11 9 12 13 14 15 3 4 5 10 1 2 6 8 vVv 2 1 3 4 5 6 8 7 9 10 11 12 13 15 0 14 vVv 5 6 7 8 3 1 2 4 13 15 16 14 10 9 12 11 vVv 9 10 14 11 13 0 16 12 2 1 3 4 5 7 8 6 vVv 12 0 16 15 10 11 9 14 5 6 0 8 2 1 3 4 vVv 3 5 1 0 4 7 6 9 8 11 10 15 14 16 13 12 vVv 4 7 6 10 8 2 12 1 14 16 13 3 11 5 9 15 vVv 11 12 8 14 15 16 3 13 4 0 1 9 7 6 2 10 vVv 13 15 9 16 11 14 5 10 0 7 2 6 0 8 1 3 vVv 0 3 2 1 7 4 10 0 15 12 8 5 16 13 14 9 vVv 8 9 4 7 6 0 1 3 16 13 14 2 15 11 10 0 vVv 15 14 10 12 16 8 13 5 11 9 4 0 6 3 7 2 vVv 16 0 5 13 14 9 15 2 0 3 6 7 8 12 4 1 vVv ");
        System.out.println(
                handleData.getUserGameById(3)
        );
        return;
    }

}

package src.Test;

import src.DataGame.Handle.HandleDataSql;
import src.DataGame.Handle.HandleDta;

import java.util.List;

public class TestHandleSql {

    // Show list string
    private static void showListString(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    // Main
    public static void main(String [] arg) {
        HandleDta handleDta = new HandleDataSql();

        List<String> lUsers = handleDta.getUser();
        List<String> lGame = handleDta.getGame();
        List<String> lGameUser = handleDta.getGameUser();

        showListString(lUsers);
        showListString(lGame);
        showListString(lGameUser);

        return;
    }
}

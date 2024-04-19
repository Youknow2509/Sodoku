package src.Test;

import src.DataSql.Handle.HandleDataSql;
import src.Model.Game;
import src.Utils.LevelToGame;
import src.Utils.ShowGame;
import src.Utils.StringToGame;

public class TLoadLvSql {
    public static void main(String[] args) {
        HandleDataSql handleDataSql = new HandleDataSql();

        LevelToGame levelToGame = new LevelToGame(handleDataSql.loadLevel(9, 1));

        StringToGame stringToGame = new StringToGame(levelToGame.chooseRandomLevel());

        Game game = new Game();

        ShowGame showGame = new ShowGame(stringToGame.readDataToGame());

        showGame.show();

    }
}

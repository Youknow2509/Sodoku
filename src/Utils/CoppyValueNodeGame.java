package src.Utils;

import src.Model.NodeGame;
import src.Obj.Game;

public class CoppyValueNodeGame {
    public static Game coppyGame(Game game) {
        NodeGame [][] listNodeGame = new NodeGame[game.getSize()][game.getSize()];
        for (int i = 0; i < game.getSize(); i++) {
            for (int j = 0; j < game.getSize(); j++) {
                listNodeGame[i][j] = new NodeGame(i, j, game.getListNodeGame()[i][j].getValue());
            }
        }

        Game gameNew = new Game(game.getIDGame(),game.getTypeGame(), game.getLevel(), game.getLuotsai(), game.getOtrong(), listNodeGame);
        return gameNew;
    }
}

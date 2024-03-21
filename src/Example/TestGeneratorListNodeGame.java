package src.Example;

import src.Model.Game;
import src.Model.GeneratorGame;
import src.View.ShowGame;

public class TestGeneratorListNodeGame {
    // Var
    private static final int size = 9;
    private static final int sizeBox = 3;
    private static final int otrong = 10;
    private static final int luotsai = 3;
    // Main run
    public static void main(String[] args) {
        GeneratorGame generatorGame = new GeneratorGame(size, sizeBox, otrong, luotsai);
        Game game = generatorGame.getGame();
        ShowGame showGame = new ShowGame(game);
        showGame.show();
        return;
    }
}

package src.View;

import src.Model.Game;

public class ShowGame {
    // Var
    private Game game = null;
    // Constructor
    public ShowGame(Game game) {
        super();
        this.game = game;
    }
    public void show() { // add to debug
        //System.out.println("   0 1 2   3 4 5   6 7 8");
        for (int i = 0; i < game.getSize(); i++) {
            if (i % game.getSizeBox() == 0){
                System.out.println("-------------------------"); // 24 dau -
            }
            System.out.print(i);
            for (int j = 0; j < game.getSize(); j++) {
                if (j % game.getSizeBox() == 0){
                    System.out.print("| ");
                }
                System.out.print((game.getListNodeGame())[i][j].getValue() + " ");
            }
            System.out.println();
        }
        System.out.println("Luot sai: " + game.getLuotsai());
        System.out.println("O trong: " + game.getOtrong());
        System.out.println();
    }
}

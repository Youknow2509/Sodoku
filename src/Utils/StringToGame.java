package src.Utils;

import src.Model.Game;
import src.Model.NodeGame;

public class StringToGame {
    // Var
    private String data;
    // Constructor
    public StringToGame() {
        super();
    }
    public StringToGame(String data) {
        super();
        this.data = data;
    }

    // Method

    // Read data to Game
    public Game readDataToGame() {
        Game game = new Game();
        String[] lData = this.data.split("#");
        // Ex: 1 9 1 164235789385679124297108350412356097536807241879412563620784935758000012903520078 12 3
        if (lData.length == 6) {
            try {
                game.setSize(Integer.parseInt(lData[1]));
                game.setSizeBox((int) Math.sqrt(game.getSize()));
                game.setOtrong(Integer.parseInt(lData[4]));
                game.setLuotsai(Integer.parseInt(lData[5]));
                game.setListNodeGame(stringToNodeGame(lData[3]));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return game;
    }

    // String to NodeGame []
    private NodeGame[][] stringToNodeGame(String data) {
        String[] lData = data.split(" ");
        int n = (int) Math.sqrt(lData.length);
        NodeGame [][] nodeGames = new NodeGame[n][n];
        // Ex: 164235789385679124297108350412356097536807241879412563620784935758000012903520078
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nodeGames[i][j] = new NodeGame(i, j, Integer.parseInt(lData[i * n + j]));
            }
        }

        return nodeGames;
    }

    // Getter and setter

}



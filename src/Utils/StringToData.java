package src.Utils;

import src.Model.NodeGame;

public class StringToData {
    public static NodeGame [][] StringToData(String data) {
        String [] dataRow = data.split("\n");
        int type = dataRow.length;
        NodeGame [][] nodeGame = new NodeGame[type][type];

        for (int i = 0; i < type; i++) {
            String [] dataCol = dataRow[i].split(" ");
            for (int j = 0; j < type; j++) {
                nodeGame[i][j] = new NodeGame(i, j, Integer.parseInt(dataCol[j]));
            }
        }

        return nodeGame;
    }
}

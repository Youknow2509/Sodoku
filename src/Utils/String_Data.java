package src.Utils;

import src.Model.NodeGame;

public class String_Data {
    public static NodeGame [][] StringToData(String data) {
        String [] dataRow = data.split(" vVv ");
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

    public static String DataToString(NodeGame [][] nodeGame) {
        String data = "";
        for (int i = 0; i < nodeGame.length; i++) {
            for (int j = 0; j < nodeGame[i].length; j++) {
                data += nodeGame[i][j].getValue() + " ";
            }
            data += "vVv ";
        }
        return data;
    }

    public static void main(String [] arg) {
        String data = "5 4 8 0 2 3 0 7 9 \n 9 2 0 4 5 6 1 3 8 \n 1 3 6 7 0 9 2 0 5 \n 2 1 3 5 4 7 8 9 6 \n 4 6 5 0 9 0 3 0 7 \n 7 8 9 3 6 0 4 5 2 \n 3 5 1 0 7 2 9 8 4 \n 6 9 4 8 0 5 7 2 3 \n 8 7 2 0 3 4 5 6 1 \n ";
        NodeGame [][] nodeGame = StringToData(data);
        System.out.println(nodeGame);
    }
}

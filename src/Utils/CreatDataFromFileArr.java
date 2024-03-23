package src.Utils;

import src.Model.Game;
import src.Model.NodeGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CreatDataFromFileArr {

    private static final int otrong = 12;
    private static final int luotsai = 3;
    private static int size = 0;
    private static int sizeBox = 0;
    private static NodeGame[][] arr = null;
    private static final String path = "";
    private static BufferedReader bufferedReader = null;
    private static FileReader fileReader = null;

    private static void readFileToNodeGame() {
        String line = "";
        try {
            int index = 0;
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            String [] arrStr = line.split(" ");
            size = arrStr.length;
            sizeBox = (int) Math.sqrt(size);
            initNodeGame();
            for (int i = 0; i < size; i++) {
                arr[index][i] = new NodeGame(0, i, Integer.parseInt(arrStr[i]));
            }
            index++;
            while ((line = bufferedReader.readLine()) != null) {
                arrStr = line.split(" ");
                for (int i = 0; i < size; i++) {
                    arr[index][i] = new NodeGame(index, i, Integer.parseInt(arrStr[i]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void initNodeGame() {
        NodeGame [][] arr = new NodeGame[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = new NodeGame(i, j, 0);
            }
        }
    }
    public static void main(String [] args) {
        readFileToNodeGame();

        Game game = new Game(arr, size, sizeBox, otrong, luotsai);
        // todo
    }
}

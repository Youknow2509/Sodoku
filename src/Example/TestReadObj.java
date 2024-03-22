package src.Example;

import src.Model.Game;
import src.View.ShowGame;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TestReadObj {
    public static void main(String[] args) {
        String path = "/Users/v/code/java/projects/sudoku/src/Data/UserTemp/v/test.txt";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ShowGame showGame = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            Game game = (Game) ois.readObject();
            showGame = new ShowGame(game);
            showGame.show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return;
    }
}

package src.Example;

import src.Model.Game;
import src.Model.GeneratorGame;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TestWriteObj {
    public static void main(String[] args) {
        String path = "/Users/v/code/java/projects/sudoku/src/Data/UserTemp/v/9_1.txt";
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            GeneratorGame generatorGame = new GeneratorGame(9, 3, 12, 3);
            oos.writeObject(generatorGame.getGame());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) oos.close();
                if (fos != null) fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return;
    }
}

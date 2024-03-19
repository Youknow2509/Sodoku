package src.Example;

import src.Model.Generator;
import src.Model.NodeGame;
import src.View.ShowArray2d;

public class GeneratorArr {
    private static void show(NodeGame[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Generator generator = new Generator(16);
        NodeGame[][] arr = generator.GeneratorGame();
        generator.removeDigits(30); // TODO Điền hết gía trị cho database
        show(arr);
        return;
    }
}

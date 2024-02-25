package src.Example;

import src.Model.Generator;
import src.View.ShowArray2d;

public class Test {

    public static void main(String[] args) {

        final Generator generator = new Generator();
        final ShowArray2d showArray2D = new ShowArray2d();

        int [][] arr = generator.GeneratorGame();

        showArray2D.show(arr);
    }
}

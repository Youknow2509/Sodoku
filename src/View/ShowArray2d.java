package src.View;

import src.Model.Generator;
import src.Model.NodeGame;

public class ShowArray2d {
    public void show(NodeGame[][] arr) { // add to debug
        //System.out.println("   0 1 2   3 4 5   6 7 8");
        for (int i = 0; i < Generator.getSize(); i++) {
            if (i % Generator.getSizeBox() == 0){
                System.out.println("-------------------------"); // 24 dau -
            }
            System.out.print(i);
            for (int j = 0; j < Generator.getSize(); j++) {
                if (j % Generator.getSizeBox() == 0){
                    System.out.print("| ");
                }
                System.out.print(arr[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }
}

package src.Example;

import src.Data.DataLoad;
import src.Model.NodeGame;

public class Test {
    private static void show(NodeGame [][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        DataLoad data = new DataLoad("src/Data/Game/g1/Ez/1.txt");
        show(data.getArr());
        return;
    }
}

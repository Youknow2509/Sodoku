package src.Utils;

import javafx.scene.control.Button;
import src.Controller.Gam9x9Controller;

import java.util.List;

public class HandleFillColorNode {

    private static String colorFill = "#f0f0f0";
    private static String colorFillAfter = "#BCE8EB";

    public static void handleFillColorNode(Button Click, int row, int col, List<List<Button>> lNode, int SIZE) {
        if (Gam9x9Controller.buttonNodeClickedAfter == null) {
            enableFillColorNode(Click, row, col, lNode, SIZE);
            Gam9x9Controller.buttonNodeClickedAfter = Click;
            System.out.println("-> CLicked == null, Clicked = " + Click);
        } else if (Gam9x9Controller.buttonNodeClickedAfter == Click) {
            disableFillColorNode(Click, row, col, lNode, SIZE);
            Gam9x9Controller.buttonNodeClickedAfter = null;
            System.out.println("-> CLicked == Click,  Clicked = " + null);
        } else {
            disableFillColorNode(Gam9x9Controller.buttonNodeClickedAfter, IdToLocation.getIdRow(Gam9x9Controller.buttonNodeClickedAfter.getId())
                    , IdToLocation.getIdCol(Gam9x9Controller.buttonNodeClickedAfter.getId()), lNode, SIZE);
            enableFillColorNode(Click, row, col, lNode, SIZE);
            Gam9x9Controller.buttonNodeClickedAfter = Click;
            System.out.println("-> CLicked != Click, Clicked = " + Click);
        }
    }

    private static void enableFillColorNode(Button Click, int row, int col, List<List<Button>> lNode, int SIZE) {
        fillBox(row, col, SIZE, lNode, colorFill);
        fillRow(row, col, SIZE, lNode, colorFill);
        fillCol(row, col, SIZE, lNode, colorFill);
    }

    private static void disableFillColorNode(Button Click, int row, int col, List<List<Button>> lNode, int SIZE) {
        fillBox(row, col, SIZE, lNode, colorFillAfter);
        fillRow(row, col, SIZE, lNode, colorFillAfter);
        fillCol(row, col, SIZE, lNode, colorFillAfter);
    }

    private static void fillBox(int row, int col, int SIZE, List<List<Button>> lNode, String color) {
        int sizeBox = (int) Math.sqrt(SIZE);
        int startRow = row - row % sizeBox;
        int startCol = col - col % sizeBox;
        for (int i = startRow; i < startRow + sizeBox; i++) {
            for (int j = startCol; j < startCol + sizeBox; j++) {
                lNode.get(i).get(j).setStyle("-fx-background-color: " + color);
            }
        }

    }

    private static void fillRow(int row, int col, int SIZE, List<List<Button>> lNode, String color) {
        for (int i = 0; i < SIZE; i++) {
            lNode.get(row).get(i).setStyle("-fx-background-color: " + color);
        }
    }

    private static void fillCol(int row, int col, int SIZE, List<List<Button>> lNode, String color) {
        for (int i = 0; i < SIZE; i++) {
            lNode.get(i).get(col).setStyle("-fx-background-color: " + color);
        }
    }
}

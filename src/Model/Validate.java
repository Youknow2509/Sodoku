package src.Model;

public class Validate {
    public boolean ValidateSafe(NodeGame [][] arr, NodeGame n) {
        return ValidateRow(arr, n.getY(), n.getValue()) &&
                ValidateCol(arr, n.getX(), n.getValue()) &&
                ValidateBox(arr, n.getY() - n.getY() % Game.getSizeBox(), n.getX() - n.getX() % Game.getSizeBox(), n.getValue());
    }
    // Ham kiem tra hang
    public static boolean ValidateRow(NodeGame [][] arr, int row, int val) {
        for (int j = 0; j < Game.getSize(); j++) {
            if (arr[row][j].getValue() == val) {
                return false;
            }
        }
        return true;
    }
    // Ham kiem tra cot
    public static boolean ValidateCol(NodeGame [][] arr, int col, int val) {
        for (int i = 0; i < Game.getSize(); i++) {
            if (arr[i][col].getValue() == val) {
                return false;
            }
        }
        return true;
    }
    // Ham kiem tra mot nhom
    public static boolean ValidateBox(NodeGame [][] arr, int rowStart, int colStart, int val) {
        for (int i = 0; i < Game.getSizeBox(); i++) {
            for (int j = 0; j < Game.getSizeBox(); j++) {
                if (arr[rowStart + i][colStart + j].getValue() == val) {
                    return false;
                }
            }
        }
        return true;
    }
}

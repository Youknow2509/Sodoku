package src.Model;

public class Validate {
    public boolean ValidateSafe(NodeGame [][] arr, NodeGame n) {
        return ValidateRow(arr, n.getY(), n.getValue()) &&
                ValidateCol(arr, n.getX(), n.getValue()) &&
                ValidateBox(arr, n.getY() - n.getY() % 3, n.getX() - n.getX() % 3, n.getValue());
    }
    // Ham kiem tra hang
    public static boolean ValidateRow(NodeGame [][] arr, int row, int val) {
        for (int j = 0; j < arr[row].length; j++) {
            if (arr[row][j].getValue() == val) {
                return false;
            }
        }
        return true;
    }
    // Ham kiem tra cot
    public static boolean ValidateCol(NodeGame [][] arr, int col, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][col].getValue() == val) {
                return false;
            }
        }
        return true;
    }
    // Ham kiem tra mot nhom
    public static boolean ValidateBox(NodeGame [][] arr, int rowStart, int colStart, int val) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[rowStart + i][colStart + j].getValue() == val) {
                    return false;
                }
            }
        }
        return true;
    }
}

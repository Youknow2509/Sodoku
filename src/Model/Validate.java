package src.Model;

public class Validate {
    public boolean ValidateSafe(int[][] arr, int row, int col, int val) {
        return ValidateRow(arr, row, val) &&
                ValidateCol(arr, col, val) &&
                ValidateBox(arr, row - row % 3, col - col % 3, val);
    }
    // Ham kiem tra hang
    public static boolean ValidateRow(int[][] arr, int row, int val) {
        for (int j = 0; j < 9; j++) {
            if (arr[row][j] == val) {
                return false;
            }
        }
        return true;
    }
    // Ham kiem tra cot
    public static boolean ValidateCol(int[][] arr, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == val) {
                return false;
            }
        }
        return true;
    }
    // Ham kiem tra mot nhom
    public static boolean ValidateBox(int[][] arr, int rowStart, int colStart, int val) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[rowStart + i][colStart + j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}

package week2.sodoku.assets;

/*
 * Ham kieu tra dieu kien bai toan
 */

public class check {
    public static boolean checkSafe(int[][] arr, int row, int col, int val) {
        return checkRow(arr, row, val) &&
                checkCol(arr, col, val) &&
                checkBox(arr, row - row % 3, col - col % 3, val); 
    }
    // Ham kiem tra hang
    public static boolean checkRow(int[][] arr, int row, int val) {
        for (int j = 0; j < 9; j++) {
            if (arr[row][j] == val) {
                return false;
            }
        }
        return true;
    }
    // Ham kiem tra cot
    public static boolean checkCol(int[][] arr, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == val) {
                return false;
            }
        }
        return true;
    }
    // Ham kiem tra mot nhom
    public static boolean checkBox(int[][] arr, int rowStart, int colStart, int val) {
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
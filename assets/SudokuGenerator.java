package week2.sodoku.assets;

import java.util.Arrays;
import java.util.Random;

/*
 * Ham random ra bai toan
 */

public class SudokuGenerator extends check {

    private static int countRm = 20;
    private static final int size = 9;
   
    private static void showArray(int[][] arr) { // add to debug
		System.out.println("   0 1 2   3 4 5   6 7 8");
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0){
				System.out.println("-------------------------"); // 24 dau -
			}
			System.out.print(i);
			for (int j = 0; j < 9; j++) {
				if (j % 3 == 0){
					System.out.print("| ");
				}
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
    // Khởi tạo mảng sudoku với số ô trống mặc định (20)
    public static int[][] generateSudoku() {
        int[][] arr = new int[size][size];
        fillValues(arr);
        return arr;
    } 
    // Khởi tạo mảng sudoku với n ô trống
    public static int[][] generateSudoku(int n) {
        countRm = n;
        int[][] arr = new int[size][size];
        fillValues(arr);
        return arr;
    }
    // Điền giá trị vào các ô trong mảng
    private static void fillValues(int[][] arr) {
        fillDiagonal(arr); // Điền giá trị vào các ô đường chéo
        fillRemaining(arr, 0, 3);
        removeDigits(arr, countRm); // Điều chỉnh số lượng chữ số còn lại
    }

    private static void fillDiagonal(int[][] arr) {
        for (int i = 0; i < 9; i = i + 3)
            fillBox(arr, i, i);
    }

    private static void fillBox(int[][] arr, int row, int col) {
        int num;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                do {
                    num = randomGenerator(9);
                } while (!checkBox(arr, row, col, num));

                arr[row + i][col + j] = num;
            }
    }

    private static int randomGenerator(int num) {
        Random random = new Random();
        return random.nextInt(num) + 1;
    } 
    // Xử dụng thuật toán quay lui để điền đầy đủ các giá trị vào ô còn trống
    private static boolean fillRemaining(int[][] arr, int i, int j) {
        if (i == 8 && j == 9)
            return true;
        if (j == 9) {
            i++;
            j = 0;
        }
        if (arr[i][j] != 0)
            return fillRemaining(arr, i, j + 1);

        for (int num = 1; num <= 9; num++) {
            if (checkSafe(arr, i, j, num)) {
                arr[i][j] = num;
                if (fillRemaining(arr, i, j + 1)) {
                    return true;
                }
                arr[i][j] = 0;
            }
        }
        return false;
    } 

    private static void removeDigits(int[][] arr, int count) {
        while (count != 0) {
            int i = randomGenerator(8);
            int j = randomGenerator(8);
            if (arr[i][j] != 0) {
                count--;
                arr[i][j] = 0;
            }
        }
    }
}

package src.Model;

import java.util.Random;

public class Generator {
    private final int size = 9;
    final Validate validate = new Validate();
    public int[][] GeneratorGame() {
        int[][] arr = new int[size][size];
        fillValues(arr);
        return arr;
    }
    // Điền giá trị vào các ô trong mảng
    private void fillValues(int[][] arr) {
        fillDiagonal(arr); // Điền giá trị vào các ô đường chéo
        fillRemaining(arr, 0, 3);
        // removeDigits(arr, countRm); // Điều chỉnh số lượng chữ số còn lại
    }

    private void fillDiagonal(int[][] arr) {
        for (int i = 0; i < 9; i = i + 3)
            fillBox(arr, i, i);
    }

    private void fillBox(int[][] arr, int row, int col) {
        int num;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                do {
                    num = randomGenerator(9);
                } while (!validate.ValidateBox(arr, row, col, num));

                arr[row + i][col + j] = num;
            }
    }

    private int randomGenerator(int num) {
        Random random = new Random();
        return random.nextInt(num) + 1;
    }
    // Xử dụng thuật toán quay lui để điền đầy đủ các giá trị vào ô còn trống
    private boolean fillRemaining(int[][] arr, int i, int j) {
        if (i == 8 && j == 9)
            return true;
        if (j == 9) {
            i++;
            j = 0;
        }
        if (arr[i][j] != 0)
            return fillRemaining(arr, i, j + 1);

        for (int num = 1; num <= 9; num++) {
            if (validate.ValidateSafe(arr, i, j, num)) {
                arr[i][j] = num;
                if (fillRemaining(arr, i, j + 1)) {
                    return true;
                }
                arr[i][j] = 0;
            }
        }
        return false;
    }
}

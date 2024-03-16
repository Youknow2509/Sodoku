package src.Model;

import java.util.Random;

public class Generator {
    private static int size = 9;
    private static int  sizeBox = 3;
    final Validate validate = new Validate();

    public Generator() {
        super();
    }
    public Generator(int size) {
        super();
        this.size = size;
        sizeBox = (int) Math.sqrt(size);
    }
    public static int getSizeBox() {
        return sizeBox;
    }
    public static void setSizeBox(int s) {
        sizeBox = s;
    }
    public static int getSize() {
        return size;
    }
    public static void setSize(int s) {
        size = s;
    }
    public NodeGame [][] GeneratorGame() {
        NodeGame [][] arr = new NodeGame [size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = new NodeGame(i, j, 0);
            }
        }
        fillValues(arr);
        return arr;
    }
    // Điền giá trị vào các ô trong mảng
    private void fillValues(NodeGame [][] arr) {
        fillDiagonal(arr); // Điền giá trị vào các ô đường chéo
        fillRemaining(arr, 0, sizeBox);
        // removeDigits(arr, countRm); // Điều chỉnh số lượng chữ số còn lại
    }

    private void fillDiagonal(NodeGame [][] arr) {
        for (int i = 0; i < size; i = i + sizeBox)
            fillBox(arr, i, i);
    }

    private void fillBox(NodeGame [][] arr, int row, int col) {
        int num;
        for (int i = 0; i < sizeBox; i++)
            for (int j = 0; j < sizeBox; j++) {
                do {
                    num = randomGenerator(size);
                } while (!validate.ValidateBox(arr, row, col, num));

                arr[row + i][col + j] = new NodeGame(row + i, col + j, num);

            }
    }

    private int randomGenerator(int num) {
        Random random = new Random();
        return random.nextInt(num) + 1;
    }
    // Xử dụng thuật toán quay lui để điền đầy đủ các giá trị vào ô còn trống
    private boolean fillRemaining(NodeGame [][] arr, int i, int j) {
        if (i == size - 1 && j == size)
            return true;
        if (j == size) {
            i++;
            j = 0;
        }
        if (arr[i][j].getValue() != 0)
            return fillRemaining(arr, i, j + 1);

        for (int num = 1; num <= size; num++) {
            NodeGame t = new NodeGame(i, j, num);
            if (validate.ValidateSafe(arr, t)) {
                arr[i][j] = t;
                if (fillRemaining(arr, i, j + 1)) {
                    return true;
                }
                arr[i][j] = new NodeGame (i, j, 0);
            }
        }
        return false;
    }
    // Coppy array 2d
    public NodeGame [][] coppyArray2d(NodeGame [][] arr) {
        NodeGame [][] arrCopy = new NodeGame [size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arrCopy[i][j] = new NodeGame(i, j, arr[i][j].getValue());
            }
        }
        return arrCopy;
    }
    // remove digits
    public void removeDigits(NodeGame [][] arr, int countRm) {
        int count = 0;
        while (count < countRm) {
            int cellId = randomGenerator(size*size) - 1;
            int i = cellId / size;
            int j = cellId % size;
            if (arr[i][j].getValue() != 0) {
                count++;
                arr[i][j].setValue(0);
            }
        }
    }
}

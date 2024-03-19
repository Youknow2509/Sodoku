package src.Data;

import src.Model.NodeGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataLoad {
    // Attributes
    private int size;
    private int sizeBox;
    private NodeGame[][] arr;
    private String path;
    private BufferedReader bufferedReader = null;
    private FileReader fileReader = null;
    private String line;
    // Constructor
    public DataLoad() {
    }
    public DataLoad(String path) {
        load(path);
    }
    // Khởi tạo mảng 2 chiều chưa gắn giá trị
    private void initNewNodeGame() {
        arr = new NodeGame[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = new NodeGame(i, j, 0);
            }
        }
    }
    public void load(String path) {
        int row = 0;
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);

            line = bufferedReader.readLine();
            String [] data = line.split(" ");
            size = data.length;
            sizeBox = (int) Math.sqrt(size);

            initNewNodeGame();

            for (int i = 0; i < size; i++) {
                arr[row][i].setValue(Integer.parseInt(data[i]));
                arr[row][i].setX(row);
                arr[row][i].setY(i);
            }
            row++;

            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(" ");
                for (int i = 0; i < size; i++) {
                    arr[row][i].setValue(Integer.parseInt(data[i]));
                    arr[row][i].setX(row);
                    arr[row][i].setY(i);
                }
                row++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    // Getters and Setters

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSizeBox() {
        return sizeBox;
    }

    public void setSizeBox(int sizeBox) {
        this.sizeBox = sizeBox;
    }

    public NodeGame[][] getArr() {
        return arr;
    }

    public void setArr(NodeGame[][] arr) {
        this.arr = arr;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}

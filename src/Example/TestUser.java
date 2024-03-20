package src.Example;

import javafx.util.Pair;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;

public class TestUser {
    private static Map<String, ArrayList<String>> DATA = new Hashtable<String, ArrayList<String>>();
    // Đọc dữ liệu
    private static void readData(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File [] lFiles = file.listFiles();
            for (File f : lFiles) { // Duyệt các Folder
                if (f.isDirectory()) {
                    String nameFolder = f.getName();
                    DATA.put(nameFolder, new ArrayList<>());
                    for (File f1 : f.listFiles()) { // Duyệt các file trong Folder
                        if (f1.isFile()) {
                            String nameFile = f1.getName();
                            DATA.get(nameFolder).add(nameFile);
                        }
                    }
                }
            }
        }
    }
    // In dữ liệu
    private static void printData() {
        for (Map.Entry<String, ArrayList<String>> entry : DATA.entrySet()) {
            System.out.println("Folder: " + entry.getKey());
            System.out.print("File: ");
            for (String s : entry.getValue()) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        String path = "src/Data/UserTemp";
        File file = new File(path);
        System.out.println();
        System.out.println("Information: ");

        readData(path);

        printData();

    }
}

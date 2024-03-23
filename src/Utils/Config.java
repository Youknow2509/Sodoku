package src.Utils;

import java.util.Scanner;

public class Config {
    // Variables
    private static Scanner scannerInput = null;

    public static Scanner getScannerInput() {
        if (scannerInput == null) {
            scannerInput = new Scanner(System.in);
        }
        return scannerInput;
    }
    public static void closeScannerInput() {
        if (scannerInput != null) {
            scannerInput.close();
        }
    }
}

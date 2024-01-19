package week2.sodoku;

import java.util.InputMismatchException;
import java.util.Scanner;

import week2.sodoku.assets.SudokuGenerator;
/*
 * Main game Sodoku
 */

public class Sodoku extends SudokuGenerator {

	private static void showArray(int[][] arr) {
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

	private static void cleanScreen() {
		// Kiem tra he dieu hanh cua nguoi xu dung
		String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.out.print("\f");
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            System.out.print("\033[H\033[2J");
        } 
	}

	private static boolean checkLocation(int[][] arr, int x, int y) {
		if (x >= 0 && x <= 8 && y >= 0 && y <= 8 && arr[x][y] == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

			int otrong;
			boolean game = true; 
			int c = 3; 
			int x, y, value;

			cleanScreen();
			System.out.println("Game Sodoku\nNhap so luong o trong thich hop !\n");
			Scanner input = new Scanner(System.in);
			
			do {
				System.out.print("Nhap tu 1 den 33: ");
				otrong = input.nextInt();	
			} while (otrong < 0 || otrong > 33);

			int[][] arr = generateSudoku(otrong);

			while (game && c > 0 && otrong > 0) {

				cleanScreen();
				showArray(arr);

				System.out.println("So lan sai con lai: " + c + "\nSo o trong con lai: " + otrong);

				System.out.print("Nhap toa do x, y: ");
				x = input.nextInt();
				y = input.nextInt();

				if (checkLocation(arr, x, y)) {
					System.out.print("Nhap gia tri: ");
					value = input.nextInt();

					if (checkSafe(arr, x, y, value)) {
						arr[x][y] = value;
						otrong--;
					} else {
						c--;
					}
				}
				if (c == 0) {
					System.out.println("Game Over!");
					game = false;
					System.exit(0);
				}
			}
			System.out.println("Win!");	
			input.close(); // Dong scanner tranh tinh trang do di vung nho
	}

}

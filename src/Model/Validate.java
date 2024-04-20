package src.Model;

import src.Obj.Game;

public class Validate {
    // Var
    private Game game = null;
    // Constructor
    public Validate() {
        super();
    }
    public Validate(Game g) {
        game = g;
    }
    // Ham kiem tra xem gia tri co hop le khong
    public boolean ValidateSafe(NodeGame n) {
        int x = n.getX();
        int y = n.getY();
        int val = n.getValue();
        return ValidateRow(y, val) &&
                ValidateCol(x, val) &&
                ValidateBox(y - y % game.getSizeBox(), x - x % game.getSizeBox(), val);
    }
    // Ham kiem tra hang
    public boolean ValidateRow(int row, int val) {
        for (int j = 0; j < game.getSize(); j++) {
            if ((game.getListNodeGame())[row][j].getValue() == val) {
                return false;
            }
        }
        return true;
    }
    // Ham kiem tra cot
    public boolean ValidateCol(int col, int val) {
        for (int i = 0; i < game.getSize(); i++) {
            if ((game.getListNodeGame())[i][col].getValue() == val) {
                return false;
            }
        }
        return true;
    }
    // Ham kiem tra mot nhom
    public boolean ValidateBox(int rowStart, int colStart, int val) {
        for (int i = 0; i < game.getSizeBox(); i++) {
            for (int j = 0; j < game.getSizeBox(); j++) {
                if ((game.getListNodeGame())[rowStart + i][colStart + j].getValue() == val) {
                    return false;
                }
            }
        }
        return true;
    }
}

package src.View;

import src.Model.Game;

public class ShowGame {
    // Var
    private Game game = null;
    String line = "";
    String indexX = "";
    // Constructor
    public ShowGame() {
        super();
    }
    public ShowGame(Game game) {
        super();
        this.game = game;
        initIndexX();
        initLine();
    }
    // Khởi tạo indexX
    private void initIndexX() {
        indexX = " | ";
        for (int i = 0; i < game.getSize(); i++) {
            if (i % game.getSizeBox() == 0 && i != 0){
                indexX += "| ";
            }
            if (i < 10) { // NOTE: Định dạng chỉ phù hợp cho size < 100
                indexX += " " + i + " ";
            } else {
                indexX += i + " ";
            }
        }
        indexX += " |";
    }
    // Khởi tạo line
    private void initLine() {
        int s = game.getSize()*3 + (game.getSizeBox() + 1)*2 + 1;
        for (int i = 0; i < s; i++) {
            line += "-";
        }
    }
    // Hàm hiểm thị game
    public void show() {
        // In dòng đầu để chọn vị trí X
        System.out.println(indexX);
        // In các dòng giá trị và format chúng
        for (int i = 0; i < game.getSize(); i++) {
            if (i % game.getSizeBox() == 0){
                System.out.println(line);
            }
            System.out.print(i);
            for (int j = 0; j < game.getSize(); j++) {
                if (j % game.getSizeBox() == 0){
                    System.out.print("| ");
                }
                System.out.format("%2d ", game.getListNodeGame()[i][j].getValue());
                if (j == game.getSize() - 1){
                    System.out.print(" |");
                }
            }
            System.out.println();
        }
        System.out.println(line);
        System.out.println("Luot sai: " + game.getLuotsai());
        System.out.println("O trong: " + game.getOtrong());
        System.out.println();
    }
    // Get set
    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }
    public String getLine() {
        return line;
    }
    public void setLine(String line) {
        this.line = line;
    }
    public String getIndexX() {
        return indexX;
    }
    public void setIndexX(String indexX) {
        this.indexX = indexX;
    }
}

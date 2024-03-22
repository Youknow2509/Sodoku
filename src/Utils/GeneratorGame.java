package src.Utils;

import src.Model.Game;
import src.Model.NodeGame;
import src.Model.Validate;

import java.util.Random;

public class GeneratorGame {
    // Var
    private Game game = null;
    private NodeGame[][] listNodeGame = null;
    private Validate validate = null;
    // Constructor
    public GeneratorGame() {
        super();
    }
    public GeneratorGame(int size, int sizeBox, int otrong, int luotsai) {
        initListNodeGame(size);
        game = new Game(listNodeGame, size, sizeBox, otrong, luotsai);
        validate = new Validate(game);
        GeneratorGame();
    }
    // Khởi tạo mảng 2 chiều NodeGame
    private void initListNodeGame(int size) {
        listNodeGame = new NodeGame[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                listNodeGame[i][j] = new NodeGame(i, j, 0);
            }
        }
    }
    // Random khởi tạo mảng 2 chiều NodeGame
    public void GeneratorGame() {
        fillValues();
        removeDigits(game.getOtrong());
    }
    // Điền giá trị vào các ô trong mảng
    private void fillValues() {
        fillDiagonal(); // Điền giá trị vào các ô đường chéo
        fillRemaining(0, game.getSizeBox());
    }
    // Điền giá trị vào box đường chéo
    private void fillDiagonal() {
        for (int i = 0; i < game.getSizeBox(); i = i + game.getSizeBox()) {
            fillBox(i, i);
        }
    }
    // Điền giá trị vào box
    private void fillBox(int row, int col) {
        int num;
        for (int i = 0; i < game.getSizeBox(); i++)
            for (int j = 0; j < game.getSizeBox(); j++) {
                do {
                    num = randomGenerator(game.getSize());
                } while (!validate.ValidateBox(row - row%game.getSizeBox(), col - col%game.getSizeBox(), num));
                (game.getListNodeGame())[row + i][col + j] = new NodeGame(row + i, col + j, num);
            }
    }
    // Random giá trị
    private int randomGenerator(int num) {
        Random random = new Random();
        return random.nextInt(num) + 1;
    }
    // Xử dụng thuật toán quay lui để điền đầy đủ các giá trị vào ô còn trống
    private boolean fillRemaining(int i, int j) {
        if (i == game.getSize() - 1 && j == game.getSize())
            return true;
        if (j == game.getSize()) {
            i++;
            j = 0;
        }
        if ((game.getListNodeGame())[i][j].getValue() != 0) {
            return fillRemaining(i, j + 1);
        }
        for (int num = 1; num <= game.getSize(); num++) {
            NodeGame t = new NodeGame(i, j, num);
            if (validate.ValidateSafe(t)) {
                (game.getListNodeGame())[i][j] = t;
                if (fillRemaining(i, j + 1)) {
                    return true;
                }
                (game.getListNodeGame())[i][j] = new NodeGame (i, j, 0);
            }
        }
        return false;
    }
    // Coppy listNodeGameay 2d
    public NodeGame [][] coppylistNodeGameay2d() {
        NodeGame [][] listNodeGameCopy = new NodeGame [game.getSize()][game.getSize()];
        for (int i = 0; i < game.getSize(); i++) {
            for (int j = 0; j < game.getSize(); j++) {
                listNodeGameCopy[i][j] = new NodeGame(i, j, listNodeGame[i][j].getValue());
            }
        }
        return listNodeGameCopy;
    }
    // remove digits
    public void removeDigits(int countRm) {
        int count = 0;
        while (count < countRm) {
            int cellId = randomGenerator(game.getSize()*game.getSize()) - 1;
            int i = cellId / game.getSize();
            int j = cellId % game.getSize();
            if ((game.getListNodeGame())[i][j].getValue() != 0) {
                count++;
                (game.getListNodeGame())[i][j].setValue(0);
            }
        }
    }
    // Getters and Setters
    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }
}

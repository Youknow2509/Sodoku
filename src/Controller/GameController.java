package src.Controller;

import src.Model.Game;
import src.Model.NodeGame;
import src.Model.Validate;
import src.Utils.HandleData;
import src.Utils.InputException;
import src.View.MainGame;
import src.Utils.Config;
public class GameController {
    // Variables
    private MainGame mainGame = null; // View
    private Validate validate = null;
    private String path = "src/Data/User/";
    //
    private Game game = null;
    private boolean loop = true;
    // Var input for game
    private String userName = null;
    private String typeGame = null;
    private String fileName = null;
    private String row = null;
    private String col = null;
    private String value = null;
    private String choose = null;
    private int r, c, v, ch;
    // Constructor
    public GameController(){super();}
    public GameController(Game game, String userName){
        super();
        this.game = game;
        this.userName = userName;
        this.typeGame = createTypeGame(game.getSize());

        mainGame = new MainGame(game);
        validate = new Validate(game);
    }
    // Application functions
    public void Application(){
        System.out.println();
        while (loop) {
            mainGame.showGame();
            // Nhap vi tri hang cot
            nhapHang();
            nhapCot();
            // Kiểm tra đã chọn đúng ô chưa, nếu chưa bắt nhập lại
            if ((game.getListNodeGame())[r][c].getValue() == 0) {
                nhapGiatri();
                // Kiểm tra giá trị nhập vào có hợp lệ không:
                // - Đúng: Thay đổi giá trị, giảm số ô trống.
                // - Sai:  Giảm số lượt còn lại.
                NodeGame nodeTemp = new NodeGame(r, c, v);
                if (validate.ValidateSafe(nodeTemp)) {
                    (game.getListNodeGame())[r][c].setValue(v);
                    game.giamOtrong();
                } else {
                    mainGame.inputValueError();
                    game.giamLuotsai();
                }
            } else {
                mainGame.inputPositionError();
            }
            checkLoop();
        }
    }
    // Menu
    private void menu(){

        mainGame.showMenu();
        choose = (Config.getScannerInput()).nextLine();
        try {
            ch = Integer.parseInt(choose);
            if (ch < 1 || ch > 4) {
                throw new InputException("Vui lòng chọn giá trị từ 1 đến 4.");
            }
        } catch (InputException e) {
            System.out.println(e.getMessage());
            menu();
        } catch (NumberFormatException e) {
            mainGame.inputNumberFormatError();
            menu();
        }
        switch (ch){
            case 1:
                mainGame.nameFileSave();
                fileName = (Config.getScannerInput()).nextLine();
                HandleData.createFileData(userName, fileName);
                HandleData.writeDataToFile(path + "/" + userName + "/" + fileName + ".txt", game);
                Application();
                break;
            case 2:
                Application();
                break;
            case 4:
                mainGame.goodbye(userName);
                System.exit(0);
                break;
            case 3:
                backToUser();
                break;
            default:
                System.out.println("Vui lòng chọn giá trị từ 1 đến 4.");
                menu();
                break;
        }
    }

    // Help functions
    // Back to user
    private void backToUser(){
        UserController userController = new UserController();
        userController.Application();
    }
    // Kiểm tra game đã kết thúc chưa
    private void checkLoop(){
        if (game.getOtrong() == 0) {
            loop = false;
            mainGame.gameWin();
            backToUser();
        }
        if (game.getLuotsai() == 0) {
            loop = false;
            mainGame.gameOver();
            backToUser();
        }
    }
    private String createTypeGame(int type){
        String t = String.valueOf(type);
        return t + "x" + t;
    }
    private void nhapHang() {
        mainGame.inputRow();
        row = (Config.getScannerInput()).nextLine();
        if (row.equals("menu")) {
            menu();
        } else {
            try {
                r = Integer.parseInt(row);
                if (r < 0 || r >= game.getSize()) {
                    throw new InputException("Vui lòng nhập số nguyên có gía trị từ 0 đến " + (game.getSize() - 1));
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
                nhapHang();
            } catch (NumberFormatException e) {
                mainGame.inputNumberFormatError();
                nhapHang();
            }
        }
    }
    private void nhapCot() {
        mainGame.inputCol();
        col = (Config.getScannerInput()).nextLine();
        if (col.equals("menu")) {
            menu();
        } else {
            try {
                c = Integer.parseInt(col);
                if (c < 0 || c >= game.getSize()) {
                    throw new InputException("Vui lòng nhập số nguyên có gía trị từ 0 đến " + (game.getSize() - 1));
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
                nhapCot();
            } catch (NumberFormatException e) {
                mainGame.inputNumberFormatError();
                nhapCot();
            }
        }
    }
    private void nhapGiatri() {
        mainGame.inputValue();
        value = (Config.getScannerInput()).nextLine();
        if (value.equals("menu")) {
            menu();
        } else {
            try {
                v = Integer.parseInt(value);
                if (v < 1 || v > game.getSize()) {
                    throw new InputException("Vui lòng nhập số nguyên có gía trị từ 1 đến " + game.getSize());
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
                nhapGiatri();
            } catch (NumberFormatException e) {
                mainGame.inputNumberFormatError();
                nhapGiatri();
            }
        }
    }
    // Getters and Setters

    public MainGame getMainGame() {
        return mainGame;
    }

    public void setMainGame(MainGame mainGame) {
        this.mainGame = mainGame;
    }
    public Validate getValidate() {
        return validate;
    }

    public void setValidate(Validate validate) {
        this.validate = validate;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTypeGame() {
        return typeGame;
    }

    public void setTypeGame(String typeGame) {
        this.typeGame = typeGame;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getCh() {
        return ch;
    }

    public void setCh(int ch) {
        this.ch = ch;
    }
}

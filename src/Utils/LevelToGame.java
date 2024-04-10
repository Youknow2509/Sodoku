package src.Utils;

public class LevelToGame {
    // Var
    private String data;

    // Constructor
    public LevelToGame() {
        super();
    }
    public LevelToGame(String data) {
        super();
        this.data = data;
    }

    // Method

    // Chooses a random level
    public String chooseRandomLevel() {
        String[] lData = this.data.split("!");
        int n = lData.length;
        int i = (int) (Math.random() * n);
        return lData[i];
    }

    // Getter and setter
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

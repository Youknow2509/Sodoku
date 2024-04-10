package src.Model;

import java.io.Serializable;

public class NodeGame implements Serializable {
    //
    private static final long serialVersionUID = 1L;
    // Attributes
    private int x = 0;
    private int y = 0;
    private int value = 0;
    // Constructor
    public NodeGame() {
        super();
    }
    public NodeGame(int y, int x, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
    // Getters and Setters
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    // To String
    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", value=" + value +
                '}';
    }
}

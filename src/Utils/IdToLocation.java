package src.Utils;

public class IdToLocation {
    public static int getIdRow(String id) {
        return id.split("_")[1].charAt(0) - '0';
    }
    public static int getIdCol(String id) {
        return id.split("_")[1].charAt(1) - '0';
    }
}

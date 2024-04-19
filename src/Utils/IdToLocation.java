package src.Utils;

public class IdToLocation {
    public static int getIdRow(String id) {
        return Integer.parseInt(id.split("_")[1]);
    }
    public static int getIdCol(String id) {
        return Integer.parseInt(id.split("_")[2]);
    }
}

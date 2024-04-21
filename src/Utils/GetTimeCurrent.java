package src.Utils;

public class GetTimeCurrent {
    public static String getTimeCurrent() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }
}

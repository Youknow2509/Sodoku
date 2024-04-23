package src.Utils;

public class GetTimeCurrent {
    public static String getTimeCurrent() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
    }
}

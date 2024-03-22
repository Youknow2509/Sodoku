package src.View;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class User { // TODO loadding, viết xong Controller có hiển thị rồi sẽ chuyển phần hiển thị sang
    // Variables
    private Map<String, ArrayList<String>> DATA = new Hashtable<String, ArrayList<String>>();
    
    // Constructor
    public User() {
        super();
    }
    public User(Map<String, ArrayList<String>> DATA) {
        super();
        this.DATA = DATA;
    }
    // In dữ liệu của Folder
    private void printFolderData() {
        int index = 1;
        System.out.println("Data hava: " +countUser() + " users.");
        for (Map.Entry<String, ArrayList<String>> entry : DATA.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            System.out.print("User " + index + " " + key + ", " + countDataofUser(entry.getKey()) + " file: ");
            index++;
            for (String s : value) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
    }

    // Help functoin :
    // Help Print Folder Data - Trả về số lượng User
    private int countUser() {
        return DATA.size();
    }
    // Help Print Folder Data - Trả về số lượng dữ liệu của từng User
    private int countDataofUser(String user) {
        return DATA.get(user).size();
    }

}

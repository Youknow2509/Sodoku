package src.View;

import src.Utils.HandleData;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class User {
    // Constructor
    public User() {
        super();
    }

    // In dữ liệu của Folder
    private void printFolderData() {
        int index = 1;
        System.out.println("Data hava: " + countUser() + " users.");
        for (Map.Entry<String, ArrayList<String>> entry : (HandleData.getDATA()).entrySet()) {
            String nameUser = entry.getKey();
            ArrayList<String> listDataUser = entry.getValue();
            System.out.print("User " + index + " name: " + nameUser + ", " + countDataofUser(entry.getKey()) + " file: ");
            index++;
            for (String d : listDataUser) {
                System.out.print(d + ", ");
            }
            System.out.println();
        }
    }
    // View Application chooses
    public void viewApplication() {
        System.out.println("1. Chơi tiếp dữ liệu cũ.");
        System.out.println("2. Chơi mới.");
        System.out.println("3. Hiển thị dữ liệu người dùng.");
        System.out.println("4. Exit");
        System.out.print("Choose: ");
    }
    // Option data user
    public void optionDataUser() {
        System.out.println("1. Xoá tất cả dữ liệu người dùng.");
        System.out.println("2. Xoá dữ liệu người dùng.");
        System.out.println("3. Back to main home");
        System.out.print("Choose: ");
    }
    // Yêu cầu tạo người dùng
    public void requestCreateUser() {
        System.out.println("Chưa có dữ liệu người dùng nào hãy tạo mới !!!");
    }
    // Yêu cầu nhập tên người dùng:
    public void requestInputNameUser() {
        System.out.print("Nhập tên người dùng: ");
    }
    // Yêu cầu nhập tên file:
    public void requestInputNameFile() {
        System.out.print("Nhập tên file dữ liệu: ");
    }
    // Thông báo người dùng không có dữ liệu
    public void notifyUserNoData() {
        System.out.println("User này chưa có dữ liệu, hoặc không tồn tại !!!");
    }
    // Thông báo file không tồn tại
    public void notifyFileNoExist() {
        System.out.println("File này không tồn tại !!!");
    }

    // Help functoin :
    // Help Print Folder Data - Trả về số lượng User
    private int countUser() {
        return (HandleData.getDATA()).size();
    }
    // Help Print Folder Data - Trả về số lượng dữ liệu của từng User
    private int countDataofUser(String user) {
        return (HandleData.getDATA()).get(user).size();
    }

}

package src.Data.User;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<U> users = new ArrayList<U>();
    // Constructor
    public User() {
    }
    // Add user
    public void addUser(U user) {
        if (users.contains(user)) {
            System.out.println("Tai khoan da ton tai!");
            return;
        } else {
            users.add(user);
        }
    }
    // Remove user
    public void removeUser(U user) {
        if (users.contains(user)) {
            users.remove(user);
        } else {
            System.out.println("Tai khoan khong ton tai!");
        }
    }
    // get set
    public List<U> getUsers() {
        return users;
    }
    public void setUsers(List<U> users) {
        this.users = users;
    }
}

class U {

    private String username;
    private List<String> assests = new ArrayList<java.lang.String>();
    private int sizeAssests = 0;
    // Constructor
    public U(String username, List<String> assests) {
        this.username = username;
        this.assests = assests;
    }
    public U() {
    }
    // Add assests
    public void addAssests(String assest) {
        if (assests.contains(assest)) {
            System.out.println("Tai nguyen da ton tai!");
            return;
        } else {
            assests.add(assest);
            sizeAssests++;
        }
    }
    // Remove assests
    public void removeAssests(String assest) {
        if (assests.contains(assest)) {
            assests.remove(assest);
            sizeAssests--;
        } else {
            System.out.println("Tai nguyen khong ton tai!");
        }
    }
    // get set
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public List<String> getAssests() {
        return assests;
    }
    public void setAssests(List<String> assests) {
        this.assests = assests;
    }
    public int getSizeAssests() {
        return sizeAssests;
    }
    public void setSizeAssests(int sizeAssests) {
        this.sizeAssests = sizeAssests;
    }
}

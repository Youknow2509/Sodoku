package src.Obj;

public class User {
    // Var
    private String userName;
    private int idUser;
    // Constructor
    public User() {
        super();
    }
    public User(int idUser, String userName) {
        super();
        this.userName = userName;
        this.idUser = idUser;
    }

    // Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", idUser=" + idUser +
                '}';
    }
}

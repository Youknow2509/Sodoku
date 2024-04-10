package src.DataSql.Handle;

import src.Model.Game;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandleDataSql {
    // Var
    private String url = "jdbc:sqlserver://localhost:1435;encrypt=true;trustServerCertificate=true" +
            ";username=sa" +
            ";password=P@ss12345;";
    private String myDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private Map<String, List<String>> level = new HashMap<String, List<String>>();
    // Constructor
    public HandleDataSql() {
    }

    // Method

    // Get Connection
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(myDriver);
            conn = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            return conn;
        }
    }
    // Load level
    public String loadLevel(int type, int l) {

        String res = "";

        Connection conn = null;
        Statement st = null;
        try {
            Class.forName(myDriver);
            conn = getConnection();
            String query = "USE Sudoku SELECT * FROM Level WHERE TypeGame = " + type + " AND Difficulty = " + l + ";";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
               int LevelID = rs.getInt("LevelID");
               int TypeGame = rs.getInt("TypeGame");
               int Difficulty = rs.getInt("Difficulty");
               String BoardData = rs.getString("BoardData");
               int EmptyCells = rs.getInt("EmptyCells");
               int MistakesAllowed = rs.getInt("MistakesAllowed");
               res += LevelID + "#" + TypeGame + "#" + Difficulty + "#" + BoardData + "#" + EmptyCells + "#" + MistakesAllowed + "!";
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    // Write data user to database
    public void writeData(String user, Game game) {

    }

    // Delete data user in database
    public void deleteData(String id) {

    }

    // Getter and setter

}

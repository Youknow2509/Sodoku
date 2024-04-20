package src.DataGame.Handle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HandleDataSql implements HandleDta {
    // Var final sql
    private final String url = "jdbc:sqlserver://localhost:1435;encrypt=true;trustServerCertificate=true" +
            ";username=sa" +
            ";password=P@ss12345;";
    private final String myDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //

    // Get Connection
    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(myDriver);
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Method
    @Override
    public void addUsers(String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            String query = "Use Sudoku  INSERT INTO Users (UserName) VALUES (?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, username);

            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addGame(int typeGame, int level, int err, String data) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            String query = "USE Sudoku INSERT INTO Games (TypeGame, Level, Error, Data) " +
                    "VALUES (?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, typeGame);
            preparedStatement.setInt(2, level);
            preparedStatement.setInt(3, err);
            preparedStatement.setString(4, data);

            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addGameUser(int gameId, int userId, int err, String data) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            String query = "USE Sudoku INSERT INTO UserGames (GameID, UserID, Error, Data)  " +
                    "VALUES (?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, gameId);
            preparedStatement.setInt(2, userId);
            preparedStatement.setInt(3, err);
            preparedStatement.setString(4, data);

            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteGame(int gameId) {

    }

    @Override
    public void deleteGameUser(int gameId, int userId) {

    }

    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public void updateGame(int gameId, int typeGame, int level, int err, String data) {

    }

    @Override
    public void updateGameUser(int gameId, int userId, int typeGame, int err, String data) {

    }

    @Override
    public void updateUser(int userId, String username) {

    }

    @Override
    public List<String> getGame() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<String> res = new ArrayList<String>();
        String gameTemp = "";
        try {
            Class.forName(myDriver);
            connection = getConnection();
            // Query
            String query = "Use Sudoku SELECT * FROM Games;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int GameID = resultSet.getInt("GameID");
                int TypeGame = resultSet.getInt("TypeGame");
                int Level = resultSet.getInt("Level");
                int Error = resultSet.getInt("Error");
                String Data = resultSet.getString("Data");

                gameTemp = GameID + "||" + TypeGame + "||" + Level + "||" + Error + "||" + Data;

                res.add(gameTemp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public List<String> getGameUser() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<String> res = new ArrayList<String>();
        String gameUserTemp = "";
        try {
            Class.forName(myDriver);
            connection = getConnection();
            // Query
            String query = "Use Sudoku SELECT * FROM UserGames;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int GameID = resultSet.getInt("GameID");
                int UserID = resultSet.getInt("UserID");
                String Date = resultSet.getString("Data");
                int Error = resultSet.getInt("Error");
                String Data = resultSet.getString("Data");

                gameUserTemp = GameID + "||" + UserID + "||" + Date + "||" + Error + "||" + Data;

                res.add(gameUserTemp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close the resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public List<String> getUser() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<String> res = new ArrayList<String>();
        String userTemp = "";
        try {
            Class.forName(myDriver);
            connection = getConnection();
            // Query
            String query = "Use Sudoku SELECT * FROM Users;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int UserID = resultSet.getInt("UserID");
                String UserName = resultSet.getString("UserName");

                userTemp = UserID + "||" + UserName;

                res.add(userTemp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close the resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}

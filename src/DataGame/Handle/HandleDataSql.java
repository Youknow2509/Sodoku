package src.DataGame.Handle;

import src.Obj.Game;
import src.Obj.User;
import src.Obj.UserGame;
import src.Utils.String_Data;

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
    public void addGame(int typeGame, int level, int err, int empty, String data) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            String query = "USE Sudoku INSERT INTO Games (TypeGame, Level, Error, Empty, Data) " +
                    "VALUES (?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, typeGame);
            preparedStatement.setInt(2, level);
            preparedStatement.setInt(3, err);
            preparedStatement.setInt(4, empty);
            preparedStatement.setString(5, data);

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
    public void addGameUser(int gameId, int userId, String name, int err, int empty, String data) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            String query = "USE Sudoku INSERT INTO UserGames (GameID, UserID, Name, Error, Empty, Data)  " +
                    "VALUES (?, ?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, gameId);
            preparedStatement.setInt(2, userId);
            preparedStatement.setString(3, name);
            preparedStatement.setInt(4, err);
            preparedStatement.setInt(5, empty);
            preparedStatement.setString(6, data);

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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();

            String queryUserGames = "USE Sudoku DELETE FROM UserGames WHERE GameID = ?;";
            preparedStatement = connection.prepareStatement(queryUserGames);
            preparedStatement.setInt(1, gameId);
            preparedStatement.executeUpdate();

            String queryGames = "USE Sudoku DELETE FROM Games WHERE GameID = ?;";
            preparedStatement = connection.prepareStatement(queryGames);
            preparedStatement.setInt(1, gameId);
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
    public void deleteGameUser(int gameId, int userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            String query = "USE Sudoku DELETE FROM UserGames \n" +
                    "WHERE GameID = ? AND UserID = ?;";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, gameId);
            preparedStatement.setInt(2, userId);

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
    public void deleteUser(int userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            String query = "USE Sudoku DELETE FROM Users \n" +
                    "WHERE UserID = ?;";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, userId);

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
    public void updateGame(int gameId, int typeGame, int level, int err, int empty, String data) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            String query = "USE Sudoku UPDATE Games \n" +
                    "SET TypeGame = ?, Level = ?, Error = ?, Empty = ?, Data = ? \n" +
                    "WHERE GameID = ?;";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, typeGame);
            preparedStatement.setInt(2, level);
            preparedStatement.setInt(3, err);
            preparedStatement.setInt(4, empty);
            preparedStatement.setString(5, data);
            preparedStatement.setInt(6, gameId);

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
    public void updateGameUser(int gameId, int userId, String name, int err, int empty, String data) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            String query = "USE Sudoku UPDATE UserGames \n" +
                    "SET Name = ?, Error = ? , Empty = ?, Data = ? \n" +
                    "WHERE GameID = ? AND UserID = ?;";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, err);
            preparedStatement.setInt(3, empty);
            preparedStatement.setString(4, data);
            preparedStatement.setInt(5, gameId);
            preparedStatement.setInt(6, userId);

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
    public void updateUser(int userId, String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            String query = "USE Sudoku UPDATE Users \n" +
                    "SET UserName = ? \n" +
                    "WHERE UserID = ?;";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, userId);

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
    public List<Game> getGame() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Game> res = new ArrayList<Game>();
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
                int Empty = resultSet.getInt("Empty");
                String Data = resultSet.getString("Data");

                Game game = new Game(GameID, TypeGame, Level, Error, Empty, String_Data.StringToData(Data));

                res.add(game);
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
    public List<UserGame> getGameUser() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<UserGame> res = new ArrayList<UserGame>();

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
                String Name = resultSet.getString("Name");
                String Date = resultSet.getDate("Date").toString();
                int Error = resultSet.getInt("Error");
                String Data = resultSet.getString("Data");

                UserGame userGame = new UserGame(GameID, UserID, Name, Date, Error, String_Data.StringToData(Data));

                res.add(userGame);
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
    public List<User> getUser() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<User> res = new ArrayList<User>();
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

                User userTemp = new User(UserID, UserName);

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

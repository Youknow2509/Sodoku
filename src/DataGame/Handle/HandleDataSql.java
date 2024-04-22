package src.DataGame.Handle;

import src.Obj.Game;
import src.Obj.User;
import src.Obj.UserGame;
import src.Utils.String_Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HandleDataSql implements HandleData {
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
    public void addGameUser(int gameId, int userId, String name, int typeGame, int err, int empty, String data) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            String query = "USE Sudoku INSERT INTO UserGames (GameID, UserID, Name, TypeGame, Error, Empty, Data)  " +
                    "VALUES (?, ?, ? ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, gameId);
            preparedStatement.setInt(2, userId);
            preparedStatement.setString(3, name);
            preparedStatement.setInt(4, typeGame);
            preparedStatement.setInt(5, err);
            preparedStatement.setInt(6, empty);
            preparedStatement.setString(7, data);

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
    public void deleteGameUser(int idUserGame) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            String query = "USE Sudoku DELETE FROM UserGames \n" +
                    "WHERE UserGamesID = ?;";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, idUserGame);

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
    public void updateGameUser(int UserGamesID, int gameId, int userId, String name, int typeGame, String date, int err, int empty, String data) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            String query = "USE Sudoku UPDATE UserGames \n" +
                    "SET GameID = ?, UserID = ?, Name = ?, TypeGame = ?, Date = ?, Error = ? , Empty = ?, Data = ? \n" +
                    "WHERE UserGamesID = ?;";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, gameId);
            preparedStatement.setInt(2, userId);
            preparedStatement.setString(3, name);
            preparedStatement.setInt(4, typeGame);
            preparedStatement.setString(5, date);
            preparedStatement.setInt(6, err);
            preparedStatement.setInt(7, empty);
            preparedStatement.setString(8, data);
            preparedStatement.setInt(9, UserGamesID);

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
                int UserGamesID = resultSet.getInt("UserGamesID");
                int GameID = resultSet.getInt("GameID");
                int UserID = resultSet.getInt("UserID");
                String Name = resultSet.getString("Name");
                int TypeGame = resultSet.getInt("TypeGame");
                String Date = resultSet.getDate("Date").toString();
                int Error = resultSet.getInt("Error");
                int Empty = resultSet.getInt("Empty");
                String Data = resultSet.getString("Data");

                UserGame userGame = new UserGame(UserGamesID, UserID, GameID, Name, TypeGame, Date, Error, Empty, String_Data.StringToData(Data));

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

    @Override
    public int getMaxID(String table) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int res = 0;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            // Query
            String query = "Use Sudoku SELECT MAX(?) as IDMax FROM ? ;";
            preparedStatement = connection.prepareStatement(query);
            if (table.equals("Users")) {
                preparedStatement.setString(1, "UserID");
                preparedStatement.setString(2, "Users");
            } else if (table.equals("Games")) {
                preparedStatement.setString(1, "GameID");
                preparedStatement.setString(2, "Games");
            } else if (table.equals("UserGames")) {
                preparedStatement.setString(1, "UserGamesID");
                preparedStatement.setString(2, "UserGames");
            }

            preparedStatement.executeQuery();
            res = resultSet.getInt("IDMax");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close the resources
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
        return res;
    }

    @Override
    public User getUserById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User res = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            // Query
            String query = "Use Sudoku SELECT * FROM Users WHERE UserID = ?;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int UserID = resultSet.getInt("UserID");
                String UserName = resultSet.getString("UserName");

                res = new User(UserID, UserName);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close the resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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
        return res;
    }

    @Override
    public Game getGameById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Game res = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            // Query
            String query = "Use Sudoku SELECT * FROM Games WHERE GameID = ?;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int GameID = resultSet.getInt("GameID");
                int TypeGame = resultSet.getInt("TypeGame");
                int Level = resultSet.getInt("Level");
                int Error = resultSet.getInt("Error");
                int Empty = resultSet.getInt("Empty");
                String Data = resultSet.getString("Data");

                res = new Game(GameID, TypeGame, Level, Error, Empty, String_Data.StringToData(Data));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close the resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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
        return res;
    }

    @Override
    public UserGame getUserGameById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserGame res = null;
        try {
            Class.forName(myDriver);
            connection = getConnection();
            // Query
            String query = "Use Sudoku SELECT * FROM UserGames WHERE UserGamesID = ?;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int UserGamesID = resultSet.getInt("UserGamesID");
                int GameID = resultSet.getInt("GameID");
                int UserID = resultSet.getInt("UserID");
                String Name = resultSet.getString("Name");
                int TypeGame = resultSet.getInt("TypeGame");
                String Date = resultSet.getDate("Date").toString();
                int Error = resultSet.getInt("Error");
                int Empty = resultSet.getInt("Empty");
                String Data = resultSet.getString("Data");

                res = new UserGame(UserGamesID, UserID, GameID, Name, TypeGame, Date, Error, Empty, String_Data.StringToData(Data));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close the resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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
        return res;
    }

    @Override
    public List<Game> getGameByTypeGameAndLevel(int typeGame, int level) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Game> res = new ArrayList<Game>();
        try {
            Class.forName(myDriver);
            connection = getConnection();
            // Query
            String query = "Use Sudoku SELECT * FROM Games WHERE TypeGame = ? AND Level = ?;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, typeGame);
            preparedStatement.setInt(2, level);
            resultSet = preparedStatement.executeQuery();
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
            throw new RuntimeException(e);
        } finally {
            // Close the resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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
        return res;
    }
}

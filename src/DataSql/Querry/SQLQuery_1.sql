
drop DATABASE Sudoku;

USE Sudoku

-- Tạo bảng Players
CREATE TABLE Players (
    PlayerID INT PRIMARY KEY,
    PlayerName VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL -- Đảm bảo rằng mật khẩu này được mã hóa
);

-- Tạo bảng Games
CREATE TABLE Games (
    GameID INT PRIMARY KEY,
    Difficulty VARCHAR(100) NOT NULL,
    InitialState TEXT NOT NULL,
    CurrentState TEXT NOT NULL
);

-- Tạo bảng GameSessions
CREATE TABLE GameSessions (
    SessionID INT PRIMARY KEY,
    GameID INT,
    PlayerID INT,
    SavedState TEXT NOT NULL,
    Timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (GameID) REFERENCES Games(GameID),
    FOREIGN KEY (PlayerID) REFERENCES Players(PlayerID)
);



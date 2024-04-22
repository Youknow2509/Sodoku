
CREATE DATABASE Sudoku;

USE Sudoku;

CREATE TABLE Users (
    UserID INT IDENTITY(1,1) PRIMARY KEY,
    UserName VARCHAR(255) NOT NULL
);

CREATE TABLE Games (
    GameID INT IDENTITY(1,1) PRIMARY KEY,
    TypeGame INT NOT NULL,
    Level INT NOT NULL,
    Error INT NOT NULL,
    Empty INT NOT NULL,
    Data TEXT NOT NULL
);

CREATE TABLE UserGames (
    GameID INT,
    UserID INT,
    Name VARCHAR(255) NOT NULL,
    TypeGame INT NOT NULL,
    Date DATETIME DEFAULT GETDATE(),
    Error INT NOT NULL,
    Empty INT NOT NULL,
    Data TEXT NOT NULL,
    PRIMARY KEY (GameID, UserID),
    FOREIGN KEY (GameID) REFERENCES Games(GameID),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

-- Thêm Users
INSERT INTO Users (UserName) 
VALUES ('nguoichoi1'), ('nguoichoi2'), ('nguoichoi3');
-- Thêm dữ liệu game chính
INSERT INTO Games (TypeGame, Level, Error, Data) 
VALUES (1, 1, 0, 'data_of_game_1'), (2, 2, 0, 'data_of_game_2'), (3, 3, 0, 'data_of_game_3');
-- Thêm dữ liệu game người dùng
INSERT INTO UserGames (GameID, UserID, Error, Data) 
VALUES (1, 1, 0, 'user_game_data_1'), (2, 2, 0, 'user_game_data_2'), (3, 3, 0, 'user_game_data_3');
-- Xoá dữ liệu game người dùng
DELETE FROM UserGames 
WHERE GameID = 1 AND UserID = 1;
-- Xoá người dùng
DELETE FROM Users 
WHERE UserID = 1;
-- Xoá dữ liệu game chính
DELETE FROM Games 
WHERE GameID = 1;
-- Sửa dữ liệu game người dùng 
UPDATE UserGames 
SET Error = 1, Data = 'updated_user_game_data' 
WHERE GameID = 1 AND UserID = 1;
-- Sửa dữ liệu người dùng
UPDATE Users 
SET UserName = 'nguoichoi_moi' 
WHERE UserID = 1;
-- Sửa dữ liệu game chính
UPDATE Games 
SET Level = 2, Error = 1, Data = 'updated_data_of_game' 
WHERE GameID = 1;
-- Lấy dữ liệu game chính
SELECT * FROM Games;
-- Lấy dữ liệu game người dùng
SELECT * FROM UserGames;
-- Lấy dữ liệu người dùng
SELECT * FROM Users;

-- Giá trị Game chính
INSERT INTO Games (TypeGame, Level, Error, Empty, Data) VALUES 
(9, 1, 3, 12, '5 4 8 0 2 3 0 7 9 vVv 9 2 0 4 5 6 1 3 8 vVv 1 3 6 7 0 9 2 0 5 vVv 2 1 3 5 4 7 8 9 6 vVv 4 6 5 0 9 0 3 0 7 vVv 7 8 9 3 6 0 4 5 2 vVv 3 5 1 0 7 2 9 8 4 vVv 6 9 4 8 0 5 7 2 3 vVv 8 7 2 0 3 4 5 6 1 vVv '),
(9, 1, 3, 12, '4 9 3 1 0 5 6 7 8 vVv 1 5 2 6 7 8 3 4 9 vVv 6 8 7 3 4 9 1 2 5 vVv 0 1 0 0 3 6 8 9 7 vVv 3 0 5 8 9 7 2 1 4 vVv 8 7 9 2 1 4 0 3 6 vVv 5 4 1 0 6 2 9 8 0 vVv 0 2 6 9 8 3 4 5 1 vVv 9 0 8 4 0 1 7 6 0 vVv '),
(9, 1, 3, 12, '6 3 4 0 2 5 7 8 9 vVv 7 2 5 3 8 9 1 4 6 vVv 9 8 1 4 6 7 2 3 5 vVv 0 4 2 5 0 6 0 9 7 vVv 3 5 6 7 9 8 4 0 2 vVv 0 7 0 2 0 4 5 6 3 vVv 0 0 7 6 4 0 9 5 8 vVv 4 6 8 9 5 2 3 7 1 vVv 5 9 3 8 7 0 6 2 4 vVv '),
(9, 2, 5, 20, '2 6 9 0 3 0 5 7 0 vVv 0 7 3 2 6 8 1 4 9 vVv 4 1 8 5 7 9 0 3 6 vVv 0 2 0 3 0 6 0 9 7 vVv 3 0 6 8 0 0 0 1 2 vVv 8 9 7 4 1 2 3 6 0 vVv 6 0 1 0 2 5 9 8 4 vVv 7 4 2 9 8 0 6 5 3 vVv 9 8 0 0 0 3 7 2 1 vVv '),
(9, 2, 5, 20, '4 1 9 2 3 5 6 7 0 vVv 6 2 7 1 4 8 0 0 9 vVv 3 0 8 6 7 9 1 2 4 vVv 1 3 2 4 0 6 8 9 7 vVv 0 7 4 0 9 0 2 0 0 vVv 0 9 6 0 2 7 4 1 0 vVv 2 4 5 0 6 3 9 0 0 vVv 7 6 1 9 8 0 0 4 3 vVv 0 8 0 5 1 4 7 6 2 vVv '),
(9, 2, 5, 20, '0 9 3 1 0 5 6 7 8 vVv 7 8 1 0 3 0 4 5 0 vVv 5 0 6 0 8 9 0 2 3 vVv 1 2 4 3 5 7 8 0 0 vVv 3 5 0 6 0 8 0 1 4 vVv 8 6 9 0 1 2 5 3 7 vVv 0 1 2 0 7 3 9 6 5 vVv 6 3 5 9 2 4 7 8 1 vVv 0 7 8 0 6 0 3 4 0 vVv '),
(9, 3, 7, 30, '3 0 0 0 4 5 6 7 0 vVv 5 6 0 2 7 9 1 0 8 vVv 7 1 0 0 6 8 2 0 0 vVv 1 0 0 0 0 6 8 0 7 vVv 4 0 0 0 9 1 3 0 6 vVv 6 9 8 7 2 0 4 5 0 vVv 2 0 0 5 8 7 9 6 4 vVv 8 7 6 0 0 4 5 1 2 vVv 0 0 0 6 1 0 7 8 0 vVv '),
(9, 3, 7, 30, '0 0 3 1 0 0 7 8 0 vVv 1 4 0 2 7 8 3 5 6 vVv 6 0 7 0 5 9 1 2 0 vVv 0 1 4 5 0 7 0 0 0 vVv 3 5 6 8 9 1 0 4 7 vVv 7 9 0 0 6 0 0 0 0 vVv 4 0 1 6 8 5 9 0 2 vVv 8 7 2 9 1 0 4 6 5 vVv 0 6 0 0 2 0 8 0 0 vVv '),
(9, 3, 7, 30, '0 6 1 2 0 4 0 0 8 vVv 0 2 7 0 6 8 3 0 0 vVv 8 3 4 0 0 9 1 2 6 vVv 0 4 0 0 5 6 8 0 7 vVv 3 0 6 0 0 7 0 1 4 vVv 0 0 9 4 1 2 6 3 0 vVv 2 1 8 7 0 0 9 6 0 vVv 4 9 3 0 8 0 0 0 2 vVv 0 7 0 9 2 3 4 8 1 vVv '),
(16, 1, 4, 16, '10 2 13 5 1 3 4 6 7 8 9 11 12 14 0 16 vVv 1 4 12 3 2 5 7 8 6 14 15 16 9 10 11 13 vVv 14 8 15 6 9 10 11 16 1 2 12 13 3 4 5 7 vVv 7 16 11 9 12 13 14 15 3 4 5 10 1 2 6 8 vVv 2 1 3 4 5 6 8 7 9 10 11 12 13 15 0 14 vVv 5 6 7 8 3 1 2 4 13 15 16 14 10 9 12 11 vVv 9 10 14 11 13 0 16 12 2 1 3 4 5 7 8 6 vVv 12 0 16 15 10 11 9 14 5 6 0 8 2 1 3 4 vVv 3 5 1 0 4 7 6 9 8 11 10 15 14 16 13 12 vVv 4 7 6 10 8 2 12 1 14 16 13 3 11 5 9 15 vVv 11 12 8 14 15 16 3 13 4 0 1 9 7 6 2 10 vVv 13 15 9 16 11 14 5 10 0 7 2 6 0 8 1 3 vVv 0 3 2 1 7 4 10 0 15 12 8 5 16 13 14 9 vVv 8 9 4 7 6 0 1 3 16 13 14 2 15 11 10 0 vVv 15 14 10 12 16 8 13 5 11 9 4 0 6 3 7 2 vVv 16 0 5 13 14 9 15 2 0 3 6 7 8 12 4 1 vVv '),
(16, 1, 4, 16, '12 8 16 0 1 2 3 4 5 6 7 9 11 13 0 0 vVv 2 9 13 11 5 6 7 8 1 3 14 15 4 10 12 16 vVv 5 1 4 7 9 10 14 15 11 12 13 16 2 3 6 8 vVv 3 14 0 15 11 12 13 0 2 4 8 10 1 0 7 9 vVv 1 2 3 4 6 5 8 0 9 10 11 12 13 15 16 14 vVv 6 5 7 8 2 1 4 3 13 15 16 14 9 11 10 12 vVv 9 10 11 12 13 15 16 14 3 1 2 4 5 6 8 7 vVv 13 15 14 0 10 9 11 12 6 7 0 8 3 1 2 4 vVv 4 0 1 2 7 8 5 6 10 9 12 11 14 16 15 13 vVv 7 6 5 9 3 4 1 2 14 16 15 13 8 12 11 10 vVv 8 0 10 14 12 16 15 13 4 2 1 6 7 9 3 5 vVv 15 16 12 13 14 11 9 10 7 8 3 5 6 0 4 1 vVv 10 4 2 1 8 3 12 5 15 0 9 7 16 14 13 6 vVv 11 7 8 3 15 13 6 9 16 14 10 1 12 4 5 2 vVv 14 13 9 6 16 7 10 11 12 5 0 2 15 8 1 3 vVv 16 12 15 0 4 14 2 1 8 13 6 3 10 7 9 0 vVv '),
(16, 1, 4, 16, '5 0 16 8 1 3 4 6 7 9 10 11 12 13 14 15 vVv 9 13 4 1 2 5 7 0 3 12 14 15 6 10 11 16 vVv 7 12 3 6 10 11 0 15 1 2 13 16 4 5 8 9 vVv 14 11 10 15 9 12 0 16 4 5 6 8 1 2 3 7 vVv 1 3 2 4 5 6 8 7 9 10 11 12 13 15 16 14 vVv 6 5 7 9 0 1 0 4 13 15 16 14 8 11 10 12 vVv 8 10 11 12 13 0 16 14 2 1 3 4 0 7 9 6 vVv 13 14 0 16 11 9 10 12 5 6 8 7 2 1 4 3 vVv 2 1 5 3 0 7 6 9 0 11 12 10 14 0 15 13 vVv 4 6 8 7 12 2 15 1 0 16 9 13 10 3 5 11 vVv 10 9 12 0 0 16 3 13 15 4 1 5 7 6 2 8 vVv 15 16 13 14 8 10 5 11 6 3 7 2 9 4 12 1 vVv 3 4 1 2 6 8 11 5 12 7 15 9 16 14 13 10 vVv 11 7 6 13 16 14 9 2 10 8 0 3 15 12 1 5 vVv 12 8 14 10 15 4 1 3 16 13 5 6 11 9 7 2 vVv 16 15 9 5 7 13 12 10 11 14 2 1 3 8 6 4 vVv '),
(16, 2, 6, 25, '15 8 6 13 0 2 3 4 0 0 9 10 11 12 14 16 vVv 0 11 10 7 5 6 8 9 1 2 12 16 0 4 0 15 vVv 5 0 2 1 7 11 12 16 3 13 14 15 6 8 9 10 vVv 9 16 0 12 10 13 14 15 4 6 8 11 1 0 5 7 vVv 1 2 4 3 6 5 7 8 9 10 11 12 13 15 16 14 vVv 6 5 7 8 2 1 4 3 13 15 16 14 9 10 11 12 vVv 10 9 11 14 12 15 0 13 0 1 3 0 5 6 7 8 vVv 12 13 0 16 9 10 11 14 6 0 7 8 2 1 3 0 vVv 2 1 5 0 3 7 6 10 0 9 15 13 14 16 12 0 vVv 3 6 8 0 4 0 1 11 14 16 2 5 10 7 15 13 vVv 7 10 12 15 14 16 13 2 0 3 4 1 8 5 6 9 vVv 13 14 16 11 8 9 15 5 7 12 10 6 4 3 1 2 vVv 4 3 1 2 11 8 5 0 15 14 13 7 16 9 0 6 vVv 8 7 0 5 15 14 10 1 16 11 6 2 12 13 4 3 vVv 11 12 13 6 16 3 2 7 10 4 1 9 15 14 8 5 vVv 16 15 14 10 13 0 9 6 12 8 5 3 7 11 2 1 vVv '),
(16, 2, 6, 25, '5 9 12 10 1 2 3 4 0 7 8 11 0 14 15 16 vVv 16 13 0 1 5 6 7 8 2 0 14 0 4 9 10 0 vVv 7 15 8 0 9 10 11 0 4 12 13 16 1 2 3 5 vVv 3 0 2 4 12 0 15 0 1 5 9 10 6 7 8 11 vVv 1 2 3 5 4 7 6 9 8 10 11 12 0 13 16 0 vVv 4 6 7 8 2 1 5 3 13 15 16 14 9 11 12 10 vVv 9 10 13 11 14 12 16 15 3 1 2 4 0 6 7 8 vVv 12 16 14 15 8 11 10 13 5 6 7 0 2 1 4 3 vVv 2 1 4 3 6 5 8 7 9 16 10 13 12 15 11 14 vVv 6 5 9 7 3 4 1 11 12 14 15 8 10 16 0 13 vVv 8 11 10 13 0 16 14 12 7 2 0 5 3 4 6 9 vVv 0 12 15 16 0 9 13 2 11 4 3 6 7 8 5 1 vVv 0 3 1 2 11 8 9 0 15 13 0 7 16 12 0 6 vVv 11 4 5 9 7 14 12 1 16 8 6 3 15 10 13 2 vVv 13 7 6 12 16 15 2 10 14 11 5 1 8 3 9 4 vVv 15 8 16 14 13 3 4 6 0 9 12 2 11 5 1 7 vVv '),
(16, 2, 6, 25, '0 14 16 15 1 2 3 4 5 0 7 9 10 11 12 13 vVv 9 4 7 12 5 6 8 0 1 2 11 13 0 14 0 16 vVv 3 1 5 13 7 9 11 12 10 14 15 16 2 4 6 8 vVv 2 10 11 6 13 14 15 16 3 4 8 12 1 5 0 9 vVv 1 2 3 4 6 5 7 8 9 10 12 11 13 15 16 0 vVv 5 6 0 7 2 1 4 3 13 15 16 0 9 10 11 12 vVv 10 9 12 11 14 13 16 15 2 1 3 4 5 6 8 7 vVv 0 15 14 16 9 10 12 11 6 7 5 8 4 1 2 3 vVv 4 3 1 2 8 7 0 6 11 9 13 10 12 16 14 0 vVv 6 5 9 0 3 4 1 2 12 16 14 15 7 13 10 11 vVv 7 11 15 10 12 0 0 14 4 0 1 6 8 2 9 5 vVv 12 16 13 14 11 15 10 0 7 8 2 5 6 3 1 4 vVv 11 7 2 0 4 0 14 5 15 12 6 3 16 9 13 10 vVv 14 8 4 0 10 11 2 0 16 13 9 7 15 12 5 6 vVv 15 12 6 5 16 3 0 0 8 11 10 1 14 7 0 2 vVv 16 13 10 9 15 12 6 7 14 5 0 2 11 8 3 1 vVv '),
(16, 3, 8, 40, '16 3 9 8 1 2 0 0 6 7 10 0 12 13 14 15 vVv 15 1 12 11 3 6 7 8 2 4 13 0 0 0 10 16 vVv 2 4 14 6 9 10 11 13 5 12 15 16 0 3 7 8 vVv 5 0 10 13 12 14 15 16 1 3 8 9 2 4 6 11 vVv 1 2 3 4 5 0 0 9 8 10 11 0 13 15 0 0 vVv 6 5 0 0 2 1 3 4 13 14 16 15 0 10 0 12 vVv 8 10 11 12 0 15 16 0 3 1 2 4 6 5 9 0 vVv 13 14 0 16 8 11 10 12 7 0 9 6 3 1 2 4 vVv 3 6 1 2 4 5 8 7 9 11 0 10 14 16 15 13 vVv 4 8 5 7 6 3 1 0 16 2 14 13 9 11 12 10 vVv 9 0 13 10 14 16 12 0 0 6 1 7 4 8 3 5 vVv 12 15 0 0 0 9 13 0 4 0 3 0 7 2 1 6 vVv 0 9 2 1 11 4 0 10 12 15 6 8 16 14 13 3 vVv 0 12 4 3 0 13 14 1 11 0 5 2 15 6 8 9 vVv 11 13 8 15 16 12 2 6 14 9 4 3 10 7 5 1 vVv 14 16 6 5 15 0 0 3 10 13 7 1 11 12 4 2 vVv '),
(16, 3, 8, 40, '15 10 2 11 1 3 4 5 6 7 8 9 12 0 14 0 vVv 5 16 8 0 2 6 7 9 1 3 12 14 4 0 0 15 vVv 0 3 14 0 8 10 11 13 2 0 15 16 1 6 7 9 vVv 0 7 9 1 0 14 15 0 4 10 11 13 2 3 5 8 vVv 1 2 3 5 0 7 0 8 9 11 10 12 13 15 16 14 vVv 0 0 7 8 3 1 2 10 13 14 16 15 5 0 12 11 vVv 9 11 10 12 13 15 16 14 3 1 2 0 6 4 8 7 vVv 13 14 15 16 0 9 12 0 7 0 6 8 3 1 2 10 vVv 2 1 4 3 6 0 0 0 10 9 0 11 14 0 15 12 vVv 7 5 6 9 0 2 1 12 0 16 14 3 8 11 0 13 vVv 8 12 11 10 14 16 13 15 5 2 1 4 9 7 0 6 vVv 14 13 16 15 9 11 3 4 8 12 7 6 10 2 1 5 vVv 3 4 1 7 11 8 0 6 12 15 9 10 16 14 13 2 vVv 10 8 5 2 15 13 14 0 16 6 3 7 0 12 9 0 vVv 0 15 0 6 16 4 9 2 14 13 5 1 0 8 10 3 vVv 16 9 13 0 7 0 10 3 0 8 0 2 15 5 6 1 vVv '),
(16, 3, 8, 40, '11 14 0 7 1 2 4 5 6 8 9 10 12 13 15 16 vVv 10 0 2 5 3 6 7 0 1 0 15 16 4 9 11 14 vVv 1 6 8 15 9 10 0 16 4 0 0 14 2 3 0 7 vVv 12 0 9 0 11 13 14 15 2 3 5 7 1 6 8 10 vVv 2 1 0 3 0 7 6 9 8 10 11 12 13 14 0 15 vVv 0 0 6 8 2 0 0 0 13 14 16 15 9 10 12 11 vVv 9 10 11 12 13 15 16 14 3 1 2 4 5 7 6 8 vVv 13 15 0 16 8 0 10 12 5 6 7 9 0 1 2 4 vVv 3 2 1 0 4 5 8 7 9 0 10 11 15 16 14 12 vVv 0 5 7 9 6 3 0 1 12 16 14 2 0 11 0 13 vVv 8 11 10 14 12 16 2 13 15 0 0 6 7 5 3 9 vVv 15 12 16 13 10 14 9 11 7 5 3 8 6 0 4 0 vVv 6 3 0 1 7 4 11 10 14 15 8 13 16 12 9 0 vVv 7 4 0 0 14 8 1 2 16 9 0 3 11 15 0 5 vVv 0 8 15 2 0 9 13 3 11 7 12 5 10 4 1 6 vVv 16 9 13 11 15 12 5 6 10 2 4 1 14 8 7 0 vVv ');

-- Xoa du lieu tat ca bang
DELETE FROM Users;
DELETE FROM Games;
DELETE FROM UserGames;
-- Xoa tat ca bang
DROP TABLE Users;
DROP TABLE Games;
DROP TABLE UserGames;
-- Test

SELECT * FROM Users;
SELECT * FROM Games;
SELECT * FROM UserGames;



INSERT INTO UserGames (GameID, UserID, Name, TypeGame, Date, Error, Empty , Data) 
VALUES (3, 2, 'Game ok', 9, GETDATE(), 3, 10, '5 4 8 0 2 3 0 7 9 vVv 9 2 0 4 5 6 1 3 8 vVv 1 3 6 7 0 9 2 0 5 vVv 2 1 3 5 4 7 8 9 6 vVv 4 6 5 0 9 0 3 0 7 vVv 7 8 9 3 6 0 4 5 2 vVv 3 5 1 0 7 2 9 8 4 vVv 6 9 4 8 0 5 7 2 3 vVv 8 7 2 0 3 4 5 6 1 vVv ')

INSERT INTO UserGames (GameID, UserID, Name, TypeGame, Date, Error, Empty , Data) 
VALUES (10, 1, 'Game ok 16', 16, GETDATE(), 4, 16, '10 2 13 5 1 3 4 6 7 8 9 11 12 14 0 16 vVv 1 4 12 3 2 5 7 8 6 14 15 16 9 10 11 13 vVv 14 8 15 6 9 10 11 16 1 2 12 13 3 4 5 7 vVv 7 16 11 9 12 13 14 15 3 4 5 10 1 2 6 8 vVv 2 1 3 4 5 6 8 7 9 10 11 12 13 15 0 14 vVv 5 6 7 8 3 1 2 4 13 15 16 14 10 9 12 11 vVv 9 10 14 11 13 0 16 12 2 1 3 4 5 7 8 6 vVv 12 0 16 15 10 11 9 14 5 6 0 8 2 1 3 4 vVv 3 5 1 0 4 7 6 9 8 11 10 15 14 16 13 12 vVv 4 7 6 10 8 2 12 1 14 16 13 3 11 5 9 15 vVv 11 12 8 14 15 16 3 13 4 0 1 9 7 6 2 10 vVv 13 15 9 16 11 14 5 10 0 7 2 6 0 8 1 3 vVv 0 3 2 1 7 4 10 0 15 12 8 5 16 13 14 9 vVv 8 9 4 7 6 0 1 3 16 13 14 2 15 11 10 0 vVv 15 14 10 12 16 8 13 5 11 9 4 0 6 3 7 2 vVv 16 0 5 13 14 9 15 2 0 3 6 7 8 12 4 1 vVv ')


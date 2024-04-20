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
    Data TEXT NOT NULL
);

CREATE TABLE UserGames (
    GameID INT,
    UserID INT,
    Date DATETIME DEFAULT GETDATE(),
    Error INT NOT NULL,
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


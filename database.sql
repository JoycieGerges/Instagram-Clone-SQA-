CREATE DATABASE IF NOT EXISTS instagram_clone;
 USE instagram_clone;

-- -- إنشاء جدول المستخدمين
-- CREATE TABLE Users (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     username VARCHAR(50) UNIQUE NOT NULL,
--     email VARCHAR(100) UNIQUE NOT NULL,
--     password VARCHAR(255) NOT NULL,
--     bio TEXT,
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
-- );

-- -- -- إنشاء جدول البوستات
-- CREATE TABLE Posts (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     user_id INT NOT NULL,
--     image_url VARCHAR(255),
--     caption TEXT,
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE
-- );

-- -- -- إنشاء جدول الكومنتات
-- CREATE TABLE Comments (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     post_id INT NOT NULL,
--     user_id INT NOT NULL,
--     comment_text TEXT NOT NULL,
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     FOREIGN KEY (post_id) REFERENCES Posts(id) ON DELETE CASCADE,
--     FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE
-- );

-- -- -- إنشاء جدول اللايكات
-- CREATE TABLE Likes (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     post_id INT NOT NULL,
--     user_id INT NOT NULL,
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     FOREIGN KEY (post_id) REFERENCES Posts(id) ON DELETE CASCADE,
--     FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE
-- );

-- -- -- إنشاء جدول المتابعين
-- CREATE TABLE Followers (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     user_id INT NOT NULL,
--     follower_id INT NOT NULL,
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE,
--     FOREIGN KEY (follower_id) REFERENCES Users(id) ON DELETE CASCADE
-- );



-- -- -- Users
-- INSERT INTO Users (username, email, password, bio, created_at) VALUES
-- ('ahmed', 'ahmed@gmail.com', '123456', 'Photographer 📸', '2025-01-01'),
-- ('sara', 'sara@yahoo.com', 'pass123', 'Traveler ✈️', '2025-01-02'),
-- ('mohamed', 'mohamed@hotmail.com', 'secret', 'Food lover 🍕', '2025-01-03'),
-- ('dina', 'dina@gmail.com', '1234', 'Fitness addict 🏋️‍♀️', '2025-01-04'),
-- ('omar', 'omar@gmail.com', '654321', 'Gamer 🎮', '2025-01-05');

-- -- -- Posts
-- INSERT INTO Posts (user_id, image_url, caption, created_at) VALUES
-- (1, 'img1.jpg', 'Sunset at the beach 🌅', '2025-02-01'),
-- (2, 'img2.jpg', 'In Paris 🇫🇷', '2025-02-02'),
-- (3, 'img3.jpg', 'Best pizza in town 🍕', '2025-02-03'),
-- (4, 'img4.jpg', 'Morning workout! 💪', '2025-02-04'),
-- (5, 'img5.jpg', 'New high score! 🎮', '2025-02-05');

-- -- -- Comments
-- INSERT INTO Comments (post_id, user_id, comment_text, created_at) VALUES
-- (1, 2, 'Beautiful view! 🌊', '2025-02-06'),
-- (2, 3, 'Enjoy your trip! ✈️', '2025-02-07'),
-- (3, 1, 'Looks delicious 🤤', '2025-02-08'),
-- (4, 5, 'Great job! 💥', '2025-02-09'),
-- (5, 4, 'Congrats! 🏆', '2025-02-10');

-- -- -- Likes
-- INSERT INTO Likes (post_id, user_id, created_at) VALUES
-- (1, 3, '2025-02-11'),
-- (1, 4, '2025-02-11'),
-- (2, 1, '2025-02-12'),
-- (3, 5, '2025-02-12'),
-- (5, 2, '2025-02-13');

-- -- -- Followers
-- INSERT INTO Followers (user_id, follower_id, created_at) VALUES
-- (1, 2, '2025-02-14'),
-- (1, 3, '2025-02-15'),
-- (2, 4, '2025-02-15'),
-- (3, 5, '2025-02-16'),
-- (4, 1, '2025-02-16');


SELECT * FROM Users WHERE email IS NULL OR email = '';

SELECT username, COUNT(*) 
FROM Users
GROUP BY username
HAVING COUNT(*) > 1;

SELECT email, COUNT(*) 
FROM Users
GROUP BY email
HAVING COUNT(*) > 1;


SELECT * FROM Users WHERE password IS NULL OR password = '';

SELECT * FROM posts;

SELECT * FROM users WHERE username = 'admin' OR '1'='1';




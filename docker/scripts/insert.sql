CREATE DATABASE IF NOT EXISTS demo_db;

USE demo_db;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL  -- パスワード用カラムを追加
);

INSERT INTO users (name, email, password) VALUES 
('testUser1', 'testUser1@example.com', '$2a$10$...'),  -- パスワード例
('testUser2', 'testUser2@example.com', 'user2');      -- パスワード例


-- 社内ニュースのテーブルを作成
CREATE TABLE IF NOT EXISTS notice (
    id INT AUTO_INCREMENT PRIMARY KEY,            -- ニュースID
    importance VARCHAR(20) NOT NULL,              -- 重要度
    area VARCHAR(100) NOT NULL,                   -- 区域
    content TEXT NOT NULL,                        -- ニュース内容
    issue_date DATE NOT NULL                -- 発行日
);

-- サンプルデータの挿入
INSERT INTO notice (importance, area, content, issue_date) VALUES
('High', '全社', '新しいプロジェクトが開始されました。', '2024-12-30'),
('Medium', '東京支社', '新しいオフィスが開設されます。', '2024-12-29'),
('Low', '大阪支社', '社員の健康診断が来月実施されます。', '2024-12-28');

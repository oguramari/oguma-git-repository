/* ユーザーマスタ */
CREATE TABLE IF NOT EXISTS demo_user (
                                         user_id VARCHAR(50) PRIMARY KEY
    ,password VARCHAR(100)
    ,user_name VARCHAR(50)
    ,birthday DATE
    ,age INT
    ,gender INT
    ,department_id INT
    ,role VARCHAR(50)
);

/* 部署マスタ */
CREATE TABLE IF NOT EXISTS demo_department (
                                               department_id INT PRIMARY KEY
    ,department_name VARCHAR(50)
);

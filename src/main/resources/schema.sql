CREATE DATABASE testdb;

/* ユーザーマスタ */
CREATE TABLE IF NOT EXISTS demo_user (
    user_id character varying(50) NOT NULL,
    password character varying(100),
    user_name character varying(50),
    birthday date,
    age smallint,
    gender smallint,
    department_id smallint,
    role character varying(50),
    PRIMARY KEY(user_id),
    UNIQUE(user_id)
    );

/* 部署マスタ */
CREATE TABLE IF NOT EXISTS demo_department (
    department_id smallint NOT NULL,
    department_name character varying(50),
    PRIMARY KEY(department_id)
);

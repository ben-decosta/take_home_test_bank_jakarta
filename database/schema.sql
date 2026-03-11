CREATE DATABASE take_home_test;

CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    title varchar(50),
    descriptions varchar(100)
);
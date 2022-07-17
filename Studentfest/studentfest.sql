CREATE DATABASE studentfest;
USE studentfest;
Show tables;

SELECT * FROM student;

SELECT * FROM roles;

INSERT INTO roles VALUES(1, 'ADMIN');
INSERT INTO roles VALUES(2, 'USER');

SELECT * FROM users;

INSERT INTO users VALUES(1, '$2a$12$jMbtt5IKqjHwdrf.RZFfxOjtkB4/HkC3t3/a8EEyHB26gV.Kqm.ua', 'KIRAN');
INSERT INTO users VALUES(2, '$2a$12$jMbtt5IKqjHwdrf.RZFfxOjtkB4/HkC3t3/a8EEyHB26gV.Kqm.ua', 'GOURAV');
SELECT * FROM users_roles;

INSERT INTO users_roles VALUES(1, 1);

INSERT INTO users_roles VALUES(2, 2);

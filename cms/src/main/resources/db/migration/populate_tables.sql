/********************************************************
*	This script populates the database named cms_database
*********************************************************/

--connect to database
\c cms_database

INSERT INTO role_table(name)
VALUES ('ROLE_STUDENT');

INSERT INTO role_table(name)
VALUES ('ROLE_TEACHER');

INSERT INTO role_table(name)
VALUES ('ROLE_ADMIN');

INSERT INTO user_table(name, username, password, email, role, confirmed)
VALUES ('Bill Gates', 'billgates123', '$2y$12$9lYwdrE4ajrEF2IXAOyt4e.4ot1faLJ4bt2RJ/63KZNKzncSaioCS', 'billgates@gmail.com', 1, true);

INSERT INTO user_table(name, username, password, email, role, confirmed)
VALUES ('Barrack Obama', 'Obama1', '$2y$12$9lYwdrE4ajrEF2IXAOyt4e.4ot1faLJ4bt2RJ/63KZNKzncSaioCS', 'itsyaboy@gmail.com', 1, true);
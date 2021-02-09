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

INSERT INTO user_table(name, username, password, email, confirmed)
VALUES ('Bill Gates', 'billgates123', '$2y$12$9lYwdrE4ajrEF2IXAOyt4e.4ot1faLJ4bt2RJ/63KZNKzncSaioCS', 'billgates@gmail.com', true);

INSERT INTO user_table(name, username, password, email, confirmed)
VALUES ('Barrack Obama', 'Obama1', '$2y$12$9lYwdrE4ajrEF2IXAOyt4e.4ot1faLJ4bt2RJ/63KZNKzncSaioCS', 'itsyaboy@gmail.com', true);

INSERT INTO user_role_table(user_id, role_id)
VALUES (1,1);

INSERT INTO user_role_table(user_id, role_id)
VALUES (2,1);

INSERT INTO privilege_table(name)
VALUES ('READ_PRIVILEGE');

INSERT INTO privilege_table(name)
VALUES ('WRITE_PRIVILEGE');


INSERT INTO role_privilege_table(role_id, privilege_id)
VALUES (1,1);

INSERT INTO role_privilege_table(role_id, privilege_id)
VALUES (2,1);

INSERT INTO role_privilege_table(role_id, privilege_id)
VALUES (3,1);

INSERT INTO role_privilege_table(role_id, privilege_id)
VALUES (3,2);

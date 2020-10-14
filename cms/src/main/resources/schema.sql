/******************************************************
*	This script creates the database named cms_database
*******************************************************/

--database
-- CREATE DATABASE cms_database
--
-- GO

--Table:role_table
CREATE TABLE role_table(
role_id SERIAL NOT NULL,
name VARCHAR(32),
PRIMARY KEY (role_id)
);

--Table:role_table
CREATE TABLE role_table(
role_id SERIAL NOT NULL,
name VARCHAR(32),
PRIMARY KEY (role_id)
);

--tables
--Table:user_table
CREATE TABLE user_table(
user_id SERIAL NOT NULL,
name VARCHAR(32),
username VARCHAR(32),
password VARCHAR(255), -- 255 char lenght to accomodate space for the hashed password
email VARCHAR(32),
role INT NOT NULL,
confirmed BOOLEAN,
PRIMARY KEY (user_id),
FOREIGN KEY (role) REFERENCES role_table(role_id)
);

--Table:conference_table
CREATE TABLE conference_table(
conference_id SERIAL NOT NULL,
user_id INT NOT NULL,
name VARCHAR(32),
description VARCHAR(255),
startConference DATE,
endConference DATE,
PRIMARY KEY (conference_id),
FOREIGN KEY (user_id) REFERENCES user_table(user_id)
);

--Table:pieceOfWork_table
CREATE TABLE pieceOfWork_table(
pieceOfWork_id INT NOT NULL AUTO_INCREMENT,
user_id INT NOT NULL,
name VARCHAR(32),
teacherNote VARCHAR(32),
rating INT,
PRIMARY KEY (pieceOfWork_id),
FOREIGN KEY (user_id) REFERENCES user_table(user_id)
);

--Table:message_table
CREATE TABLE message_table(
message_id INT NOT NULL AUTO_INCREMENT,
user_id INT NOT NULL,
recipient_id INT NOT NULL,
subject VARCHAR(32),
body VARCHAR(255),
sendAll BIT,
PRIMARY KEY (message_id),
FOREIGN KEY (user_id) REFERENCES user_table(user_id),
FOREIGN KEY (recipient_id) REFERENCES user_table(user_id)
);

--Table:attendance_table
CREATE TABLE attendance_table(
user_id INT NOT NULL,
conference_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user_table(user_id),
FOREIGN KEY (conference_id) REFERENCES conference_table(conference_id)
);
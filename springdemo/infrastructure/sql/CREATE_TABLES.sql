
-- DROP TABLE Student

CREATE TABLE Student (
	id int IDENTITY(1,1) PRIMARY KEY,
	first_name varchar(255) NOT NULL,
	last_name varchar(255) NOT NULL,
	created_at datetime NOT NULL,
	updated_at datetime NULL,
);



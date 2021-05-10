CREATE TABLE Address (
	id int IDENTITY(1,1) PRIMARY KEY,
	street varchar(255) NOT NULL,
	city varchar(255) NOT NULL
);

-- STUDENT TABLE
CREATE TABLE Student (
	id int IDENTITY(1,1) PRIMARY KEY,
	first_name varchar(255) NOT NULL,
	last_name varchar(255) NOT NULL,
	created_at datetime NOT NULL,
	updated_at datetime NULL,
	address_id int FOREIGN KEY REFERENCES Address(id)
);

-- COURSE TABLE
CREATE TABLE Course (
	id int IDENTITY(1,1) PRIMARY KEY,
	name varchar(255) NOT NULL,
	student_id int FOREIGN KEY REFERENCES Student(id)
);
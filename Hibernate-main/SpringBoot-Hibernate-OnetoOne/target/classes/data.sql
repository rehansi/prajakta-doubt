-- Student table
CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

-- Passport table
CREATE TABLE passport (
    id INT PRIMARY KEY,
    number VARCHAR(50),
    student_id INT,
    FOREIGN KEY (student_id) REFERENCES student(id)
);

insert into student (id,name) values (1,'Sam');
insert into student (id,name) values (2,'Hiren');

insert into passport (id, number,student_id) values(1,'IND100',1);
insert into passport (id, number,student_id) values(2,'IND101',2);

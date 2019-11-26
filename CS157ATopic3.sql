CREATE DATABASE CS157ADatabase;
Use CS157ADatabase;

CREATE TABLE PATIENT ( 
	thc INT PRIMARY KEY AUTO_INCREMENT,  
	first_name VARCHAR(20) NOT NULL,  	
	last_name VARCHAR(40) NOT NULL);
CREATE TABLE VISIT (
	visit_id INT PRIMARY KEY AUTO_INCREMENT, 
        visit_datetime DATETIME DEFAULT CURRENT_TIMESTAMP,
	visit_date VARCHAR(20) AS (DATE_FORMAT(visit_datetime,'%m/%d/%Y')), 
	visit_number INT DEFAULT 1,  
	thc INT NOT NULL, 
	FOREIGN KEY(`thc`) REFERENCES PATIENT(`thc`));
CREATE TABLE THI (
	thi_id INT PRIMARY KEY AUTO_INCREMENT, 
	f1 SMALLINT, 
	f2 SMALLINT, 
	e3 SMALLINT,  
	f4 SMALLINT,  
	c5 SMALLINT,  
	e6 SMALLINT, 
	f7 SMALLINT, 
	c8 SMALLINT, 
	f9 SMALLINT, 
	e10 SMALLINT,  
	c11 SMALLINT, 
	f12 SMALLINT, 
	f13 SMALLINT, 
	e14 SMALLINT, 
	f15 SMALLINT, 
	e16 SMALLINT, 
	e17 SMALLINT, 
	f18 SMALLINT,  
	c19 SMALLINT,  
	f20 SMALLINT,  
	e21 SMALLINT, 
	e22 SMALLINT,  
	c23 SMALLINT,  
	f24 SMALLINT,  
	e25 SMALLINT, 
	f_score SMALLINT,  
	e_score SMALLINT, 
	c_score SMALLINT, 
	total_score SMALLINT,  
	visit_id INT, 
	FOREIGN KEY(`visit_id`) REFERENCES VISIT(`visit_id`));
CREATE TABLE TFI (
	tfi_id INT PRIMARY KEY AUTO_INCREMENT,  
	i1 SMALLINT,  
	i2 SMALLINT, 
	i3 SMALLINT,  
	sc4 SMALLINT, 
	sc5 SMALLINT, 
	sc6 SMALLINT, 
	c7 SMALLINT,  
	c8 SMALLINT, 
	c9 SMALLINT, 
	sl10 SMALLINT,  
	sl11 SMALLINT, 
	sl12 SMALLINT, 
	a13 SMALLINT, 
	a14 SMALLINT,  
	a15 SMALLINT,  
	r16 SMALLINT, 
	r17 SMALLINT,  
	r18 SMALLINT,  
	q19 SMALLINT, 
	q20 SMALLINT,  
	q21 SMALLINT, 
	q22 SMALLINT, 
	e23 SMALLINT, 
	e24 SMALLINT, 
	e25 SMALLINT, 
	i_score SMALLINT,
	sc_score SMALLINT,  
	c_score SMALLINT, 
	sl_score SMALLINT, 
	a_score SMALLINT, 
	r_score SMALLINT, 
	q_score SMALLINT, 
	e_score SMALLINT, 
	total_score SMALLINT,  
	visit_id INT, 
	FOREIGN KEY(`visit_id`) REFERENCES VISIT(`visit_id`));

ALTER TABLE PATIENT AUTO_INCREMENT = 120;
insert into PATIENT(first_name,last_name ) values ('John','Smith');
insert into PATIENT(first_name,last_name )  values ('Kim','Nguyen');
insert into PATIENT(first_name,last_name ) values ('Juan','Carlos');
insert into PATIENT(first_name,last_name ) values ('Mike','Jones');
insert into PATIENT(first_name,last_name ) values ('Chloe','Hernandez');
insert into PATIENT(first_name,last_name ) values ('Sarah','Wilson');
ALTER TABLE VISIT AUTO_INCREMENT = 520;
insert into VISIT(thc) values (120);
insert into VISIT(thc) values (121);
insert into VISIT(thc) values (122);
insert into VISIT(thc) values (123);
insert into VISIT(thc) values (124);
insert into VISIT(thc) values (125);
ALTER TABLE THI AUTO_INCREMENT = 100;
ALTER TABLE TFI AUTO_INCREMENT = 50;
DELIMITER $$
CREATE TRIGGER insert_visit BEFORE INSERT ON VISIT 
FOR EACH ROW 
BEGIN 
SET NEW.visit_number = (SELECT 1+MAX(visit_number) FROM VISIT WHERE thc= NEW.thc);
END$$
DELIMITER ;

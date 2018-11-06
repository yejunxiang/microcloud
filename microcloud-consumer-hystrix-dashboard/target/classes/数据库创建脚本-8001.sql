DROP DATABASE IF EXISTS caxins8001;
CREATE DATABASE caxins8001 CHARACTER SET UTF8;
USE caxins8001;
CREATE TABLE dept(
	deptno BIGINT AUTO_INCREMENT,
	dname VARCHAR(50),
	loc VARCHAR(50),
	CONSTRAINT pk_deptno PRIMARY KEY(deptno)
);
INSERT INTO dept(dname,loc) values ('开发部',database());
INSERT INTO dept(dname,loc) values ('财务部',database());
INSERT INTO dept(dname,loc) values ('市场部',database());
INSERT INTO dept(dname,loc) values ('后勤部',database());
INSERT INTO dept(dname,loc) values ('工关部',database());
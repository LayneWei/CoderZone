create table USER
(
	ID INT auto_increment,
	ACCOUNT_ID VARCHAR(100),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
	NAME VARCHAR(50),
	TOKEN CHAR(36),
	constraint USER_PK
		primary key (ID)
);
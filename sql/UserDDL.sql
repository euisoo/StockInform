DROP TABLE member;

CREATE TABLE member (
       id			VARCHAR2(20),
       password		VARCHAR2(20) NOT NULL,
       name         VARCHAR2(20) NOT NULL,
       CONSTRAINT member_id_pk PRIMARY KEY (id)
);



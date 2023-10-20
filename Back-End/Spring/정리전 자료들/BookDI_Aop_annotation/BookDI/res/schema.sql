create database ssafyweb;
use ssafyweb;

CREATE TABLE book (
  isbn 			char(12) NOT NULL,
  title 		varchar(100) NOT NULL,
  author 	varchar(50) NOT NULL,
  price 		int NOT NULL,
  describ text,
  img varchar(100) DEFAULT NULL,
  PRIMARY KEY (isbn)
);


CREATE TABLE user (
  id   varchar(50),
  name varchar(45) NOT NULL,
  pass varchar(100) NOT NULL,
  PRIMARY KEY (id)
);

insert into book(isbn, title,author, price,  describ)
values('11111','재미있는 BackEnd ㅜ.ㅜ','kdg',30000,'참 재미있죠~잉!');
insert into user (id, name, pass) values('ssafy','홍싸피','1234');

select * from user;
commit;
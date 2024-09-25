-- create database examdb;
use examdb;
/*
	private int no;
	private String title;
	private String writer;
	private String content;
	private int viewCnt;
*/
create table board (
	no int auto_increment,
    title varchar (300) not null,
    writer varchar(30) not null,
    content varchar(1000) not null,
    view_cnt int default 0,-- 보통 캐멀 표기로 하지 않고 언더바를 줌
    reg_date TIMESTAMP default CURRENT_TIMESTAMP, -- 등록일  
	primary key(no)
);







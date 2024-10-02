create database examdb;
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
    title varchar(200) not null,
    writer varchar(30) not null,
    content varchar(1000) not null,
    view_cnt int default 0,
    reg_date TIMESTAMP default CURRENT_TIMESTAMP,
	primary key(no)
);
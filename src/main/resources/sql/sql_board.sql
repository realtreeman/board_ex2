drop table if exists board_tbl;

create table board_tbl(
	bno int auto_increment primary key,
    title varchar(300) not null,
    content text not null,
    writer varchar(50) not null,
    regDate timestamp default current_timestamp,
    updateDate timestamp default current_timestamp
);

insert into board_tbl(title,content,writer)
values('게시물 제목입니다.','집에 가고싶어요.','언제가나요');
insert into board_tbl(title,content,writer)
values('게시물 제목입니다.2','집에 가고싶어요.2','언제가나요2');
insert into board_tbl(title,content,writer)
values('게시물 제목입니다.3','집에 가고싶어요.3','언제가나요3');
insert into board_tbl(title,content,writer)
values('게시물 제목입니다.4','집에 가고싶어요.4','언제가나요4');



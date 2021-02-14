--테이블 삭제
drop table rboard;

--시퀀스 삭제
drop sequence seq_rno;

--테이블 생성
create table rboard(
    no number,
    user_no number not null,
    title varchar2(500),
    content varchar2(4000),
    hit number,
    reg_date date,
    group_no number DEFAULT NULL,
    order_no number DEFAULT NULL,
    depth number DEFAULT NULL,
    primary key(no),
    foreign key(user_no)
    );
    
--시퀀스 생성
create sequence seq_rno
INCREMENT by 1
start with 1;

commit;
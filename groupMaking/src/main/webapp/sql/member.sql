create table member (
  mem_num number not null,
  mem_id varchar2(20) unique not null,
  mem_auth number,
  constraint member_pk primary key (mem_num)
);

create table member_detail(
    mem_num number not null,
    mem_id VARCHAR2(20) not null,
    mem_gender number not null,
    mem_name VARCHAR2(15) not null,
    mem_pw VARCHAR2(15) not null,
    mem_phone VARCHAR2(15) not null,
    mem_email VARCHAR2(50) not null,
    mem_zipcode VARCHAR2(7) not null,
    mem_addr1 VARCHAR2(100),
    mem_addr2 VARCHAR2(100),
    mem_intro clob,
    mem_date DATE,
    mem_black number,
    constraint mem_detail_pk primary key (mem_num),
    constraint mem_detail_fk foreign key(mem_num) references member (mem_num)
);

create sequence member_seq;
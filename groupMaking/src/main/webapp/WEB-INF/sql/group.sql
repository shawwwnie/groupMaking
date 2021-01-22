CREATE TABLE GROUP_SUM (
	group_num number not null,
	group_admin varchar2(20) not null,
	group_name varchar2(30) not null,
	constraint group_pk primary key (group_num),
	constraint group_fk foreign key (group_admin) references member (mem_id)
);
create table group_detail(
	group_num number not null,
	group_name varchar2(30) not null,
	group_intro varchar2(500),
	group_location varchar2(30),
	group_required varchar2(100),
	group_time varchar2(100),
	group_start number not null,
	constraint group_detail_pk primary key (group_num),
	constraint group_detail_fk foreign key (group_num) references group_sum (group_num)
);

create sequence group_seq;


create table group_board(
	board_num number not null,
	group_num number not null,
	mem_num number not null,
    board_title varchar2(100),
	board_content varchar2(300),
	board_file blob,
	board_filename varchar2(300),
	board_location varchar2(300),
	board_limit date,
	board_date date not null,
	constraint group_board_pk primary key(board_num),
	constraint group_board_groupfk foreign key (group_num) references group_sum (group_num),
	constraint group_board_memfk foreign key (mem_num) references member (mem_num)	
);
create sequence board_seq;

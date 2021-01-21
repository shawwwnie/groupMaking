CREATE TABLE GROUP_SUM (
	group_num number not null,
	group_admin number not null,
	group_name varchar2(30) not null,
	constraint group_pk primary key (group_num),
	constraint group_fk foreign key (group_admin) references member (mem_num)
);

create sequence group_seq;

create table member_group(
	mem_num number not null,
	mem_like number not null,
	mem_group number not null,
	mem_likeGroup number not null,
	mem_wantGroup number not null,
	constraint mem_group_numfk foreign key (mem_num) references member (mem_num),
	constraint mem_group_groupfk foreign key (mem_group) references group_sum (group_num),
	constraint mem_group_likefk foreign key (mem_likeGroup) references group_sum (group_num),
	constraint mem_group_wantfk foreign key (mem_wantGroup) references group_sum (group_num)
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

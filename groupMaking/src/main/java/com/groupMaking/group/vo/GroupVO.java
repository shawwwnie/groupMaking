package com.groupMaking.group.vo;

import java.sql.Blob;
import java.sql.Date;

public class GroupVO {
	//그룹번호
	private String group_num;
	//그룹 관리자 번호
	private String group_admin;
	//그룹 이름
	private String group_name;
	//회원번호
	private String mem_num;
	//회원관심사
	private String mem_like;
	//회원이 가입한 그룹
	private String mem_group;
	//회원이 즐겨찾는 그룹
	private String mem_likeGroup;
	//회원이 관심있는 그룹
	private String mem_wantGroup;
	//그룹 소개
	private String group_intro;
	//그룹 지역
	private String group_location;
	//그룹 모집기준
	private String group_required;
	//그룹 활동시간
	private String group_time;
	//시작 여부
	private String group_start;
	//그룹내 게시판 글번호
	private String board_num;
	//그룹내 게시판 글제목
	private String board_title;
	//그룹내 게시판 작성글 내용
	private String board_content;
	//그룹내 게시판 업로드 파일
	private Blob board_file;
	//그룹내 게시판 글 장소
	private String board_location;
	//그룹내 게시판 등롤한 날짜 기한
	private Date board_limit;
	//작성시간
	private Date board_date;
	
	
	public String getGroup_num() {
		return group_num;
	}
	public void setGroup_num(String group_num) {
		this.group_num = group_num;
	}
	public String getGroup_admin() {
		return group_admin;
	}
	public void setGroup_admin(String group_admin) {
		this.group_admin = group_admin;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getMem_num() {
		return mem_num;
	}
	public void setMem_num(String mem_num) {
		this.mem_num = mem_num;
	}
	public String getMem_like() {
		return mem_like;
	}
	public void setMem_like(String mem_like) {
		this.mem_like = mem_like;
	}
	public String getMem_group() {
		return mem_group;
	}
	public void setMem_group(String mem_group) {
		this.mem_group = mem_group;
	}
	public String getMem_likeGroup() {
		return mem_likeGroup;
	}
	public void setMem_likeGroup(String mem_likeGroup) {
		this.mem_likeGroup = mem_likeGroup;
	}
	public String getMem_wantGroup() {
		return mem_wantGroup;
	}
	public void setMem_wantGroup(String mem_wantGroup) {
		this.mem_wantGroup = mem_wantGroup;
	}
	public String getGroup_intro() {
		return group_intro;
	}
	public void setGroup_intro(String group_intro) {
		this.group_intro = group_intro;
	}
	public String getGroup_location() {
		return group_location;
	}
	public void setGroup_location(String group_location) {
		this.group_location = group_location;
	}
	public String getGroup_required() {
		return group_required;
	}
	public void setGroup_required(String group_required) {
		this.group_required = group_required;
	}
	public String getGroup_time() {
		return group_time;
	}
	public void setGroup_time(String group_time) {
		this.group_time = group_time;
	}
	public String getGroup_start() {
		return group_start;
	}
	public void setGroup_start(String group_start) {
		this.group_start = group_start;
	}
	public String getBoard_num() {
		return board_num;
	}
	public void setBoard_num(String board_num) {
		this.board_num = board_num;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Blob getBoard_file() {
		return board_file;
	}
	public void setBoard_file(Blob board_file) {
		this.board_file = board_file;
	}
	public String getBoard_location() {
		return board_location;
	}
	public void setBoard_location(String board_location) {
		this.board_location = board_location;
	}
	public Date getBoard_limit() {
		return board_limit;
	}
	public void setBoard_limit(Date board_limit) {
		this.board_limit = board_limit;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	
	
	@Override
	public String toString() {
		return "GroupVO [group_num=" + group_num + ", group_admin=" + group_admin + ", group_name=" + group_name
				+ ", mem_num=" + mem_num + ", mem_like=" + mem_like + ", mem_group=" + mem_group + ", mem_likeGroup="
				+ mem_likeGroup + ", mem_wantGroup=" + mem_wantGroup + ", group_intro=" + group_intro
				+ ", group_location=" + group_location + ", group_required=" + group_required + ", group_time="
				+ group_time + ", group_start=" + group_start + ", board_num=" + board_num + ", board_title="
				+ board_title + ", board_content=" + board_content + ", board_location=" + board_location
				+ ", board_limit=" + board_limit + ", board_date=" + board_date + "]";
	}
	
	
	
	
	
}

package com.groupMaking.member.vo;

import javax.validation.constraints.Pattern;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

public class MemberVO {
	//회원번호
	private String mem_num;
	//회원 등급
	private String mem_auth;
	//아이디
	@Pattern(regexp="^[A-Za-z0-9+]{4,10}$")
	@NotEmpty
	private String mem_id;
	//성별
	@NotEmpty
	private String mem_gender;
	//이름
	@NotEmpty
	private String mem_name;
	//비밀번호
	@NotEmpty
	private String mem_pw;
	//전화번호
	@NotEmpty
	private String mem_phone;
	//이메일
	@NotEmpty
	private String mem_email;
	//우편번호
	private String mem_zipcode;
	//주소
	private String mem_addr1;
	//상세주소
	private String mem_addr2;
	//자기소개
	private String mem_intro;
	//가입일
	private Date mem_date;
	//신고당한 횟수
	private String mem_black;
	
	/*@@@@@@@@@@ Getter&Setter @@@@@@@@@@@@*/
	public String getMem_num() {
		return mem_num;
	}
	public void setMem_num(String mem_num) {
		this.mem_num = mem_num;
	}
	public String getMem_auth() {
		return mem_auth;
	}
	public void setMem_auth(String mem_auth) {
		this.mem_auth = mem_auth;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_gender() {
		return mem_gender;
	}
	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_zipcode() {
		return mem_zipcode;
	}
	public void setMem_zipcode(String mem_zipcode) {
		this.mem_zipcode = mem_zipcode;
	}
	public String getMem_addr1() {
		return mem_addr1;
	}
	public void setMem_addr1(String mem_addr1) {
		this.mem_addr1 = mem_addr1;
	}
	public String getMem_addr2() {
		return mem_addr2;
	}
	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
	}
	public String getMem_intro() {
		return mem_intro;
	}
	public void setMem_intro(String mem_intro) {
		this.mem_intro = mem_intro;
	}
	public Date getMem_date() {
		return mem_date;
	}
	public void setMem_date(Date mem_date) {
		this.mem_date = mem_date;
	}
	public String getMem_black() {
		return mem_black;
	}
	public void setMem_black(String mem_black) {
		this.mem_black = mem_black;
	}
	
	/*@@@@@@@@@@ toString @@@@@@@@@@@@*/
	@Override
	public String toString() {
		return "MemberVO [mem_num=" + mem_num + ", mem_auth=" + mem_auth + ", mem_id=" + mem_id + ", mem_gender="
				+ mem_gender + ", mem_name=" + mem_name + ", mem_pw=" + mem_pw + ", mem_phone=" + mem_phone
				+ ", mem_email=" + mem_email + ", mem_zipcode=" + mem_zipcode + ", mem_addr1=" + mem_addr1
				+ ", mem_addr2=" + mem_addr2 + ", mem_intro=" + mem_intro + ", mem_date=" + mem_date + ", mem_black="
				+ mem_black + "]";
	}
	
	
	
}

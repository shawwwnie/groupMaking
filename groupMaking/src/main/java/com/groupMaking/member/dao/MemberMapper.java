package com.groupMaking.member.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.groupMaking.member.vo.MemberVO;

public interface MemberMapper {
	
	/*********** 회원가입 ************/
	//회원번호 정하기
	@Select("SELECT member_seq.nextval FROM dual")
	public String selectMem_num();
	//member테이블에 입력하기
	@Insert("INSERT INTO member (mem_num, mem_id, mem_auth) VALUES (#{mem_num},#{mem_id},1)")
	public void insertMember(MemberVO membervo);
	//member_detail 테이블에 입력하기
	@Insert("INSERT INTO member_detail(mem_num,mem_id,mem_gender,mem_name,mem_pw,mem_phone,mem_email,mem_zipcode,mem_addr1,mem_addr2,mem_intro,mem_date,mem_black)"
			+ "VALUES(#{mem_num},#{mem_id},#{mem_gender},#{mem_name},#{mem_pw},#{mem_phone},#{mem_email},#{mem_zipcode},#{mem_addr1},#{mem_addr2},#{mem_intro},SYSDATE,0)")
	public void insertMember_detail(MemberVO membervo);
	
	/*********** 회원가입 ************/
	/*********** 회원정보찾기 ************/
	//아이디 중복체크,로그인 사용 가능
	//매개변수를 아이디만 주기
	@Select("SELECT * FROM member_detail WHERE mem_id=#{mem_id}")
	public MemberVO login(String mem_id);
	
	//회원 전체정보 불러오기
	//매개변수를 mem_num으로 받기
	
	//id찾기
	//매개변수를 @@@랑@@@로 받기
	
	//비밀번호 찾기
	//매개변수를 아이디랑 @@@로 받기
	
	//회원의 블랙 숫자 추가하기
	@Update("UPDATE member_detail SET mem_black=mem_black+1 WHERE mem_num=#{mem_num}")
	public void updateBlack(String mem_num);
	
	/*********** 회원정보찾기 ************/
	
	/*********** 그룹 가입여부 확인 메서드 ************/
	@Select("SELECT * FROM member_group WHERE mem_num=#{mem_num} AND mem_group=#{mem_group}")
	public MemberVO checkRegister(Map<String,Object> map);
	/*********** 그룹 가입하는 메서드 ************/
	@Insert("INSERT INTO member_group(mem_num,mem_group) VALUES(#{mem_num},#{mem_group})")
	public void registerGroup(MemberVO membervo);
	
	
	
	
}

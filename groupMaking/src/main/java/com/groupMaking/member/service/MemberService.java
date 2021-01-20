package com.groupMaking.member.service;

import java.util.Map;

import com.groupMaking.member.vo.MemberVO;

public interface MemberService {
	/*
	 * 회원가입 관련 사이클 묶기
	 * selectMem_num(); ->시퀀스에서 회원번호 불러오기
	 * insertMember(MemberVO membervo); -> 멤버테이블에 넣기
	 * insertMember_detail(MemberVO membervo); -> 회원 상세정보 넣기
	 */
	public void insertMember_detail(MemberVO membervo);
	
	//로그인, 아이디 중복체크 시 사용하는 메서드
	public MemberVO login(String mem_id);
	
	//그룹 가입하는 메서드
	public void registerGroup(MemberVO membervo);
	
	//그룹 가입여부 확인 메서드
	public MemberVO checkRegister(Map<String,Object> map);
	
}

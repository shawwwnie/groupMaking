package com.groupMaking.member.service;

import com.groupMaking.member.vo.MemberVO;

public interface MemberService {
	/*
	 * 회원가입 관련 사이클 묶기
	 * selectMem_num(); ->시퀀스에서 회원번호 불러오기
	 * insertMember(MemberVO membervo); -> 멤버테이블에 넣기
	 * insertMember_detail(MemberVO membervo); -> 회원 상세정보 넣기
	 */
	public void insertMember_detail(MemberVO membervo);
	
	
}

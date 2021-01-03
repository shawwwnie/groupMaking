package com.groupMaking.member.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.groupMaking.member.dao.MemberMapper;
import com.groupMaking.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Resource
	private MemberMapper memberMapper;
	
	//회원가입하는 메서드
	@Override
	public void insertMember_detail(MemberVO membervo) {
		//3개 전부 성공해야지 커밋, 아님 rollback
		//시퀀스에서 mem_num 받아온것을 mem_num에 넣기
		membervo.setMem_num(memberMapper.selectMem_num());
		System.out.println("selectMem_num()의 결과 : " + membervo.getMem_num());
		//member 테이블에 회원정보 넣기
		memberMapper.insertMember(membervo);
		System.out.println("insertMember 메서드 실행 성공");
		//member_detail 테이블에 회원정보 넣기
		memberMapper.insertMember_detail(membervo);
		System.out.println("insertMember_detail() 메서드 실행 성공");
	}

}

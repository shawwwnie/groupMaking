package com.groupMaking.group.service;

import java.util.List;
import java.util.Map;

import com.groupMaking.group.vo.GroupVO;
import com.groupMaking.member.vo.MemberVO;

public interface GroupService {
	/*
	 * 그룹만들기 관련 사이클 묶기
	 * public String selectGroup_num(); ->시퀀스에서 그룹번호 불러오기
	 * public void insertGroup_sum(GroupVO groupvo); -> 그룹테이블에 넣기
	 * public void insertGroup_detail(GroupVO groupvo); -> 그룹 상세정보 넣기
	 */
	public void insertGroup_detail(GroupVO groupvo);
	
	//게시판 리스트 호출
	public List<GroupVO> allGroupList(Map<String,Object> map);
	//게시판 글 갯수 카운팅
	public int selectCount(Map<String,Object> map);
	//그룹 디테일 불러오기
	public GroupVO selectGroup_detail(String group_num);
	//그룹 가입여부 확인하기
	public MemberVO selectMember_group(MemberVO memberVO);
	//그룹 가입한 회원 불러오기
	public List<GroupVO> selectGroup_member(String group_num);
	/*게시판 입력관련 사이클 묶기(보드 번호 받기 + 보드 내용 작성)*/
	public void insertGroup_board(GroupVO groupVO);
	
	//게시판 내용 불러오기
	public List<GroupVO> selectGroup_board(String group_num);
	
	//게시판 디테일 불러오기
	public GroupVO selectBoard_detail(String board_num);
}

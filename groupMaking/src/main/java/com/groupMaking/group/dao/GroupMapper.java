package com.groupMaking.group.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.groupMaking.group.vo.GroupVO;
import com.groupMaking.member.vo.MemberVO;

public interface GroupMapper {
	/************ 그룹 만들기 **************/
	//그룹번호 정하기
	@Select("SELECT group_seq.nextval FROM dual")
	public String selectGroup_num();
	
	//그룹 만들기 사이클 시작
	//1. group_sum 테이블 입력
	@Insert("INSERT INTO group_sum (group_num, group_admin, group_name) VALUES (#{group_num}, #{group_admin}, #{group_name})")
	public void insertGroup_sum(GroupVO groupvo);
	//2. group_detail 테이블 입력
	//시작여부는 시작전으로 고정
	@Insert("INSERT INTO group_detail (group_num, group_name, group_intro, group_location, group_required, group_time, group_start) VALUES (#{group_num}, #{group_name}, #{group_intro}, #{group_location}, #{group_required}, #{group_time}, 1)")
	public void insertGroup_detail(GroupVO groupvo);
	
	/********** 그룹 리스트 불러오기 ***************/
	//여기는 검색조건 추가해야해서 xml에 sql문 넣음
	public List<GroupVO> allGroupList(Map<String,Object> map);
	public int selectCount(Map<String,Object> map);
	
	/********** 그룹 가입여부 확인하기 ***************/
	@Select("SELECT * FROM member_group where mem_num=#{mem_num} AND mem_group=#{mem_group}")
	public MemberVO selectMember_group(MemberVO memberVO);
	
	/********** 그룹 디테일 불러오기 ***************/
	@Select("SELECT * FROM group_detail d JOIN group_sum s ON d.group_num = s.group_num WHERE d.group_num = #{group_num}")
	public GroupVO selectGroup_detail(String group_num);
	
	/********** 그룹 가입한 멤버 불러오기 ***************/
	@Select("SELECT * FROM member_group g JOIN member m on g.mem_num = m.mem_num where mem_group = #{group_num}")
	public List<GroupVO> selectGroup_member(String group_num);
	
	/********** 그룹 탈퇴하기 ***************/
	@Delete("DELETE FROM member_group WHERE mem_num=#{mem_num} AND mem_group=#{mem_group}")
	public void groupExit(GroupVO groupVO);
	
	/********** 그룹내 게시판 관련 ***************/
	//게시판 번호 시퀀스로 받기
	@Select("SELECT board_seq.nextval FROM dual")
	public String selectBoard_num();
	//게시판 작성
	@Insert("INSERT INTO group_board (board_num, group_num, mem_num, board_title, board_content, board_file, board_filename, board_location, board_limit, board_date)"
			+ "VALUES (#{board_num}, #{group_num}, #{mem_num}, #{board_title}, #{board_content}, #{board_file}, #{board_filename}, #{board_location}, #{board_limit}, SYSDATE)")
	public void insertGroup_board(GroupVO groupVO);
	
	//해당그룹의 게시판에 작성된 리스트 불러오기
	@Select("SELECT * FROM group_board b join member m ON b.mem_num = m.mem_num WHERE b.group_num = #{group_num} ORDER BY b.board_date DESC")
	public List<GroupVO> selectGroup_board(String group_num);
	
	//게시판 디테일 불러오기
	@Select("SELECT * FROM group_board b join member m ON b.mem_num = m.mem_num WHERE b.board_num = #{board_num}")
	public GroupVO selectBoard_detail(String board_num);
	
}

package com.groupMaking.group.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.groupMaking.group.vo.GroupVO;

public interface GroupMapper {
	/************ 그룹 만들기 **************/
	//그룹번호 정하기
	@Select("SELECT group_seq.nextval FROM daul")
	public String selectGroup_num();
	
	//그룹 만들기 사이클 시작
	//1. group_sum 테이블 입력
	@Insert("INSERT INTO group_sum (group_num, group_admin, group_name) VALUES (#{group_num}, #{mem_num}, #{group_name})")
	public void insertGroup_sum(GroupVO groupvo);
	//2. group_detail 테이블 입력
	//시작여부는 시작전으로 고정
	@Insert("INSERT INTO group_detail (group_num, group_name, group_intro, group_location, group_required, group_time, group_start) VALUES (#{group_num}, #{group_name}, #{group_intro}, #{group_location}, #{group_required}, #{group_time}, 1")
	public void insertGroup_detail(GroupVO groupvo);
	
}

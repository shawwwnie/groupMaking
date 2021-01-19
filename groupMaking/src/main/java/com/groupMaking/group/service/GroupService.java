package com.groupMaking.group.service;

import com.groupMaking.group.vo.GroupVO;

public interface GroupService {
	/*
	 * 그룹만들기 관련 사이클 묶기
	 * public String selectGroup_num(); ->시퀀스에서 그룹번호 불러오기
	 * public void insertGroup_sum(GroupVO groupvo); -> 그룹테이블에 넣기
	 * public void insertGroup_detail(GroupVO groupvo); -> 그룹 상세정보 넣기
	 */
	public void insertGroup_detail(GroupVO groupvo);
}

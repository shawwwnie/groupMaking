package com.groupMaking.group.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.groupMaking.group.dao.GroupMapper;
import com.groupMaking.group.vo.GroupVO;


@Service("groupService")
public class GroupServiceImpl implements GroupService{
	
	@Resource
	private GroupMapper groupMapper;
	
	//
	@Override
	public void insertGroup_detail(GroupVO groupvo) {
		/*
		3개 전부 성공해야지 커밋, 아님 롤백
		 */
		//group_num을 시퀀스에서 받아와서 groupVO에 넣기
		groupvo.setGroup_num(groupMapper.selectGroup_num());
		System.out.println("selectGroup_number 결과 : " + groupvo.getGroup_num());
		//group_sum 테이블에 내용 넣기
		groupMapper.insertGroup_sum(groupvo);
		System.out.println("insertGroup_sum 메서드 실행 성공");
		//group_detail 테이블에 내용 넣기
		groupMapper.insertGroup_detail(groupvo);
		System.out.println("insertGroup_detail 메서드 실행 성공");
	}

	@Override
	public List<GroupVO> allGroupList(Map<String, Object> map) {
		System.out.println("그룹불러오기 메서드 진입");
		return groupMapper.allGroupList(map);
	}

	@Override
	public int selectCount(Map<String, Object> map) {
		System.out.println("그룹 갯수 카운팅 메서드 진입");
		return groupMapper.selectCount(map);
	}

}

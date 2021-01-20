package com.groupMaking.group.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupMaking.group.service.GroupService;
import com.groupMaking.group.vo.GroupVO;
import com.groupMaking.member.vo.MemberVO;
import com.groupMaking.util.PagingUtil;

@Controller
public class GroupController {
	
	@Resource
	private GroupService groupService;
	
	private int rowCount = 10;
	
	//자바빈 초기화
	@ModelAttribute
	public GroupVO initCommand() {
		return new GroupVO();
	}
	
	//그룹 리스트 호출
	@RequestMapping(value = "/group/groupList.do", method = RequestMethod.GET)
	public String groupList() {
		//그룹리스트 페이지 호출
		return "group/groupList";
	}
	//그룹 목록 불러오기
	@RequestMapping("/group/groupListAjax.do")
	@ResponseBody
	public Map<String,Object> getGroupList(@RequestParam(value="pageNum",defaultValue="1") int currentPage, HttpSession session, Model model){
		System.out.println("목록불러오기 ajax 진입");
		List<GroupVO> list = null;
		
		MemberVO member = (MemberVO)session.getAttribute("user");
		int sessionMem_num = Integer.parseInt(member.getMem_num());
		
		int count = 0;
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mem_num", sessionMem_num);
		
		count = groupService.selectCount(map);
		
		System.out.println("총 글의 갯수 : " + count);
		//paging 처리
		PagingUtil page = new PagingUtil(currentPage, count, rowCount, 10, "groupList.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		//모든 그룹 list에 담기
		list = groupService.allGroupList(map);
		System.out.println("list에 담긴 글 목록 : " + list);
		
		Map<String,Object> hashMap = new HashMap<String, Object>();
		hashMap.put("list", list);
		hashMap.put("count", count);
		hashMap.put("rowCount", rowCount);
		
		return hashMap;
		
	}
	
	//그룹 만들기 페이지 호출
	@RequestMapping(value = "/group/groupMake.do", method = RequestMethod.GET)
	public String groupMake() {
		//그룹만들기 페이지 호출
		return "group/groupMake";
	}
	
	//그룹 만들기
	@RequestMapping(value="/group/makeGroup.do", method=RequestMethod.POST)
	public String makeGroup(@Valid GroupVO groupVO,  BindingResult result, Model
	model, HttpServletRequest request, HttpSession session) {
		System.out.println("그룹만들기 메서드 진입");
		//로그인한 회원의 정보를 user 이름으로 세션이 넣기
		MemberVO member = (MemberVO)session.getAttribute("user");
		System.out.println("로그인한 회원 정보 : " + member);
		
		//로그인한 사람의 mem_num을 그룹 관리자 mem_num으로 지정
		groupVO.setGroup_admin(member.getMem_num());
		
		System.out.println("입력받은 : " + groupVO);
		//그룹만들기 메서드 실행
		groupService.insertGroup_detail(groupVO);
		
		System.out.println("그룹만들기 성공");
		//일단은 그룹리스트로 넣음, 나중에 만든 그룹으로 이동하기
		return "group/groupList";
	}
	
	
	
}

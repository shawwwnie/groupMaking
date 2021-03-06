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
import org.springframework.web.servlet.ModelAndView;

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
		System.out.println("그룹 리스트 페이지 호출 메서드 진입");
		return "group/groupList";
	}
	//그룹 목록 불러오기
	@RequestMapping("/group/groupListAjax.do")
	@ResponseBody
	public Map<String,Object> getGroupList(@RequestParam(value="pageNum",defaultValue="1") int currentPage, HttpSession session){
		System.out.println("목록불러오기 ajax 진입");
		List<GroupVO> list = null;
		
		int count = 0;
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		
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
	
	//그룹 탈퇴하는 메서드
	@RequestMapping(value="/group/groupExit.do", method=RequestMethod.GET)
	public String groupExit(@RequestParam String group_num, String mem_num){
		System.out.println("그룹 탈퇴 메서드 진입");
		//매개변수 그룹VO
		GroupVO groupVO = new GroupVO();
		groupVO.setMem_num(mem_num);
		groupVO.setMem_group(group_num);
		
		groupService.groupExit(groupVO);
		return "group/groupList";
	}
	//그룹 검색목록 불러오기
	@RequestMapping("/group/groupListSearch.do")
	@ResponseBody
	public ModelAndView getGroupListSearch(@RequestParam(value="pageNum",defaultValue="1") int currentPage, 
			@RequestParam(value="keyfield",defaultValue="") String keyfield,
			@RequestParam(value="keyword",defaultValue="") String keyword,
			@RequestParam(value="rowCount",defaultValue="10") int rowCount,
			HttpSession session, Model model){
		System.out.println("검색 목록불러오기 메서드 진입");
		List<GroupVO> list = null;
		
		
		int count = 0;
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		count = groupService.selectCount(map);
		
		System.out.println("검색된 글의 갯수 : " + count);
		//paging 처리
		PagingUtil page = new PagingUtil(currentPage, count, rowCount, 10, "groupListSearch.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		//모든 그룹 list에 담기
		list = groupService.allGroupList(map);
		System.out.println("list에 담긴 글 목록 : " + list);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("group/groupList_search");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("rowCount", rowCount);
		
		return mav;
		
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
	//그룹 디테일 페이지 호출
	@RequestMapping(value="/group/groupDetail.do", method=RequestMethod.GET)
	public ModelAndView groupDetail(@RequestParam String group_num, HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("그룹 입장하기 메서드 진입");
		//로그인한 회원 정보를 user에 넣기
		MemberVO member = (MemberVO)session.getAttribute("user");
		//member에 현재 그룹의 그룹번호 넣기
		member.setMem_group(group_num);
		//그룹 가입여부 확인하는 메서드 실행후 member2에 정보 담기
		MemberVO member2 = groupService.selectMember_group(member);
		//ModelAndView 객체 생성
		ModelAndView mav = new ModelAndView();
		if(member2 == null) {
			System.out.println(group_num + "번 그룹은 가입하지 않은 그룹");
			mav.setViewName("group/groupList");
			return mav;
		}else {
			System.out.println(group_num + "번 그룹은 가입한 그룹");
			//가입한 그룹 디테일 얻기
			GroupVO groupVO = groupService.selectGroup_detail(group_num);
			//가입한 그룹 멤버를 list 형식으로 members에 넣기
			List<GroupVO> members = null;
			members = groupService.selectGroup_member(group_num);
			//그룹 리스트를 list 형식으로 board에 넣기
			List<GroupVO> board = null;
			board = groupService.selectGroup_board(group_num);
			//mav에 각 ("jsp로 보낼 이름", 여기에 받아온 이름) 형식으로 넣기
			mav.setViewName("group/groupDetail");
			mav.addObject("group", groupVO);
			mav.addObject("board",board);
			mav.addObject("members", members);
			mav.addObject("user", member);
			return mav;
		}
	}
	
	//그룹 게시글 디테일 호출 메서드
	@RequestMapping(value="/group/groupBoardDetail.do", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView boardDetail(@RequestParam String board_num, HttpSession session) {
		System.out.println("디테일 호출 메서드 진입");
		MemberVO member = (MemberVO)session.getAttribute("user");
		System.out.println("전달받은 board_num : " + board_num);
		
		GroupVO detail = groupService.selectBoard_detail(board_num);
		System.out.println("쿼리문 결과 : " + detail);
		//ModelAndView 객체 생성
		ModelAndView mav = new ModelAndView();
		//mav에 쿼리문 결과값 받아오기
		mav.setViewName("group/groupBoard_detail");
		mav.addObject("detail", detail);
		return mav;
	}
	
	//그룹 게시판 글 작성 페이지 호출메서드
	@RequestMapping(value="/group/groupBoardWrite.do", method=RequestMethod.GET)
	public ModelAndView boardWriteView(@RequestParam String group_num, HttpSession session) {
		//게시판 글 작성 페이지 호출
		System.out.println("게시판 작성 페이지 호출");
		MemberVO member = (MemberVO)session.getAttribute("user");
		System.out.println("group_num : " + group_num);
		GroupVO group = new GroupVO();
		//로그인한 회원의 memnum group에 셋팅
		group.setMem_num(member.getMem_num());
		//페이지로 전달할 groupNum 세팅
		group.setGroup_num(group_num);
		//ModelAndView 객체 생성
		ModelAndView mav = new ModelAndView();
		mav.setViewName("group/groupBoardWrite");
		mav.addObject("writer", group);
		
		return mav;
	}
	
	//그룹게시판 글 작성 메서드
	@RequestMapping(value="/group/groupBoardWrite.do", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView boardWrite(@Valid GroupVO groupVO, HttpSession session) {
		System.out.println("게시판 글 작성 메서드 진입");
		//로그인한 회원 정보를 user에 넣기
		MemberVO member = (MemberVO)session.getAttribute("user");
		groupVO.setMem_num(member.getMem_num());
		groupVO.setMem_id(member.getMem_id());
		System.out.println("전달받은 내용 : " + groupVO);
		groupService.insertGroup_board(groupVO);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("group/groupBoard_detail");
		mav.addObject("detail", groupVO);
		return mav;
	}
	
	
	
	//이미지 출력을 위한 메서드
	@RequestMapping("/group/imageView.do")
	public ModelAndView viewImage(@RequestParam String board_num) {
		System.out.println("이미지 출력 메서드 진입");
		System.out.println("전달받은 board_num : " + board_num);
		GroupVO detail = groupService.selectBoard_detail(board_num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile", detail.getBoard_file());
		mav.addObject("filename", detail.getBoard_filename());
		System.out.println("board_file : " + detail.getBoard_file());
		System.out.println("board_filename : " + detail.getBoard_filename());
		System.out.println("mav에 담긴 내용 : " + mav);
		return mav;
	}
	
}

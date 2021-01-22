package com.groupMaking.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.groupMaking.group.service.GroupService;
import com.groupMaking.group.vo.GroupVO;
import com.groupMaking.main.HomeController;
import com.groupMaking.member.service.MemberService;
import com.groupMaking.member.vo.MemberVO;
import com.groupMaking.util.LoginCheckException;


@Controller
public class MemberController {

    
	@Resource
	private MemberService memberService;
	
	@Resource
	private GroupService groupService;

	private HomeController homeController;
	
	private GroupVO groupVO;

	// 자바빈(VO) 초기화
	// 서버 유효성 체크시 필수로 필요
	@ModelAttribute
	public MemberVO initCommand() {
		return new MemberVO();
	}

	// 회원가입 
	@RequestMapping(value="/member/signUp.do", method=RequestMethod.POST) public
	String submitSignUp(@Valid MemberVO memberVO, BindingResult result, Model
	model, HttpServletRequest request) {
		  
		//System.out.println("memberController 진입");
		//System.out.println("memberVO : " + memberVO); //유효성 체크 결과 오류가 있으면 폼 호출
		  
		//if(result.hasErrors()) { return homeController.home(); }
		  
		
		//유효성 체크 결과 오류가 없으면 쿼리작업 
		memberService.insertMember_detail(memberVO);
		System.out.println("memberVO : " + memberVO); //회원가입 후 메인페이지 진입 
		return "main/main"; 
	}
	 

	//안드로이드용 회원가입
	@RequestMapping(value = "/member/signUpAndroid.do", method = RequestMethod.POST)
	public void submitSignUpAndroid(@Valid MemberVO memberVO, BindingResult result, Model model,
			HttpServletRequest request) {

		// System.out.println("memberController 진입");
		// System.out.println("memberVO : " + memberVO);
		// 유효성 체크 결과 오류가 있으면 폼 호출
		/*
		 * if(result.hasErrors()) { return homeController.home(); }
		 */

		// 유효성 체크 결과 오류가 없으면 쿼리작업
		memberService.insertMember_detail(memberVO);
		System.out.println("memberVO : " + memberVO);
		// 회원가입 후 메인페이지 진입
	}
	//로그인 메서드
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public String submitLogin(@Valid MemberVO memberVO, BindingResult result, HttpSession session,
			HttpServletResponse response, Model model) {
		        
		try {
			
			MemberVO member = memberService.login(memberVO.getMem_id());

			// DB에서 가져온 비밀번호랑 일치하는지 확인
			if (member.getMem_pw().equals(memberVO.getMem_pw())) {
				// 세션에 user로 로그인한 회원의 디테일 저장
				session.setAttribute("user", member);
				System.out.println("로그인 성공");
				// 로그인 후 메인페이지로 이동
				return "redirect:/main/main.do";
			} else {
				throw new LoginCheckException();
			}

		} catch (LoginCheckException e) {
			System.out.println("로그인 실패");
			return "main/main";
		}

	}
	
	//안드로이드용 로그인
	@RequestMapping(value = "/member/loginAndroid.do", method = RequestMethod.POST)
	public void submitLoginAndroid(@Valid MemberVO memberVO, BindingResult result, HttpSession session,
			HttpServletResponse response, Model model) {
		
		
		try {
			MemberVO member = memberService.login(memberVO.getMem_id());
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();

			System.out.println(member);
			// DB에서 가져온 비밀번호랑 체크
			if (member.getMem_pw().equals(memberVO.getMem_pw())) {
				// 세션에 user로 로그인한 회원의 디테일 저장
				session.setAttribute("user", member);
				System.out.println("로그인 성공");
				
				 obj.put("result",0); //성공시 0
				
			} else {
				 obj.put("result",1);  //실패시 1
				throw new LoginCheckException();
				
			}
			out.print(obj.toString());
		} catch (Exception e) {
			System.out.println("로그인 실패");
						
		}
		
		

		
	}
	
	
	//그룹 가입 메서드
	@RequestMapping(value = "/member/registerGroup.do", method = RequestMethod.GET)
	public ModelAndView registerGroup(@RequestParam String group_num, HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("------그룹가입 메서드 진입------");
		System.out.println("해당 그룹의 그룹번호 : " + group_num);
		
		//세션에 있는 정보를 memberVO에 담기
		MemberVO member = (MemberVO)session.getAttribute("user");
		//클릭한 그룹의 그룹번호를 memberVO의 mem_group으로 세팅
		member.setMem_group(group_num);
		System.out.println("쿼리문 실행 전 member에 담긴 값 : " + member);
		
		//memberVO에 있는 정보로 member_group 테이블에 가입내용 작성
		memberService.registerGroup(member);
		//일단 list로 리턴 / 나중에 가입한 그룹 디테일로 넣기
		System.out.println(group_num + "번 그룹 가입완료");
		
		//가입한 그룹 디테일 얻기
		GroupVO groupVO = groupService.selectGroup_detail(group_num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("group/groupDetail");
		mav.addObject("group", groupVO);
		
		return mav;
	}
	
	//블랙 1 올리는 메서드
	@RequestMapping(value="/member/updateBlack.do", method=RequestMethod.GET)
	public ModelAndView updateBlack(@RequestParam String mem_num, @RequestParam String group_num, HttpSession session) {
		
		System.out.println("블랙 추가하는 메서드 진입");
		System.out.println("전달받은 mem_num : " + mem_num);
		memberService.updateBlack(mem_num);
		
		//로그인한 회원 정보를 user에 넣기
		MemberVO member = (MemberVO)session.getAttribute("user");
		//member에 현재 그룹의 그룹번호 넣기
		member.setMem_group(group_num);
		//가입한 그룹 디테일 얻기
		GroupVO groupVO = groupService.selectGroup_detail(group_num);
		//가입한 그룹 멤버를 list 형식으로 members에 넣기
		List<GroupVO> members = null;
		members = groupService.selectGroup_member(group_num);
		//그룹 리스트를 list 형식으로 board에 넣기
		List<GroupVO> board = null;
		board = groupService.selectGroup_board(group_num);
		ModelAndView mav = new ModelAndView();
		//mav에 각 ("jsp로 보낼 이름", 여기에 받아온 이름) 형식으로 넣기
		mav.setViewName("group/groupDetail");
		mav.addObject("group", groupVO);
		mav.addObject("board",board);
		mav.addObject("members", members);
		mav.addObject("user", member);
		return mav;
	}
}

package com.groupMaking.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.groupMaking.main.HomeController;
import com.groupMaking.member.service.MemberService;
import com.groupMaking.member.vo.MemberVO;

@Controller
public class MemberController {
		
	@Resource
	private MemberService memberService;
	
	private HomeController homeController;

	// 자바빈(VO) 초기화
	// 서버 유효성 체크시 필수로 필요
	@ModelAttribute
	public MemberVO initCommand() {
		return new MemberVO();
	}
	
	//회원가입
	@RequestMapping(value="/member/signUp1.do", method=RequestMethod.POST)
	public String submitSignUp(@Valid MemberVO memberVO, BindingResult result, Model model, HttpServletRequest request) {
		
		System.out.println("memberVO : " + memberVO);
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return homeController.home();
		}
		
		//유효성 체크 결과 오류가 없으면 쿼리작업
		memberService.insertMember_detail(memberVO);
		
		return "index";
	}
	
}

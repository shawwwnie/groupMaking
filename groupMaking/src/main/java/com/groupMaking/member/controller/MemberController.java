package com.groupMaking.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

import com.groupMaking.main.HomeController;
import com.groupMaking.member.service.MemberService;
import com.groupMaking.member.vo.MemberVO;
import com.groupMaking.util.LoginCheckException;


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

	// 회원가입 

	
	@RequestMapping(value="/member/signUp.do", method=RequestMethod.POST) public
	String submitSignUp(@Valid MemberVO memberVO, BindingResult result, Model
	model, HttpServletRequest request) {
		  
		//System.out.println("memberController 진입");
		//System.out.println("memberVO : " + memberVO); //유효성 체크 결과 오류가 있으면 폼 호출
		  
		//if(result.hasErrors()) { return homeController.home(); }
		  
		
		//유효성 체크 결과 오류가 없으면 쿼리작업 memberService.insertMember_detail(memberVO);
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
	
	//안드로이드용
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
}

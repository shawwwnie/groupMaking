package com.groupMaking.main;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.groupMaking.member.vo.MemberVO;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@ModelAttribute
	public MemberVO initCommand() {
		return new MemberVO();
	}
	
	@RequestMapping(value = "/main/main.do", method = RequestMethod.GET)
	public String main() {
		//회원가입 페이지 호출
		return "main/main";
	}
	
	@RequestMapping(value = "/member/signUp.do", method = RequestMethod.GET)
	public String signUp() {
		//회원가입 페이지 호출
		return "member/signUp";
	}
	
}

package com.groupMaking.group.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.groupMaking.group.vo.GroupVO;

@Controller
public class GroupController {
	
	//자바빈 초기화
	@ModelAttribute
	public GroupVO initCommand() {
		return new GroupVO();
	}
	
}

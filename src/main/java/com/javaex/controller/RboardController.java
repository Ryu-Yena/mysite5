package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.RboardService;
import com.javaex.vo.RboardVo;

@Controller
@RequestMapping(value="/rboard")
public class RboardController {
	
	//필드
	@Autowired
	private RboardService rboardService;
	
	//생성자
	//g/s
	
	//일반 메소드
	
	//게시판 리스트
	@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("/rboard/list");
		List<RboardVo> rboardList = rboardService.rboardList();
		
		model.addAttribute("rboardList", rboardList);
		
		return "/rboard/list";
	}

}

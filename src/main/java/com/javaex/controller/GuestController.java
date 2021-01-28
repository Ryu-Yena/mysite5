package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping(value="/guestbook")
public class GuestController {
	
	//필드
	
	@Autowired
	private GuestService guestService;
	
	//생성자
	//g/s
	
	//일반 메소드
	
	//방명록 리스트
	@RequestMapping(value="/addlist", method={RequestMethod.GET, RequestMethod.POST})
	public String guestList(Model model) {
		System.out.println("/guestbook/addlist");
		
		List<GuestVo> guestList = guestService.guestList();

		model.addAttribute("guestList", guestList);
		
		return "/guestbook/addList";
	}
	
	
	//방명록 등록
	@RequestMapping(value="/add", method={RequestMethod.GET, RequestMethod.POST})
	public String guestInsert(@ModelAttribute GuestVo guestVo) {
		System.out.println("/guestbook/insert");
		System.out.println(guestVo.toString());
		
		int count = guestService.guestInsert(guestVo);
		
		return "redirect:/guestbook/addlist";
	}
	
	//방명록 삭제 폼
	@RequestMapping(value = "/deleteForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm() {
		System.out.println("/guestbook/deleteForm");

		return "/guestbook/deleteForm";
	}
	
	//방명록 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String guestDelete(@ModelAttribute GuestVo guestVo) {
		System.out.println("/guestbook/delete");

		int count = guestService.guestDelete(guestVo);

		if (count == 1) {
			return "redirect:/guestbook/addlist";
		} else {

			return "redirect:/guestbook/deleteForm";
		}

	}

}

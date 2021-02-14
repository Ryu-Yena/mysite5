package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping(value = "/guestbook")
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;

	// 리스트+작성폼
	@RequestMapping(value = "/addList", method = RequestMethod.GET)
	public String addList(Model model) {
		System.out.println("[guestbookController] /addList");

		List<GuestbookVo> guestbookList = guestbookService.getList();
		model.addAttribute("guestbookList", guestbookList);
		return "guestbook/addList";
	}

	/* 글저장 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("[guestbookController] /add");

		guestbookService.add(guestbookVo);
		return "redirect:/guestbook/addList";
	}

	// 삭제폼
	@RequestMapping(value = "/removeForm", method = RequestMethod.GET)
	public String removeForm() {
		System.out.println("[guestbookController] /removeForm");

		return "guestbook/removeForm";
	}

	// 삭제
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("[guestbookController] /remove");
		
		int count = guestbookService.remove(guestbookVo);
		
		if(count == 1) {
			return "redirect:/guestbook/addList";
		}else {
			return "redirect:/guestbook/removeForm?no="+guestbookVo.getNo()+"&result=fail";
		}
	}
	
	
	// ajaxList
	@RequestMapping(value = "ajaxList", method = {RequestMethod.GET, RequestMethod.POST})
	public String ajaxList() {
		System.out.println("[guestbookController] /ajaxList");
		
		return "guestbook/ajaxList";
	}
}
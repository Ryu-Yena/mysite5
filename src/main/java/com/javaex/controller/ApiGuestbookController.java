package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping(value = "/api/guestbook")
public class ApiGuestbookController {

	@Autowired
	private GuestbookService guestbookService;

	// 전체리스트 가졍오기(ajax)
	@ResponseBody
	@RequestMapping(value = "/list")
	public List<GuestbookVo> list() {
		System.out.println("[ApiGuestbookController] /list");

		return guestbookService.getList();
	}

	// 글작성(ajax)
	@ResponseBody
	@RequestMapping(value = "/write")
	public GuestbookVo write(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("[ApiGuestbookController] /write");
		System.out.println(guestbookVo);

		// 입력된vo전달하고 저장vo를 받아야함
		return guestbookService.writeResultVo(guestbookVo);
	}

	// 글작성(ajax-json)
	@ResponseBody
	@RequestMapping(value = "/write2")
	public GuestbookVo write2(@RequestBody GuestbookVo guestbookVo) {
		System.out.println("[ApiGuestbookController] /write2");
		System.out.println(guestbookVo);

		// 입력된vo전달하고 저장vo를 받아야함
		return guestbookService.writeResultVo(guestbookVo);
	}

	
	// 글삭제(ajax)
	@ResponseBody
	@RequestMapping(value = "/remove")
	public int remove(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("[ApiGuestbookController] /write");
		System.out.println(guestbookVo);

		int count = guestbookService.remove(guestbookVo);
		System.out.println(count);
		return count;

	}

}
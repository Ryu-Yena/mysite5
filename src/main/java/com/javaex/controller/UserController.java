package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	//필드
	
	@Autowired
	private UserDao userDao;
	
	//생성자(디폴트 생성자라 생략되어있음)
	//g/s 생략
	
	//일반메소드
	
	//회원가입 폼
	@RequestMapping(value = "/joinForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("/user/joinForm");
		
		return "user/joinForm";
	}
	
	//회원가입
	@RequestMapping(value = "/join", method= {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("/user/join");
		System.out.println(userVo.toString());
		
		int count = userDao.insert(userVo);
		System.out.println("userController count:" + count);
		
		return "user/joinOk";
	}
	
	//로그인 폼
	@RequestMapping(value = "/loginForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("/user/loginForm");
		
		return "user/loginForm";
	}
	
	//로그인
	@RequestMapping(value="/login", method={RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("/user/login");
		System.out.println(userVo.toString());
		
		UserVo authUser = userDao.selectUser(userVo);
		
		if(authUser == null) {
			System.out.println("로그인 실패");
			
			return "redirect:/user/loginForm?result=fail";
		} else {
			System.out.println("로그인 성공");
			
			session.setAttribute("authUser", authUser);
			
			return "redirect:/";
		}
	}
	
		
	//로그아웃
	@RequestMapping(value="/logout", method={RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("/user/logout");
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}
	
	//회원정보 수정 폼
	@RequestMapping(value="/modifyForm", method={RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(HttpSession session, Model model) {
		System.out.println("/user/modifyForm");
		

		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		//로그인 안한 상태면 가져올 수 없다
		int no = authUser.getNo();
		
		//회원정보 가져오기
		UserVo userVo = userDao.selectOne(no);
		System.out.println("getUser(no)-->" + userVo);
		
		//어트리뷰트에 담기
		model.addAttribute("userVo", userVo);
		
		return "/user/modifyForm";
	}
	
	//회원정보 수정
	@RequestMapping(value="/modify", method={RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("/user/modify");
		//수정 예정
		
		return "";
	}
}
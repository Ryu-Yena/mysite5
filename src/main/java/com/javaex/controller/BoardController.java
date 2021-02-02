package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	//필드
	@Autowired
	private BoardService boardService;
	
	//생성자
	//g/s
	
	//일반 메소드
	
	//게시글 등록 폼
	@RequestMapping(value="/writeForm", method={RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("board/writeForm");
	
		return "/board/writeForm";
	}
	
	//게시글 등록
	@RequestMapping(value="/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String insert(@ModelAttribute BoardVo boardVo) {
		System.out.println("board/write");
		
		boardService.boardInsert(boardVo);
		return "redirect:/board/list";
	}
	
	//게시판 리스트 폼
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("/board/list");
		List<BoardVo> boardList = boardService.boardList();

		model.addAttribute("boardList", boardList);

		return "/board/list";
	}
	
	//게시글 삭제
	@RequestMapping(value="/delete", method={RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no) {
		System.out.println("/board/delete");
		
		boardService.boardDelete(no);
		return "redirect:/board/list";
	}
	
	//게시글 읽기
	@RequestMapping(value="/read", method={RequestMethod.GET, RequestMethod.POST})
	public String read(@RequestParam("no") int no, Model model) {
		System.out.println("/board/read");
		
		//조회수 업데이트
		boardService.boardHit(no);
		
		BoardVo boardVo = boardService.boardRead(no);
		System.out.println(boardVo.toString());
		
		//boardVo를 model에 담아서 넘김.
		model.addAttribute("bvo", boardVo);
		
		
		return "/board/read";
	}
	
	//게시판 수정 폼
	@RequestMapping(value="/modifyForm", method={RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam("no") int no, Model model) {
		System.out.println("/board/modifyForm");
		BoardVo boardVo = boardService.boardRead(no);
		
		model.addAttribute("boardVo", boardVo);
		
		return "/board/modifyForm";
	}
	
	
	//게시판 수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute("boardVo") BoardVo boardVo, HttpSession session) {
		System.out.println("/board/modify");
		
		//세션에서 정보가져오기
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		//세션에서 no값 가져오기
		int no = authUser.getNo();
		
		boardVo.setUser_no(no);
		
		boardService.boardUpdate(boardVo);

		return "redirect:/board/list";
	}

}

package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	
	//게시글 등록
	public int boardInsert(BoardVo boardVo) {
		System.out.println("BoardService baordInsert()");
		
		return boardDao.insertB(boardVo);
	}
	
	//게시판 리스트
	public List<BoardVo> boardList(){
		System.out.println("BaordService boardList()");
		
		return boardDao.getBoardList();
	}
	
	//게시글 삭제
	public void boardDelete(int no) {
		System.out.println("BoardService boardDelete()");
		
		boardDao.deleteB(no);
	}
	
	//조회수 업데이트
	public void boardHit(int no) {
		System.out.println("BaordService boardHit()");
		
		boardDao.hitB(no);
	}
	
	//게시글 읽기
	public BoardVo boardRead(int no) {
		System.out.println("BoardService boardRead()");
		
		return boardDao.readB(no);
	}
	
	//게시글 수정
	public int boardUpdate(BoardVo boardVo) {
		System.out.println("BoardService boardUpdate()");
		
		return boardDao.updateB(boardVo);
	}

}

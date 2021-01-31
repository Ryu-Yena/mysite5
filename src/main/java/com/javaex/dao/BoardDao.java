package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//게시글 등록
	public int insertB(BoardVo boardVo) {
		System.out.println("board dao insert");
		System.out.println(boardVo.toString());
		
		return sqlSession.insert("board.insert", boardVo);
	}
	
	
	//게시글 리스트
	public List<BoardVo> getBoardList(){
		System.out.println("BoardDao getBoardList()");
		
		return sqlSession.selectList("board.selectList");
	}
	
	//게시글 삭제
	public void deleteB(int no) {
		System.out.println("BoardDao boardDelete()");
		sqlSession.delete("board.delete", no);
	}
	
	//조회수
	public void hitB(int no) {
		System.out.println("BoardDao boardHit()");
		
		sqlSession.update("board.hit", no);
	}

	// 게시글 읽기
	public BoardVo readB(int no) {
		System.out.println("BoardDao boardSelectOne()");

		return sqlSession.selectOne("board.selectOne", no);
	}
	
	//게시판 수정
	public int updateB(BoardVo boardVo) {
		System.out.println("BoardDao boardUpdate()");
		System.out.println(boardVo.toString());

		int count = sqlSession.update("board.update", boardVo);
		return count;
	}

}

package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	/* 전체글 가져오기 */
	public List<GuestbookVo> selectList() {
		System.out.println("[guestbookDao] selectList()");
		return sqlSession.selectList("guestbook.selectList");
	}
	
	/* 글 저장 */
	public int insert(GuestbookVo guestbookVo) {
		System.out.println("[guestbookDao] insert()");
		return sqlSession.insert("guestbook.insert", guestbookVo);
	}

	/* 글 삭제 */
	public int delete(GuestbookVo guestbookVo) {
		System.out.println("[guestbookDao] delete()");
		return sqlSession.delete("guestbook.delete", guestbookVo);
	}
	
	/* 글 저장(selectkey) */
	public void insertSelectKey(GuestbookVo guestbookVo) {
		System.out.println("[guestbookDao] insertSelectKey()");
		
		System.out.println("dao:xml실행전-->" + guestbookVo);
		sqlSession.insert("guestbook.insertSelectKey", guestbookVo);
		System.out.println("dao:xml실행후-->" + guestbookVo);
	}
	
	/* 글 1개 가져오기 */
	public GuestbookVo selectOne(int no) {
		System.out.println("[guestbookDao] selectOne()");
		return sqlSession.selectOne("guestbook.select", no);
	}
	
	
	
}
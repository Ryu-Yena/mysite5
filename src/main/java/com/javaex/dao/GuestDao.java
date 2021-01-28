package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {
	
	@Autowired
	private SqlSession sqlSession; 
	
	//방명록 리스트
	public List<GuestVo> getGuestList() {
		System.out.println("GuestDao getGuestList()");
		
		return sqlSession.selectList("guestbook.selectList");
	}
	
	//방명록 등록
	public int insertGuest(GuestVo guestVo) {
		System.out.println("guest dao insert");
		System.out.println(guestVo.toString());
		
		return sqlSession.insert("guestbook.insert", guestVo);
	}
	
	//방명록 삭제
	public int deleteGuest(GuestVo guestVo) {
		System.out.println("guest dao deleteGuest()");

		int count = sqlSession.delete("guestbook.delete", guestVo);
		return count;
	}

}

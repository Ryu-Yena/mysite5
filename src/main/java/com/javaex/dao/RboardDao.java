package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.RboardVo;

@Repository
public class RboardDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	//게시판 리스트
	public List<RboardVo> getRboardList(){
		System.out.println("RboardDao getRboardList()");
		
		return sqlSession.selectList("rboard.selectList");
	}

}

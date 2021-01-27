package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;

	//회원가입 --> 회원정보저장
	public int insert(UserVo userVo) {
		System.out.println("회원가입");
		System.out.println(userVo.toString());

		return sqlSession.insert("user.insert", userVo);
	}

	//로그인 --> 회원정보 가져오기
	public UserVo selectUser(UserVo userVo) {
		System.out.println("로그인");
		System.out.println(userVo.toString());
		
		return sqlSession.selectOne("user.selectUser", userVo);
	}

	//회원정보 가져오기
	public UserVo selectOne(int no) {
		System.out.println("회원 1명 정보가져오기");
	
		return sqlSession.selectOne("user.selectOne", no);
	}

	public void update(UserVo userVo) {
		System.out.println("회원정보 수정");
		System.out.println(userVo.toString());
		
		sqlSession.update("user.update", userVo);
	}

}
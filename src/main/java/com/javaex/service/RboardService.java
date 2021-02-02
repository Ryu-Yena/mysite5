package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.RboardDao;
import com.javaex.vo.RboardVo;

@Service
public class RboardService {
	
	@Autowired
	public RboardDao rboardDao;
	
	//게시판 리스트
	public List<RboardVo> rboardList(){
		System.out.println("RboardService rboardList()");
		
		return rboardDao.getRboardList();
	}

}

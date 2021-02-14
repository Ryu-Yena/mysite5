package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	private GuestbookDao guestbookDao;
	
	/* 전체리스트 가져오기 */
	public List<GuestbookVo> getList(){
		System.out.println("[guestbookService] getList()");
		
		return guestbookDao.selectList();
	}
	
	/* 글 저장하기 */
	public int add(GuestbookVo guestbookVo){
		System.out.println("[guestbookService] add()");
		
		return guestbookDao.insert(guestbookVo);
	}
	
	/* 글 삭제 */
	public int remove(GuestbookVo guestbookVo){
		System.out.println("[guestbookService] remove()");
		
		return guestbookDao.delete(guestbookVo);
	}
	
	/* ajax 글저장-->저장된 글 리턴 */
	public GuestbookVo writeResultVo(GuestbookVo guestbookVo) {

		//글저장-->번호
		
		//int no = guestbookDao.insertSelectKey(guestbookVo);
		System.out.println("service: dao.insertSelectKey()실행전-->" + guestbookVo);
		
		guestbookDao.insertSelectKey(guestbookVo);
		
		System.out.println("service: dao.insertSelectKey()실행후-->" + guestbookVo);
		int no =guestbookVo.getNo(); 
		
		//글 1개 가져오기 
		return guestbookDao.selectOne(no);
	}
	
	
	
	
}
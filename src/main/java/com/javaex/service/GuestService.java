package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestService {
	
	@Autowired
	private GuestDao guestDao;
	
	//방명록 리스트
	public List<GuestVo> guestList() {
		System.out.println("GuestService guestList()");
		
		return guestDao.getGuestList();
	}
	
	//방명록 등록
	public int guestInsert(GuestVo guestVo) {
		System.out.println("GuestService guestInsert()");

		return guestDao.insertGuest(guestVo);
	}
	
	//방명록 삭제
		public int guestDelete(GuestVo guestVo) {
			System.out.println("GuestService guestDelete()");
			
			return guestDao.deleteGuest(guestVo);
		}

}

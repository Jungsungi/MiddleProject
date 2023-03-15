package com.example.project2.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.example.project2.db.DBManager;
import com.example.project2.vo.MemberVO;

@Repository
public class MemberDAO {

	public String phone(String id) {
		return DBManager.getPhone(id);
	}
	public int insertMember(MemberVO vo) {
		return DBManager.insertMember(vo);
	}
	
	public MemberVO loginCheck(HashMap<String, String> map) {
		return DBManager.loginCheck(map);
	}
	
	public MemberVO idCheck(String id) {
		return DBManager.idCheck(id);
	}
}

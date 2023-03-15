package com.example.project2.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.project2.db.DBManager;
import com.example.project2.vo.InterestVO;

@Repository
public class InterestDAO {

	public int insertInter(InterestVO vo) {
		return DBManager.insertInter(vo);
	}
	
	public List<InterestVO> findInterById(String id){
		return DBManager.findInterById(id);
	}
}

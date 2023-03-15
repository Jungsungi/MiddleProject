package com.example.project2.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.project2.db.DBManager;
import com.example.project2.vo.RecomentVO;

@Repository
public class RecomentDAO {

	public List<RecomentVO> findRecomentByHouseNo(int house_no){
		return DBManager.findRecomentByHouseNo(house_no);
	}
	
	public int insertRecoment(RecomentVO vo) {
		return DBManager.insertRecoment(vo);
	}
	
	public int deleteRecoment(int reno) {
		return DBManager.deleteRecoment(reno);
	}
}

package com.example.project2.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.project2.db.DBManager;
import com.example.project2.vo.HouseVO;
import com.example.project2.vo.InsertHouseVO;

@Repository
public class HouseDAO {

	public HouseVO detailHouse(int house_no){
		return DBManager.detailHouse(house_no);
	}
	
	public String findId(int house_no) {
		return DBManager.findId(house_no);
	}
	
	public int insertHouse(InsertHouseVO vo) {
		return DBManager.insertHouse(vo);
	}
	public int getNextNo() {
		return DBManager.getNextNo();
	}
}

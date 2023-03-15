package com.example.project2.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.project2.db.DBManager;
import com.example.project2.vo.ImgVO;
import com.example.project2.vo.OptVO;

@Repository
public class OptDAO {

	public OptVO findOptByHouseNo(int house_no){
		return DBManager.findOptByHouseNo(house_no);
	}
	
	public int insertOpt(OptVO vo) {
		return DBManager.insertOpt(vo);
	}
}

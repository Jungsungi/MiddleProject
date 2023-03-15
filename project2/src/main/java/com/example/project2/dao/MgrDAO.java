package com.example.project2.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.project2.db.DBManager;
import com.example.project2.vo.ImgVO;
import com.example.project2.vo.MgrVO;

@Repository
public class MgrDAO {

	public MgrVO findMgrByHouseNo(int house_no){
		return DBManager.findMgrByHouseNo(house_no);
	}
	
	public int insertMgr(MgrVO vo) {
		return DBManager.insertMgr(vo);
	}
}

package com.example.project2.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.project2.db.DBManager;
import com.example.project2.vo.ImgVO;
import com.example.project2.vo.SecurityVO;

@Repository
public class SecurityDAO {

	public SecurityVO findSeqByHouseNo(int house_no){
		return DBManager.findSeqByHouseNo(house_no);
	}
	
	public int insertSeq(SecurityVO vo) {
		return DBManager.insertSeq(vo);
	}
}

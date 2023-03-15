package com.example.project2.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.project2.db.DBManager;
import com.example.project2.vo.ImgVO;

@Repository
public class ImgDAO {

	public List<ImgVO> findImgByHouseNo(int house_no){
		return DBManager.findImgByHouseNo(house_no);
	}
	
	public int insertImg(ImgVO vo) {
		return DBManager.insertImg(vo);
	}
}

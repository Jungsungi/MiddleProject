package com.example.project2.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.project2.db.DBManager;
import com.example.project2.vo.HouseVO;
import com.example.project2.vo.RecommendVO;

@Repository
public class RecommendDAO {

	public List<RecommendVO> recommendHouse(){
		return DBManager.recommendHouse();
	}
}

package com.example.project2.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.project2.db.DBManager;
import com.example.project2.vo.AlarmVO;

@Repository
public class AlarmDAO {

	public int insertAlarm_recoment(AlarmVO vo) {
		return DBManager.insertAlarm_recoment(vo);
	}
	
	public int insertAlarm_inter(AlarmVO vo) {
		return DBManager.insertAlarm_inter(vo);
	}
	
	public List<AlarmVO> findAlarmById(String id){
		return DBManager.findAlarmById(id);
	}
	
	public List<AlarmVO> findAlarmByIdAndType(Map<String, String> map){
		return DBManager.findAlarmByIdAndType(map);
	}
}

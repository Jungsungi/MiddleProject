package com.example.project2.controller.alarm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project2.dao.AlarmDAO;
import com.example.project2.vo.AlarmVO;
import com.google.gson.Gson;

@Controller
public class AlarmController {
	
	
	@Autowired
	private AlarmDAO dao;
	public AlarmController(AlarmDAO dao) {
		super();
		this.dao = dao;
	}

	//알림 페이지로 이동하는 메소드
	@GetMapping("/alarm")
	public String alarmForm() {
		return "alarm";
	}

	//모든 알림을 가져오는 메소드
	@GetMapping("/allAlarm")
	@ResponseBody
	public List<AlarmVO> allAlarm(String id){
		List<AlarmVO> list = dao.findAlarmById(id);
		return list;
	}
	
	//댓글유형의 알림을 가져오는 메소드
	@GetMapping("/recomentAlarm")
	@ResponseBody
	public List<AlarmVO> recomentAlarm(String id, String al_type){
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("al_type", al_type);
		List<AlarmVO> list = dao.findAlarmByIdAndType(map);
		return list;
	}
	
	//관심목록 유형의 알림을 가져오는 메소드
	@GetMapping("/interestAlarm")
	@ResponseBody
	public List<AlarmVO> interAlarm(String id, String al_type){
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("al_type", al_type);
		List<AlarmVO> list = dao.findAlarmByIdAndType(map);
		return list;
	}
}

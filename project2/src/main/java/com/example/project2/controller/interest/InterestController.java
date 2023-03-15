package com.example.project2.controller.interest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project2.dao.AlarmDAO;
import com.example.project2.dao.InterestDAO;
import com.example.project2.vo.AlarmVO;
import com.example.project2.vo.InterestVO;

import lombok.Setter;

@Controller
@Setter
public class InterestController {
	
	@Autowired
	private InterestDAO interDAO;
	
	@Autowired
	private AlarmDAO alarmDAO;
	
	@GetMapping("/inter")
	public String inter() {
		return "interest";
	}
	
	@GetMapping("/RegInter")
	@ResponseBody
	public int regInter(InterestVO vo) {
		int re = interDAO.insertInter(vo);
		if(re>0) {
			int house_no = vo.getHouse_no();
			String house_id = vo.getHouse_id();
			AlarmVO al_vo = new AlarmVO();
			al_vo.setHouse_no(house_no);
			al_vo.setId(house_id);
			int re2 = alarmDAO.insertAlarm_inter(al_vo);
			if(re2>0) {
				System.out.println("알림 등록 성");
			}
		}
		return re;
	}
	
	@GetMapping("/interestlist")
	@ResponseBody
	public List<InterestVO> interList(String id){
		List<InterestVO> list = interDAO.findInterById(id);
		return list;
	}

}

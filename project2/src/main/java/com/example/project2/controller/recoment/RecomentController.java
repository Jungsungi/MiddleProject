package com.example.project2.controller.recoment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project2.dao.AlarmDAO;
import com.example.project2.dao.RecomentDAO;
import com.example.project2.vo.AlarmVO;
import com.example.project2.vo.RecomentVO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;

@RestController
@Data
public class RecomentController {
	
	@Autowired
	private RecomentDAO dao;
	
	@Autowired
	private AlarmDAO al_dao;
	
	@GetMapping("LoadRecoment")
	public List<RecomentVO> recomentList(int house_no) {
		return dao.findRecomentByHouseNo(house_no);
	}
	
	@GetMapping("InsertRecoment")
	@ResponseBody
	public int insertRecoment(HttpServletRequest request){
		String re_content = request.getParameter("re_content");
		int reno =1;
		String re_pwd = request.getParameter("re_pwd");
		String house_id = request.getParameter("house_id");
		int house_no = Integer.parseInt(request.getParameter(("house_no")));
		
		RecomentVO vo = new RecomentVO();
		vo.setHouse_no(house_no);
		vo.setRe_content(re_content);
		vo.setRe_pwd(re_pwd);
		vo.setReno(reno);
		int re = dao.insertRecoment(vo);
		if(re>0) {
			AlarmVO al_vo = new AlarmVO();
			al_vo.setHouse_no(house_no);
			al_vo.setId(house_id);
			System.out.println(al_vo.getHouse_no());
			System.out.println(al_vo.getId());
			int re1 = al_dao.insertAlarm_recoment(al_vo);
			if(re1>0) {
				System.out.println("알림등록 성");
			}
		}
		return re;
	}
	
	@GetMapping("DeleteRecoment")
	@ResponseBody
	public int deleteRecoment(int reno) {
		int re = dao.deleteRecoment(reno);
		return re;
	}
}

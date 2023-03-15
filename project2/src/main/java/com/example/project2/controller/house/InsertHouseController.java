package com.example.project2.controller.house;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.example.project2.dao.HouseDAO;
import com.example.project2.dao.ImgDAO;
import com.example.project2.dao.MgrDAO;
import com.example.project2.dao.OptDAO;
import com.example.project2.dao.SecurityDAO;
import com.example.project2.vo.ImgVO;
import com.example.project2.vo.InsertHouseVO;
import com.example.project2.vo.MgrVO;
import com.example.project2.vo.OptVO;
import com.example.project2.vo.SecurityVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Setter;

@Controller
public class InsertHouseController {
	
	@Autowired
	@Setter
	private HouseDAO houseDAO; 
	
	@Autowired
	@Setter
	private ImgDAO imgDAO; 
	
	@Autowired
	@Setter
	private OptDAO optDAO; 
	
	@Autowired
	@Setter
	private MgrDAO mgrDAO; 
	
	@Autowired
	@Setter
	private SecurityDAO seqDAO; 
	
	
	//매물 등록 페이지를 보여주는 메소드
	@GetMapping("/insertHouse")
	public String insertForm() {
		return "insertHouse";
	}
	
	@PostMapping("/insertHouse")
	@ResponseBody
	public int insertResult(HttpServletRequest request) {
		int re = 0;
		
		String path = request.getSession().getServletContext().getRealPath("images");
		
		
		int house_no = houseDAO.getNextNo();
		String house_name = request.getParameter("house_name");
		int deposit = Integer.parseInt(request.getParameter("deposit"));
		String type = request.getParameter("type");
		String deal_type = request.getParameter("deal_type");
		//int hit = Integer.parseInt(request.getParameter("hit"));
		int floor = Integer.parseInt(request.getParameter("floor"));
		int price = Integer.parseInt(request.getParameter("price"));
		int area = Integer.parseInt(request.getParameter("area"));
		String aspect = request.getParameter("aspect");
		String loc = request.getParameter("loc");
		String detail = request.getParameter("detail");
		String id = request.getParameter("id");
		String house_regdate = request.getParameter("house_regdate");
		String input_date = request.getParameter("input_date");
		
		//String state = request.getParameter("state");
		String lat = request.getParameter("lat");
		String lng = request.getParameter("lng");
		int mgr = Integer.parseInt(request.getParameter("mgr"));
		
		String mgr_elec = request.getParameter("mgr_elec");
		String mgr_gas = request.getParameter("mgr_gas");
		String mgr_internet = request.getParameter("mgr_internet");
		String mgr_park = request.getParameter("mgr_park");
		String mgr_water = request.getParameter("mgr_water");
		
		String opt_park = request.getParameter("opt_park");
		String opt_aircon = request.getParameter("opt_aircon");
		String opt_refrige = request.getParameter("opt_refrige");
		String opt_washer = request.getParameter("opt_washer");
		String opt_gas = request.getParameter("opt_gas");
		String opt_micro = request.getParameter("opt_micro");
		String opt_elevator = request.getParameter("opt_elevator");
		String opt_builtin = request.getParameter("opt_builtin");
		
		String [] arr_opt = {opt_park, opt_aircon, opt_refrige, opt_washer, opt_gas, opt_micro, opt_elevator, opt_builtin};
		for(int i =0; i<arr_opt.length; i++) {
			if(arr_opt[i] !=null && !arr_opt[i].equals("")) {
				arr_opt[i] = "Y";
			}else {
				arr_opt[i] = "N";
			}
		}
		
		opt_park = arr_opt[0];
		opt_aircon = arr_opt[1];
		opt_refrige = arr_opt[2];
		opt_washer = arr_opt[3];
		opt_gas = arr_opt[4];
		opt_micro = arr_opt[5];
		opt_elevator = arr_opt[6];
		opt_builtin = arr_opt[7];
		
				
		String cctv = request.getParameter("cctv");	
		String videophone = request.getParameter("videophone");	
		String interphone = request.getParameter("interphone");	
		String frontdoor = request.getParameter("frontdoor");	
		String firealarm = request.getParameter("firealarm");	
		
		String [] arr_seq = {cctv, videophone, interphone, frontdoor, firealarm};
		
		for(int i=0; i<arr_seq.length; i++) {
			if(arr_seq[i] != null && !arr_seq[i].equals("")) {
				
			}else {
				arr_seq[i] = "N";
			}
		}
		cctv = arr_seq[0];
		videophone = arr_seq[1];
		interphone = arr_seq[2];
		frontdoor = arr_seq[3];
		firealarm = arr_seq[4];
		
		
		
		int img_no = Integer.parseInt(request.getParameter("img_no"));
		
		
		String img_fname = request.getParameter(house_name);
		
		InsertHouseVO i = new InsertHouseVO();
		MgrVO m = new MgrVO();
		OptVO o = new OptVO();
		SecurityVO s = new SecurityVO();
		ImgVO img = new ImgVO();
		
		img.setHouse_no(house_no);
		img.setImg_no(img_no);
		img.setImg_fname(img_fname);
		
		s.setHouse_no(house_no);
		s.setCctv(cctv);
		s.setInterphone(interphone);
		s.setVideophone(videophone);
		s.setFirealarm(firealarm);
		s.setFrontdoor(frontdoor);
		
		o.setHouse_no(house_no);
		o.setOpt_aircon(opt_aircon);
		o.setOpt_builtin(opt_builtin);
		o.setOpt_elevator(opt_elevator);
		o.setOpt_gas(opt_gas);
		o.setOpt_park(opt_park);
		o.setOpt_refrige(opt_refrige);
		o.setOpt_washer(opt_washer);
		o.setOpt_micro(opt_micro);
		
		
		m.setHouse_no(house_no);
		m.setMgr_elec(mgr_elec);
		m.setMgr_gas(mgr_gas);
		m.setMgr_internet(mgr_internet);
		m.setMgr_park(mgr_park);
		m.setMgr_water(mgr_water);
		
		
		i.setHouse_no(house_no);
		i.setHouse_name(house_name);
		i.setDeposit(deposit);
		i.setType(type);
		i.setDeal_type(deal_type);
		//i.setHit(hit);
		i.setFloor(floor);
		i.setPrice(price);
		i.setArea(area);
		i.setAspect(aspect);
		i.setLoc(loc);
		i.setDetail(detail);
		i.setId(id);
		i.setHouse_regdate(house_regdate);
		i.setInput_date(input_date);
		//i.setState(state);
		i.setLat(lat);
		i.setLng(lng);
		i.setMgr(mgr);
		
		int re_house = houseDAO.insertHouse(i);
		int re_mgr = mgrDAO.insertMgr(m);
		int re_opt = optDAO.insertOpt(o);
//		int re_img = imgDAO.insertImg(img);
		int re_security = seqDAO.insertSeq(s);
		
		return re_house;
	}

}

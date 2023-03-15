package com.example.project2.controller.house;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.project2.dao.HouseDAO;
import com.example.project2.dao.ImgDAO;
import com.example.project2.dao.MemberDAO;
import com.example.project2.dao.MgrDAO;
import com.example.project2.dao.OptDAO;
import com.example.project2.dao.RecommendDAO;
import com.example.project2.dao.SecurityDAO;
import com.example.project2.vo.ImgVO;
import com.example.project2.vo.RecommendVO;
import com.google.gson.Gson;

import lombok.Data;

@Controller
@Data
public class HouseController {
	
	@Autowired
	private HouseDAO houseDAO;
	@Autowired
	private ImgDAO imgDAO;
	@Autowired
	private OptDAO optDAO;
	@Autowired
	private MgrDAO mgrDAO;
	@Autowired
	private SecurityDAO seqDAO;
	@Autowired
	private RecommendDAO recommendDAO;
	@Autowired
	private MemberDAO memberDAO;
	
	//매물 상세 페이지를 보여주는 메소드
	@RequestMapping("/detailHouse/{house_no}")
	public ModelAndView detailHouse(@PathVariable int house_no) {
		ModelAndView mav = new ModelAndView("house/detailHouse");
		mav.addObject("house_list", houseDAO.detailHouse(house_no));
		mav.addObject("mgr_list", mgrDAO.findMgrByHouseNo(house_no));
		mav.addObject("opt_list",optDAO.findOptByHouseNo(house_no));
		mav.addObject("seq_list", seqDAO.findSeqByHouseNo(house_no));
		List<ImgVO> list = imgDAO.findImgByHouseNo(house_no);
		String mainImg = list.get(0).getImg_fname();
		String img1 = "";
		String img2 = "";
		
		mav.addObject("mainImg", mainImg);
		
		if( list.size()>=3) {
			img1 = list.get(1).getImg_fname();
			img2 = list.get(2).getImg_fname();
			
			mav.addObject("img1", img1);
			mav.addObject("img2", img2);
		}
		
		mav.addObject("img_list", list);

		String id = houseDAO.findId(house_no);
		mav.addObject("phone", memberDAO.phone(id));
		
		return mav;
	}
	
	//매물을 조회수 순으로 보여주는 메소드
	@GetMapping("RecommendHouse")
	@ResponseBody
	public String recommendHouse() {
		List<RecommendVO> prelist = recommendDAO.recommendHouse();
		String list = new Gson().toJson(prelist);
		return list;
	}
}

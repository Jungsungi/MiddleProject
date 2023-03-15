package com.example.project2.controller.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.project2.dao.RecommendDAO;
import com.example.project2.vo.RecommendVO;

import lombok.Setter;

@Controller
public class HouseListController {
	
	@Autowired
	@Setter
	private RecommendDAO recommendDAO ;
	
	@GetMapping("/houseList")
	public String houseListForm(Model model) {
		List<RecommendVO> list = recommendDAO.recommendHouse();
		model.addAttribute("list",list);
		return "houseList";
	}

}

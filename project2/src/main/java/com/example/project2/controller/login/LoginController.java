package com.example.project2.controller.login;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.project2.dao.MemberDAO;
import com.example.project2.vo.MemberVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private MemberDAO memberDAO;
	
//	@Autowired 
//	private PasswordEncoder passwordEncoder;
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
			session.removeAttribute("id");
		return "main/main";
	}

	@GetMapping("/Login")
	public String loginPage() {
		return "login/Login";
	}
	
	@PostMapping("/Login")
	public ModelAndView loginOK(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		String msg = "";
		MemberVO m = memberDAO.loginCheck(map);
		if(m != null &&! m.equals("")) {
			mav.setViewName("login/LoginOK");
			mav.addObject("id", id);
			session.setAttribute("id", id);
			msg = "로그인에 성공하였습니다.";
		}else {
			msg = "로그인에 실패하였습니다.";
			mav.setViewName("login/loginOK");
		}
		mav.addObject("msg", msg);
		return mav;
	}
	
	@RequestMapping("/loginOK")
	public String loginOK() {
		return "login/loginOK";
	}
	
	
}

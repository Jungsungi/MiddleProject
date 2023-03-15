package com.example.project2.controller.member;

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
import lombok.Data;

@Controller
@Data
public class MemberController {
	
	@Autowired
	private MemberDAO memberDAO;

	@GetMapping("/insertMember")
	public String insertMember() {
		return "insertMember";
	}
	
	@PostMapping("/insertMember")
	public ModelAndView insertMemberOK(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/insertMemberOK");
		
		MemberVO m = new MemberVO();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String jumin1 = request.getParameter("jumin1");
		String jumin2 = request.getParameter("jumin2");
		String jumin = jumin1+"-"+jumin2;
		String m_addr = request.getParameter("m_addr");
		String email = request.getParameter("email");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String phone = phone1+"-"+phone2+"-"+phone3;
		m.setId(id);
		m.setName(name);
		m.setPwd(pwd);
		m.setJumin(jumin);
		m.setM_addr(m_addr);
		m.setEmail(email);
		m.setPhone(phone);
		
		String result= "";
		
		int re = memberDAO.insertMember(m);
		if(re>0) {
			result = "회원가입에 성공하였습니다.";
			
		}else {
			result = "회원가입에 실패하였습니다.";
		}
		mav.addObject("msg",result);
		return mav;
	}
	
	@PostMapping("/idCheck")
	@ResponseBody
	public int idCheck(String id) {
		int re = 0;
		MemberVO m = memberDAO.idCheck(id);
		if(m == null) {
			re = 1;
		}
		return re;
	}
	
	@RequestMapping("/insertMemberOK")
	public String insertMemberOK() {
		return "insertMemberOK";
	}
}

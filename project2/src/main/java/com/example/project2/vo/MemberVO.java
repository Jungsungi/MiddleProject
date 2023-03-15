package com.example.project2.vo;

import lombok.Data;

//회원 객체
@Data
public class MemberVO {
	private String id;
	private String name;
	private String pwd;
	private String jumin;
	private String m_addr;
	private String email;
	private String phone;
}
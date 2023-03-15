package com.example.project2.vo;

import lombok.Data;

//보안 객체
@Data
public class SecurityVO {
	private int house_no;
	private String cctv;
	private String videophone;
	private String interphone;
	private String firealarm;
	private String frontdoor;
}

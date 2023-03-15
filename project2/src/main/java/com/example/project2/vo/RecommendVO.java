package com.example.project2.vo;


import java.sql.Date;

import lombok.Data;

//추천매물 객체
@Data
public class RecommendVO {
	private int house_no;
	private String house_name;
	private int deposit;
	private String type;
	private String deal_type;
	private int hit;
	private int floor;
	private int price;
	private int area;
	private String aspect;
	private String loc;
	private String detail;
	private String id;
	private Date house_regdate;
	private int mgr;
	private String state;
	private String lat;
	private String lng;
	private Date input_date;
	
	private String img_fname;
}
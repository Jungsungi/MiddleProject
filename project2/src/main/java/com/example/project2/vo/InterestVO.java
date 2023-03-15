package com.example.project2.vo;

import lombok.Data;

//관심목록 객체
@Data
public class InterestVO {
	private int inter_no;
	private String inter_title;
	private String inter_img;
	private String id;
	private String house_id;
	private int house_no;
}
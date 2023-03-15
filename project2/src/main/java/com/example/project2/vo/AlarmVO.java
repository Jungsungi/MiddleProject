package com.example.project2.vo;

import lombok.Data;

//알림 객체
@Data
public class AlarmVO {

	private int al_no;
	private String al_content;
	private String al_type;
	private String id;
	private int house_no;
}

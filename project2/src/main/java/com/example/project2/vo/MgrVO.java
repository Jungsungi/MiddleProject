package com.example.project2.vo;

import lombok.Data;

//관리비 객체
@Data
public class MgrVO {
	private int house_no;
	private String mgr_elec;
	private String mgr_water;
	private String mgr_internet;
	private String mgr_gas;
	private String mgr_park;
}

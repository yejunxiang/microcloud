package com.caxins.vo;

import java.io.Serializable;

/**
 * @author admin
 * @description  
 * @date 2018年3月14日
 */
public class Company implements Serializable {
	private String title;
	private String note;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}

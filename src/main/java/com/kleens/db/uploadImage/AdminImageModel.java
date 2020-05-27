package com.kleens.db.uploadImage;

import java.util.List;

public class AdminImageModel {
	private String image;
	private int id;
	private List<String> piclist;
	public List<String> getPiclist() {
		return piclist;
	}
	public void setPiclist(List<String> piclist) {
		this.piclist = piclist;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}

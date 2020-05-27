package com.kleens.db.uploadImage;

import java.util.List;

public class CustImageModel {
private String image;
private int custID;
private List<String> piclist;

public List<String> getPiclist() {
	return piclist;
}

public void setPiclist(List<String> piclist) {
	this.piclist = piclist;
}

public int getCustID() {
	return custID;
}

public void setCustID(int custID) {
	this.custID = custID;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}



}

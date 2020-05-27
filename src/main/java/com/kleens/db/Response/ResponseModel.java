package com.kleens.db.Response;

public class ResponseModel {
private String responseMessage;
private int responseCode;
private int adminID;

public int getAdminID() {
	return adminID;
}
public void setAdminID(int adminID) {
	this.adminID = adminID;
}
public String getResponseMessage() {
	return responseMessage;
}
public void setResponseMessage(String responseMessage) {
	this.responseMessage = responseMessage;
}
public int getResponseCode() {
	return responseCode;
}
public void setResponseCode(int responseCode) {
	this.responseCode = responseCode;
}

}

package com.kleens.db.password;

public class passwordResetModel {
private String email;
private String autoPassword;
private int custID;
private String error;
private String newPassword;

public String getAutoPassword() {
	return autoPassword;
}
public void setAutoPassword(String autoPassword) {
	this.autoPassword = autoPassword;
}
public String getNewPassword() {
	return newPassword;
}
public void setNewPassword(String newPassword) {
	this.newPassword = newPassword;
}
public String getError() {
	return error;
}
public void setError(String error) {
	this.error = error;
}
public int getCustID() {
	return custID;
}
public void setCustID(int custID) {
	this.custID = custID;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
}



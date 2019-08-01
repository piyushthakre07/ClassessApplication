package com.colour.beans;

import java.io.Serializable;

public class StatusBean implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -7087642111043657280L;
private String message;
private String satusCode;
private Boolean status;
private String errorCode;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getSatusCode() {
	return satusCode;
}
public void setSatusCode(String satusCode) {
	this.satusCode = satusCode;
}
public Boolean getStatus() {
	return status;
}
public void setStatus(Boolean status) {
	this.status = status;
}
public String getErrorCode() {
	return errorCode;
}
public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}

}

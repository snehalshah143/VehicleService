package com.snehal.carservice.model.dto;

import java.io.Serializable;

public class PaymentResponse implements Serializable{

	private String paymentID;
	private boolean status;
	private String comments;
	
	public PaymentResponse() {
		super();
	}
	public PaymentResponse(String paymentID, boolean status, String comments) {
		super();
		this.paymentID = paymentID;
		this.status = status;
		this.comments = comments;
	}
	public String getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}

package com.snehal.carservice.common;

public class PaymentResult {

	private long bookingId;
	private Status status;
	private String paymentReference;
	
	
	public PaymentResult(long bookingId, Status status, String paymentReference) {
		super();
		this.bookingId = bookingId;
		this.status = status;
		this.paymentReference = paymentReference;
	}
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getPaymentReference() {
		return paymentReference;
	}
	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}
	
	
	
}

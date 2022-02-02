package com.snehal.carservice.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

public class PaymentNotifyRequest extends AbstractJsonDto{

private static final long serialVersionUID = 5926468583005150707L;

private String paymentId;
private Long bookingId;

//need default constructor for JSON Parsing
public PaymentNotifyRequest()
{

}

public PaymentNotifyRequest(String paymentId, Long bookingId) {
this.paymentId=paymentId;
this.bookingId=bookingId;
}

public String getPaymentId() {
	return paymentId;
}

public void setPaymentId(String paymentId) {
	this.paymentId = paymentId;
}

public Long getBookingId() {
	return bookingId;
}

public void setBookingId(Long bookingId) {
	this.bookingId = bookingId;
}




}

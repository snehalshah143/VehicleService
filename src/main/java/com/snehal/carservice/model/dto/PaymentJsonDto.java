package com.snehal.carservice.model.dto;

import java.io.IOException;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PaymentJsonDto implements Serializable{
	
//    private @Id  @GeneratedValue(strategy = GenerationType.TABLE) String paymentId;
    @JsonProperty("id")
    private @Id String paymentId;
    
    @JsonProperty("entity")
    private String entity;
    
    @JsonProperty("amount")
    private String amount;
    
    @JsonProperty("currency")
    private String currency;
    
    @JsonProperty("status")
    private String paymentStatus;
    
    @JsonProperty("order_id")
    private String orderId;
    
    @JsonProperty("invoice_id")
    private String invoiceId;
    
    @JsonProperty("international")
    private String international;
    
    @JsonProperty("method")
    private String method;
    
    @JsonProperty("amount_refunded")
    private String amountRefunded;
    
    @JsonProperty("refund_status")
    private String refundStatus;
    
    @JsonProperty("captured")
    private boolean captured;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("vpa")
    private String vpa;
   
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("contact")
    private String contact;
    
    @JsonProperty("fee")
    private Integer fee;
    
    @JsonProperty("tax")
    private Integer tax;

    @JsonProperty("error_code")
    private String errorCode;
    
    @JsonProperty("error_description")
    private String errorDescription;
    
    @JsonProperty("error_source")
    private String errorSource;
    
    @JsonProperty("errorStep")
    private String errorStep;
    
    @JsonProperty("error_reason")
    private String errorReason;

    
    @JsonProperty("created_at")
    private Long createdAt;
    
	@JsonIgnore
    private String booking;


	public String getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}


	public String getEntity() {
		return entity;
	}


	public void setEntity(String entity) {
		this.entity = entity;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getInvoiceId() {
		return invoiceId;
	}


	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}


	public String getInternational() {
		return international;
	}


	public void setInternational(String international) {
		this.international = international;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public String getAmountRefunded() {
		return amountRefunded;
	}


	public void setAmountRefunded(String amountRefunded) {
		this.amountRefunded = amountRefunded;
	}


	public String getRefundStatus() {
		return refundStatus;
	}


	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}


	public boolean isCaptured() {
		return captured;
	}


	public void setCaptured(boolean captured) {
		this.captured = captured;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getVpa() {
		return vpa;
	}


	public void setVpa(String vpa) {
		this.vpa = vpa;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public Integer getFee() {
		return fee;
	}


	public void setFee(Integer fee) {
		this.fee = fee;
	}


	public Integer getTax() {
		return tax;
	}


	public void setTax(Integer tax) {
		this.tax = tax;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public String getErrorDescription() {
		return errorDescription;
	}


	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}


	public String getErrorSource() {
		return errorSource;
	}


	public void setErrorSource(String errorSource) {
		this.errorSource = errorSource;
	}


	public String getErrorStep() {
		return errorStep;
	}


	public void setErrorStep(String errorStep) {
		this.errorStep = errorStep;
	}


	public String getErrorReason() {
		return errorReason;
	}


	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}


	public Long getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}


	public BookingJsonDto getBooking() {
		ObjectMapper mapper = new ObjectMapper();
		BookingJsonDto jsonDto = null;
		
		if(booking!=null) {
		try {
			jsonDto = mapper.readValue(booking, BookingJsonDto.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return jsonDto;
	}

	public void setBooking(BookingJsonDto bookingJsonDto) {
		
		ObjectMapper mapper = new ObjectMapper();
		if(bookingJsonDto!=null) {
		try {
			this.booking = mapper.writeValueAsString(bookingJsonDto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		}
	   
    
}


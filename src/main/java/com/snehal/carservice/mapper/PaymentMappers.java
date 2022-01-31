package com.snehal.carservice.mapper;



import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snehal.carservice.model.domain.Payment;
import com.snehal.carservice.model.dto.BookingJsonDto;
import com.snehal.carservice.model.dto.PaymentJsonDto;
import com.snehal.carservice.model.persistable.PaymentPersistable;

public class PaymentMappers extends AbstarctMapper<PaymentJsonDto, Payment, PaymentPersistable>{

	
	private static PaymentMappers paymentMappers=new PaymentMappers();

	public static PaymentMappers getPaymentMappers() {
		return paymentMappers;
	
	}
	
	public PaymentJsonDto  mapPersistableToJsonDto(PaymentPersistable persistable) {
		PaymentJsonDto jsonDto=new PaymentJsonDto();
		jsonDto.setAmount(persistable.getAmount());
		jsonDto.setAmountRefunded(persistable.getAmountRefunded());
		BookingJsonDto bookingJsonDto=new BookingJsonDto();
		bookingJsonDto.setBookingId(persistable.getBooking().getBookingId());
		jsonDto.setBooking(bookingJsonDto);
		jsonDto.setCaptured(persistable.isCaptured());
		jsonDto.setContact(persistable.getContact());
		jsonDto.setCreatedAt(persistable.getCreatedAt());
		jsonDto.setCurrency(persistable.getCurrency());
		jsonDto.setDescription(persistable.getDescription());
		jsonDto.setEmail(persistable.getEmail());
		jsonDto.setEntity(persistable.getEntity());
		jsonDto.setErrorCode(persistable.getErrorCode());
		jsonDto.setErrorDescription(persistable.getErrorDescription());
		jsonDto.setErrorReason(persistable.getErrorReason());
		jsonDto.setErrorSource(persistable.getErrorSource());
		jsonDto.setErrorStep(persistable.getErrorStep());
		jsonDto.setFee(persistable.getFee());
		jsonDto.setInternational(persistable.getInternational());
		jsonDto.setInvoiceId(persistable.getInvoiceId());
		jsonDto.setMethod(persistable.getMethod());
		jsonDto.setOrderId(persistable.getOrderId());
		jsonDto.setPaymentId(persistable.getPaymentId());
		jsonDto.setPaymentStatus(persistable.getPaymentStatus());
		
		jsonDto.setRefundStatus(persistable.getRefundStatus());
		jsonDto.setTax(persistable.getTax());
		jsonDto.setVpa(persistable.getVpa());

		
		
//		AssignmentJsonDto jsonDto= modelMapper.map(persistable, AssignmentJsonDto.class);
		return jsonDto;
		
	}
	
	
	public PaymentJsonDto  mapPaymentToJsonDto(com.razorpay.Payment payment) {
		
		JSONObject data = new JSONObject(payment.toString());
				ObjectMapper mapper = new ObjectMapper();
				PaymentJsonDto jsonDto = null;
				try {
					jsonDto = mapper.readValue(data.toString(), PaymentJsonDto.class);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return jsonDto;
		
	}
	
	public PaymentPersistable  mapPaymentToPersistable(com.razorpay.Payment payment) {
		
		JSONObject data = new JSONObject(payment.toString());
				ObjectMapper mapper = new ObjectMapper();
				PaymentPersistable persistable = null;
				try {
					mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
					persistable = mapper.readValue(data.toString(), PaymentPersistable.class);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return persistable;
		
	}
}

package com.snehal.carservice.paymentgateway;

import org.springframework.stereotype.Service;

import com.razorpay.Payment;
import com.razorpay.RazorpayException;
import com.snehal.carservice.mapper.PaymentMappers;
import com.snehal.carservice.model.dto.PaymentJsonDto;
import com.snehal.carservice.model.persistable.PaymentPersistable;

@Service
public class RozerPaymentGateway implements PaymentGateway{
	

	
	public PaymentPersistable fetchPaymentInfo(String paymentId)  {

		Payment payment=null;
		try {
	com.razorpay.RazorpayClient razorpay = new com.razorpay.RazorpayClient("KEYID","YOUR_KEY_SECRET");
		  payment = razorpay.Payments.fetch(paymentId);
		} catch (RazorpayException e) {
		  // Handle Exception
		  System.out.println(e.getMessage());
		}

		return PaymentMappers.getPaymentMappers().mapPaymentToPersistable(payment);
		
	}

}

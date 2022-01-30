package com.snehal.carservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snehal.carservice.dao.PaymentRepository;
import com.snehal.carservice.model.dto.PaymentJsonDto;
import com.snehal.carservice.model.persistable.PaymentPersistable;
import com.snehal.carservice.paymentgateway.PaymentGateway;
@Service
public class PaymentServiceImpl implements PaymentService{

	
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PaymentGateway paymentGateway;
	
	
	public PaymentPersistable savePayment(PaymentPersistable persistable) {
		
		return paymentRepository.save(persistable);
	
	}
	
	
	public PaymentPersistable fetchPaymentInfoFromPaymentGateway(String paymentId) {
		
		
		return paymentGateway.fetchPaymentInfo(paymentId);
		
	}
	
	
}

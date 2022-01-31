package com.snehal.carservice.service;

import com.snehal.carservice.model.persistable.PaymentPersistable;

public interface PaymentService {

	public PaymentPersistable savePayment(PaymentPersistable persistable);
	
	public PaymentPersistable fetchPaymentInfoFromPaymentGateway(String paymentId);
	
	public PaymentPersistable getPaymentInfo(String paymentId);
}

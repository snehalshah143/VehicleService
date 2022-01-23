package com.snehal.carservice.service;

import com.snehal.carservice.common.status.PaymentResult;

public interface PaymentService {

	public PaymentResult makepayment(long bookingId, double finalAmount);
}

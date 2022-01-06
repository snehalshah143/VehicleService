package com.snehal.carservice.service;

import com.snehal.carservice.common.PaymentResult;

public interface PaymentService {

	public PaymentResult makepayment(long bookingId, double finalAmount);
}

package com.snehal.carservice.paymentgateway;

import com.snehal.carservice.model.persistable.PaymentPersistable;

public interface PaymentGateway {

  public PaymentPersistable fetchPaymentInfo(String paymentId);
}

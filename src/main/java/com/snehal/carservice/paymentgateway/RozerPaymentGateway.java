package com.snehal.carservice.paymentgateway;

import com.razorpay.Payment;
import com.razorpay.RazorpayException;
import com.snehal.carservice.mapper.PaymentMappers;
import com.snehal.carservice.model.persistable.PaymentPersistable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RozerPaymentGateway implements PaymentGateway {

  @Value("${rozer.keyid}")
  private String keyId;

  @Value("${rozer.secretkey}")
  private String secretKey;

  public PaymentPersistable fetchPaymentInfo(String paymentId) {

    Payment payment = null;
    try {
      com.razorpay.RazorpayClient razorpay = new com.razorpay.RazorpayClient(keyId, secretKey);
      payment = razorpay.Payments.fetch(paymentId);
    } catch (RazorpayException e) {
      // Handle Exception
      System.out.println(e.getMessage());
    }

    return PaymentMappers.getPaymentMappers().mapPaymentToPersistable(payment);
  }
}

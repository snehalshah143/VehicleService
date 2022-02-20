package com.snehal.carservice.common;

import java.io.Serializable;

public enum TimeSlot implements Serializable {
  PEAK_TIME(1, "6.30 AM - 9.30 AM ", 50),
  NORMAL_TIME(2, "9.30AM - 12 PM   AND 5.30PM - 8.30PM", 0),
  FREE_TIME(3, "12PM - 5.30 PM ANd NIGHT TIME AFTER 8.30PM", -50);

  private String value;
  private int id;
  private double premium;

  TimeSlot(int id, String value, double premium) {
    this.id = id;
    this.value = value;
    this.premium = premium;
  }

  public double getPremium() {
    return this.premium;
  }

  public String getValue() {
    return this.value;
  }

  public int getId() {
    return this.id;
  }
}

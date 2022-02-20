package com.snehal.carservice.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

  public static Date getCurrentDate() {

    return new Date();
  }

  public static Date getCurrentDateForDB() {

    return new java.sql.Date(getCurrentDate().getTime());
  }

  public static String formatDate(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    return sdf.format(date);
  }

  public static void main(String[] args) throws Exception {

    Date date = new Date();

    System.out.println(date);
    java.sql.Date datesql = new java.sql.Date(date.getTime());

    System.out.println(datesql);

    Calendar c = Calendar.getInstance();
    System.out.println("Calender date::" + c.getTime());
    System.out.println("Calender date::" + new java.sql.Date(c.getTimeInMillis()));
    System.out.println(c.get(Calendar.DAY_OF_WEEK));

    c.roll(Calendar.DATE, true);
    System.out.println("After UpCalender date::" + c.getTime());
    System.out.println(c.get(Calendar.DAY_OF_WEEK));
    c.add(Calendar.DATE, 2);
    System.out.println("ADD UpCalender date::" + c.getTime());
    System.out.println(c.get(Calendar.DAY_OF_WEEK));
  }
}

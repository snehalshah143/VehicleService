package com.snehal.carservice.common;

import java.io.Serializable;

public enum ProductType implements Serializable{

	DAILY_WASH(1,"Daily Wash",1),
	ALTERNATE_WASH(2,"Alternate Wash",0.5),
	ON_DEMAND_WASH(3,"On Demand Wash",0.1);
	
	private String value;
	private int id;
	private double factor;
	ProductType(int id,String value,double factor) {
		this.id=id;
	    this.value = value;
	    this.factor=factor;
	  }
	  public double getFactor() {
		    return this.factor;
		  }
	  public String getValue() {
	    return this.value;
	  }
	  public int getId() {
		    return this.id;
		  }
}

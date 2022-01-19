package com.snehal.carservice.admin.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snehal.carservice.admin.constants.AdminConstants;
import com.snehal.carservice.common.model.Assignment;
import com.snehal.carservice.common.model.AssignmentStatus;
import com.snehal.carservice.common.model.Order;
import com.snehal.carservice.common.model.ProductType;
import com.snehal.carservice.user.service.BookingService;


public class AssignmentDashboard {


	
	public static  List<Assignment> createAllAssignments(List<Order> allorders) {
		List<Assignment> allAssignments=new ArrayList<Assignment>();
	
		for(Order o:allorders) {
				ProductType productType=o.getProduct().getProductType();
				switch(productType) {
				case DAILY_WASH:
					createDailyWashAssignments(o,allAssignments);
				
				case ALTERNATE_WASH:
					createAlternateWashAssignments(o, allAssignments);
					
				case ON_DEMAND_WASH:	
					createOnDemandWashAssignments(o, allAssignments);
				}
		
		}
		return allAssignments;
	}
	
	private static void createDailyWashAssignments(Order o,List<Assignment> allAssignments) {
		
		int count=24;
		
		//should be run before 12 pm on indian server
    	Calendar c=Calendar.getInstance();
    	c.add(Calendar.DATE, 1);
		while(count>0) {
	
			if(!(c.get(Calendar.DAY_OF_WEEK)==1)) {
			Assignment a=new Assignment();
			a.setPriority(0);
			a.setAssignmentStatus(AssignmentStatus.NOT_STARTED);
			a.setOrder(o);
			a.setAssignmentDate(new java.sql.Date(c.getTimeInMillis()));
			allAssignments.add(a);
			count--;
			}
	    	c.add(Calendar.DATE, 1);
		}	
	}
	
	
private static void createAlternateWashAssignments(Order o,List<Assignment> allAssignments) {
		
		int count=12;
		
		//should be run before 12 pm on indian server
    	Calendar c=Calendar.getInstance();
    	c.add(Calendar.DATE, 1);
		while(count>0) {
	    
			if(!(c.get(Calendar.DAY_OF_WEEK)==1)) {
			Assignment a=new Assignment();
			a.setPriority(0);
			a.setAssignmentStatus(AssignmentStatus.NOT_STARTED);
			a.setOrder(o);
			a.setAssignmentDate(new java.sql.Date(c.getTimeInMillis()));
			allAssignments.add(a);
			count--;
			}
			c.add(Calendar.DATE, 2);
		}	
	}
	
private static void createOnDemandWashAssignments(Order o,List<Assignment> allAssignments) {
	

	//should be run before 12 pm on indian server
	Calendar c=Calendar.getInstance();
  
		if(c.get(Calendar.DAY_OF_WEEK)==1) {
			c.add(Calendar.DATE, 1);
		}
		Assignment a=new Assignment();
		a.setPriority(4);
		a.setAssignmentStatus(AssignmentStatus.NOT_STARTED);
		a.setOrder(o);
		a.setAssignmentDate(new java.sql.Date(c.getTimeInMillis()));
		allAssignments.add(a);


		
}
    public static void main(String[] args) throws Exception {
    	
    	Date date =new Date();

    	System.out.println(date);
    	java.sql.Date datesql =new java.sql.Date(date.getTime());
  
    	System.out.println(datesql);	

    	Calendar c=Calendar.getInstance();
    	System.out.println("Calender date::"+c.getTime());
    	System.out.println("Calender date::"+new java.sql.Date(c.getTimeInMillis()));
    	System.out.println(c.get(Calendar.DAY_OF_WEEK));
    	
    	c.roll(Calendar.DATE, true);
    	System.out.println("After UpCalender date::"+c.getTime());
    	System.out.println(c.get(Calendar.DAY_OF_WEEK));
    	c.add(Calendar.DATE, 2);
    	System.out.println("ADD UpCalender date::"+c.getTime());
    	System.out.println(c.get(Calendar.DAY_OF_WEEK));
    }
	
	
}

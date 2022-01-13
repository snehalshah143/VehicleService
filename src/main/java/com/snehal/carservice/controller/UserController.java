package com.snehal.carservice.controller;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.snehal.carservice.common.Status;
import com.snehal.carservice.model.AppUser;
import com.snehal.carservice.model.Booking;
import com.snehal.carservice.model.LoginModel;
import com.snehal.carservice.model.Order;
import com.snehal.carservice.model.UserVehicleDetail;
import com.snehal.carservice.service.AuthenticationService;
import com.snehal.carservice.service.BookingService;
import com.snehal.carservice.service.UserService;
import com.snehal.carservice.util.UserValidator;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;
//    @Autowired
//    private PaymentService paymentService;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private AuthenticationService authenticationService;

/*    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(Model model) {
   //     model.addAttribute("userForm", new User());

        return "registration";
    }*/

    @PostMapping(path = "/usersignup",consumes="application/json")
    public ResponseEntity<Long> userSignUp(@RequestBody AppUser user, BindingResult bindingResult) {
//        userValidator.validate(user, bindingResult);
System.out.println("dateOfBirt::"+user.getDateOfBirth());
       if (bindingResult.hasErrors()) {
    	   System.out.println(bindingResult.getAllErrors().toString());
           return new ResponseEntity (HttpStatus.PRECONDITION_FAILED);
        }

        return new ResponseEntity<Long> (userService.save(user),HttpStatus.OK);


    }

    @PostMapping(path = "/vehicledetails/add/{userid}",consumes="application/json")
    public String addVehicleDetails(@RequestBody UserVehicleDetail userVehicleDetail,@PathVariable("userid") Long userId, BindingResult bindingResult) {
//        userValidator.validate(userVehicleDetail, bindingResult);
//System.out.println("dateOfBirt::"+user.getDateOfBirth());
    	AppUser appUser=userService.findByUserId(userId);
    	userVehicleDetail.setAppUser(appUser);
       if (bindingResult.hasErrors()) {
    	   System.out.println(bindingResult.getAllErrors().toString());
            return Status.FAILURE.toString();
        }

        userService.saveVehicleDetail(userVehicleDetail);

        return "redirect:/bookslot";
    }
    
    @PostMapping(path = "/booking/add/{detailid}",consumes="application/json")
    public String createOrder(@RequestBody Order order,@PathVariable("detailid") Long detailId, BindingResult bindingResult) {
//        userValidator.validate(userVehicleDetail, bindingResult);

    	UserVehicleDetail userVehicleDetail=userService.getUserVehicleDetail(detailId);
    	order.setUserVehicleDetail(userVehicleDetail);

       if (bindingResult.hasErrors()) {
    	   System.out.println(bindingResult.getAllErrors().toString());
            return Status.FAILURE.toString();
        }

        Order result=bookingService.saveOrder(order);

        return ""+result.getOrderId();
    }
    
    @PostMapping(path = "/booking/book/{userid}",consumes="application/json")
    public String createBooking(@RequestBody Booking booking,@PathVariable("userid") Long userId, BindingResult bindingResult) {
//        userValidator.validate(userVehicleDetail, bindingResult);


       if (bindingResult.hasErrors()) {
    	   System.out.println(bindingResult.getAllErrors().toString());
            return Status.FAILURE.toString();
        }
      	AppUser appUser=userService.findByUserId(userId);
      	booking.setAppUser(appUser);
      	Set<Order> orderListUpdated=new HashSet<Order>();
       for(Order order:booking.getProductCart()) {
    		   order=saveOrder(order);
    	   if(order!=null) {
    		   orderListUpdated.add(order);
    	   }
       }
       booking.setProductCart(orderListUpdated);
       Booking result=bookingService.saveBooking(booking);
//       PaymentResult success=paymentService.makepayment(result.getBookingId(),result.getFinalAmount());
        return ""+result.getBookingId();
    }
    
    public Order saveOrder(Order order) {
    	
    	UserVehicleDetail userVehicleDetail=userService.getUserVehicleDetail(order.getUserVehicleDetail().getDetailId());
    	order.setUserVehicleDetail(userVehicleDetail);

        Order result=bookingService.saveOrder(order);
        return result;
    }
    
    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public boolean login(@RequestBody LoginModel loginModel ,  BindingResult bindingResult) {
    	//Populate Message and Response Body

        return authenticationService.authenticateUser(loginModel);
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
    	//Populate Message and Response Body

        return "Welcome Washs";
    }

}
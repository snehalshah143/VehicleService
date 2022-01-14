package com.snehal.carservice.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.snehal.carservice.cache.BootStrapCache;
import com.snehal.carservice.common.Status;
import com.snehal.carservice.model.AppUser;
import com.snehal.carservice.model.Booking;
import com.snehal.carservice.model.LoginModel;
import com.snehal.carservice.model.Order;
import com.snehal.carservice.model.Product;
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
           return new ResponseEntity (HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Long> (userService.save(user),HttpStatus.OK);


    }

    @PostMapping(path = "/vehicledetails/add/{userid}",consumes="application/json")
    public ResponseEntity<Long> addVehicleDetails(@RequestBody UserVehicleDetail userVehicleDetail,@PathVariable("userid") Long userId, BindingResult bindingResult) {
//        userValidator.validate(userVehicleDetail, bindingResult);
//System.out.println("dateOfBirt::"+user.getDateOfBirth());
    	AppUser appUser=userService.findByUserId(userId);
    	userVehicleDetail.setAppUser(appUser);
       if (bindingResult.hasErrors()) {
    	   System.out.println(bindingResult.getAllErrors().toString());
           return new ResponseEntity (HttpStatus.BAD_REQUEST);
          
        }

       UserVehicleDetail vehicleDetail=userService.saveVehicleDetail(userVehicleDetail);

        return new ResponseEntity<Long> (vehicleDetail.getDetailId(),HttpStatus.OK);
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
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking,@PathVariable("userid") Long userId, BindingResult bindingResult) {
//        userValidator.validate(userVehicleDetail, bindingResult);


       if (bindingResult.hasErrors()) {
    	   System.out.println(bindingResult.getAllErrors().toString());
       
            return new ResponseEntity (HttpStatus.BAD_REQUEST);
        }
      	AppUser appUser=userService.findByUserId(userId);
      	booking.setAppUser(appUser);

      	Booking result=bookAndSaveOrders(booking);

//       PaymentResult success=paymentService.makepayment(result.getBookingId(),result.getFinalAmount());
        return new ResponseEntity (result,HttpStatus.OK);
    }
     
    //Save booking as usual and then update bookingIDs
    private Booking bookAndSaveOrders(Booking booking) {
    	 Booking result=bookingService.saveBooking(booking); 
    	 if(result!=null) {
     	Set<Order>productCart=booking.getProductCart();
     	List<Long> orderIds=productCart.stream().map(Order::getOrderId).toList();
     	List<Order> orderTobeUpdated=bookingService.getOrders(orderIds);
     	ArrayList<Order> orderListUpdated=new ArrayList<Order>();
     	 for(Order order:orderTobeUpdated) {
     		order.setBooking(booking);
     	  	UserVehicleDetail userVehicleDetail=userService.getUserVehicleDetail(order.getUserVehicleDetail().getDetailId());
        	order.setUserVehicleDetail(userVehicleDetail);
       	   Product product=BootStrapCache.getProductCache().get(order.getProduct().getProductId());
    	   order.setProduct(product);
    	   orderListUpdated.add(order);
     	 }
     	bookingService.saveOrders(orderListUpdated);
    	 }
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
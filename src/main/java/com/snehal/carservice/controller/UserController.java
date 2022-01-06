package com.snehal.carservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
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
import com.snehal.carservice.model.Order;
import com.snehal.carservice.model.UserVehicleDetail;
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

/*    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(Model model) {
   //     model.addAttribute("userForm", new User());

        return "registration";
    }*/

    @PostMapping(path = "/register",consumes="application/json")
    public String registration(@RequestBody AppUser user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
System.out.println("dateOfBirt::"+user.getDateOfBirth());
       if (bindingResult.hasErrors()) {
    	   System.out.println(bindingResult.getAllErrors().toString());
            return Status.FAILURE.toString();
        }

        userService.save(user);

        return "redirect:/welcome";
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

       Booking result=bookingService.saveBooking(booking);
//       PaymentResult success=paymentService.makepayment(result.getBookingId(),result.getFinalAmount());
        return ""+result.getBookingId();
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}
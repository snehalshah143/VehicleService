package com.snehal.carservice.controller;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.snehal.carservice.cache.BootStrapCache;
import com.snehal.carservice.common.status.Status;
import com.snehal.carservice.common.util.UserValidator;
import com.snehal.carservice.constants.AdminConstants;
import com.snehal.carservice.mapper.AppuserMappers;
import com.snehal.carservice.mapper.BookingMappers;
import com.snehal.carservice.mapper.UserVehicleDetailMappers;
import com.snehal.carservice.model.domain.LoginModel;
import com.snehal.carservice.model.dto.AppUserJsonDto;
import com.snehal.carservice.model.dto.BookingJsonDto;
import com.snehal.carservice.model.dto.PaymentNotifyRequest;
import com.snehal.carservice.model.dto.UserSignUpRequest;
import com.snehal.carservice.model.dto.UserVehicleDetailJsonDto;
import com.snehal.carservice.model.persistable.AppUserPersistable;
import com.snehal.carservice.model.persistable.AssignmentPersistable;
import com.snehal.carservice.model.persistable.BookingPersistable;
import com.snehal.carservice.model.persistable.OrderPersistable;
import com.snehal.carservice.model.persistable.PaymentPersistable;
import com.snehal.carservice.model.persistable.ProductPersistable;
import com.snehal.carservice.model.persistable.UserVehicleDetailPersistable;
import com.snehal.carservice.model.persistable.VehiclePersistable;
import com.snehal.carservice.service.AssignmentService;
import com.snehal.carservice.service.AuthenticationService;
import com.snehal.carservice.service.BookingService;
import com.snehal.carservice.service.PaymentService;
import com.snehal.carservice.service.UserService;
import com.snehal.carservice.service.VehicleService;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private AuthenticationService authenticationService;
    
    @Autowired
	private AssignmentService assignmentService;
    
    @Autowired
    private VehicleService vehicleService;

    private UserVehicleDetailMappers userVehicleDetailMapper=UserVehicleDetailMappers.getUserVehicleDetailMappers();
    private BookingMappers bookingMapper=BookingMappers.getBookingMappers();


    @PostMapping(path = "/usersignup",consumes="application/json")
    public ResponseEntity<?> userSignUp(@RequestBody UserSignUpRequest request, BindingResult bindingResult) {
    	
    	   if(!userService.verifyPassword(request)) {
    		   
    		     return new ResponseEntity<String> ("Password and Password Confirm Not Matching",HttpStatus.EXPECTATION_FAILED);
    	   }
    	   AppUserPersistable user=AppuserMappers.getAppuserMappers().mapSignUpRequestToPersistable(request);
        userValidator.validate(user, bindingResult);
       if (bindingResult.hasErrors()) {
    	   System.out.println(bindingResult.getAllErrors().toString());
           return new ResponseEntity (bindingResult.getAllErrors(),HttpStatus.BAD_REQUEST);
        }
        user.setUsername(user.getMobileNumber());
        AppUserPersistable appUser=userService.save(user);
        AppUserJsonDto jsonDto=AppuserMappers.getAppuserMappers().mapPersistableToJsonDto(appUser);
        return new ResponseEntity<AppUserJsonDto> (jsonDto,HttpStatus.OK);
   


    }

    @PostMapping(path = "/vehicledetails/add/{userid}",consumes="application/json")
    public ResponseEntity<UserVehicleDetailJsonDto> addVehicleDetails(@RequestBody UserVehicleDetailPersistable userVehicleDetail,@PathVariable("userid") Long userId, BindingResult bindingResult) {

    	AppUserPersistable appUser=userService.findByUserId(userId);
    	userVehicleDetail.setAppUser(appUser);
    	
    	VehiclePersistable vehicle=vehicleService.getVehicle(userVehicleDetail.getVehicle().getVehicleId());
    	userVehicleDetail.setVehicle(vehicle);
       if (bindingResult.hasErrors()) {
    	   System.out.println(bindingResult.getAllErrors().toString());
           return new ResponseEntity (HttpStatus.BAD_REQUEST);
          
        }

       UserVehicleDetailPersistable vehicleDetail=userService.saveVehicleDetail(userVehicleDetail);

       UserVehicleDetailJsonDto jsonDto= UserVehicleDetailMappers.getUserVehicleDetailMappers().mapPersistableToJsonDto(vehicleDetail);
        return new ResponseEntity<UserVehicleDetailJsonDto> (jsonDto,HttpStatus.OK);
    }
    @GetMapping(path = "/vehicledetails/get/{userid}")
    public ResponseEntity<List<UserVehicleDetailJsonDto>> getUserVehicleDetailsForUserId(@PathVariable("userid") Long userId){
    	
        List<UserVehicleDetailPersistable> vehicleDetails=userService.getUserVehicleDetailsForUserId(userId);
List<UserVehicleDetailJsonDto> vehicleDetailsJsonDtoList=new ArrayList<UserVehicleDetailJsonDto>();
for(UserVehicleDetailPersistable p:vehicleDetails) {
	vehicleDetailsJsonDtoList.add(userVehicleDetailMapper.mapPersistableToJsonDto(p));
}

        return new ResponseEntity<List<UserVehicleDetailJsonDto>> (vehicleDetailsJsonDtoList,HttpStatus.OK);
    }
    

//Currently not used    
    @PostMapping(path = "/booking/add/{detailid}",consumes="application/json")
    public String createOrder(@RequestBody OrderPersistable order,@PathVariable("detailid") Long detailId, BindingResult bindingResult) {
//        userValidator.validate(userVehicleDetail, bindingResult);

    	UserVehicleDetailPersistable userVehicleDetail=userService.getUserVehicleDetail(detailId);
    	order.setUserVehicleDetail(userVehicleDetail);

       if (bindingResult.hasErrors()) {
    	   System.out.println(bindingResult.getAllErrors().toString());
            return Status.FAILURE.toString();
        }

        OrderPersistable result=bookingService.saveOrder(order);

        return ""+result.getOrderId();
    }
    
    @PostMapping(path = "/booking/book/{userid}",consumes="application/json")
    public ResponseEntity<BookingJsonDto> createBooking(@RequestBody BookingPersistable booking,@PathVariable("userid") Long userId, BindingResult bindingResult) {
//        userValidator.validate(userVehicleDetail, bindingResult);


       if (bindingResult.hasErrors()) {
    	   System.out.println(bindingResult.getAllErrors().toString());
       
            return new ResponseEntity (HttpStatus.BAD_REQUEST);
        }
      	AppUserPersistable appUser=userService.findByUserId(userId);
      	booking.setAppUser(appUser);
      
      	BookingPersistable result=bookAndSaveOrders(booking);
   
//       PaymentResult success=paymentService.makepayment(result.getBookingId(),result.getFinalAmount());
        return new ResponseEntity (bookingMapper.mapPersistableToJsonDto(result),HttpStatus.OK);
    }
     
    //Save booking as usual and then update bookingIDs
    private BookingPersistable bookAndSaveOrders(BookingPersistable booking) {
    	BookingPersistable result=bookingService.saveBooking(booking); 
    	 if(result!=null) {
     	Set<OrderPersistable>productCart=booking.getProductCart();
     	List<Long> orderIds=productCart.stream().map(OrderPersistable::getOrderId).toList();
     	List<OrderPersistable> orderTobeUpdated=bookingService.getOrders(orderIds);
     	ArrayList<OrderPersistable> orderListUpdated=new ArrayList<OrderPersistable>();
     	 for(OrderPersistable order:orderTobeUpdated) {
     		order.setBooking(booking);
     	  	UserVehicleDetailPersistable userVehicleDetail=userService.getUserVehicleDetail(order.getUserVehicleDetail().getDetailId());
        	order.setUserVehicleDetail(userVehicleDetail);
       	   ProductPersistable product=BootStrapCache.getProductCache().get(order.getProduct().getProductId());
    	   order.setProduct(product);
//New Part Not working efficientkly Very Slow  will display assigmnets in response
//    	   createAssignmentsForOrder(order);
//New Part
    	   orderListUpdated.add(order);
     	 }
     	bookingService.saveOrders(orderListUpdated);
     	//TODO::This creation of assignments can be done inside for loop for all orders one by one  and same can be updated in orders list before updating order.This will make sense wwhen we make inserting of orders an asyncronuous process by introducing blocking queue 
     	//Also introducting future.get to know the status of insertion operation
     	assignmentService.createAssigmentsAndUpdatedStatusForOrders(orderListUpdated);
    	 }
    	 return result;
    	
    }

	private void createAssignmentsForOrder(OrderPersistable order) {
		List<AssignmentPersistable> allAssignments=assignmentService.createAssigmentsAndUpdateStatusForOrder(order);
    	   order.setAssignments(new HashSet(allAssignments));
   		   order.setOrderStatus(AdminConstants.ASSIGNED);
	}
    
    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public ResponseEntity<AppUserJsonDto> login(@RequestBody LoginModel loginModel ,  BindingResult bindingResult) {
    	//Populate Message and Response Body

    	AppUserPersistable user=authenticationService.authenticateUser(loginModel);
    	
    	if(user==null) {
    		   return new ResponseEntity (HttpStatus.BAD_REQUEST);
    	}
        return new ResponseEntity (AppuserMappers.getAppuserMappers().mapPersistableToJsonDto(user),HttpStatus.OK);
    }

    @RequestMapping(value = "/notifypayment", method = RequestMethod.POST)
    public ResponseEntity<Boolean> notifyPayment(@RequestBody PaymentNotifyRequest paymentNotifyRequest ,  BindingResult bindingResult) {
    	//Populate Message and Response Body


    	PaymentPersistable persistable=paymentService.fetchPaymentInfoFromPaymentGateway(paymentNotifyRequest.getPaymentId());
    	BookingPersistable booking=bookingService.getBooking(paymentNotifyRequest.getBookingId());
    	persistable.setBooking(booking);
    	PaymentPersistable finalPersistable=paymentService.savePayment(persistable);
    	booking.setPaymentStatus(finalPersistable.getPaymentStatus());
    	bookingService.saveBooking(booking);
    
        return new ResponseEntity (finalPersistable==null?false:true,HttpStatus.OK);
    }

    @GetMapping(path = "/admin/booking/getall/{userid}")
    public ResponseEntity<BookingJsonDto> getAllBookingsForUser(@PathVariable("userid") Long userId) {


      	List<BookingJsonDto> bookings=bookingService.getAllBookingsForUserId(userId);

        return new ResponseEntity (bookings,HttpStatus.OK);
    }

    
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
    	//Populate Message and Response Body

        return "Welcome Washs";
    }
    
    @PostMapping(path = "/admin/systemshutdown")
    public void systemShutdown() {
System.out.println("Shutting Down System!");
System.exit(0);
    }


}
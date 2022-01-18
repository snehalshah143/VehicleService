package com.snehal.carservice.chartink;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChartinkController {

	
	
	
    @PostMapping(path = "/triggerAlertAQCXZ",consumes="application/json")
    public void alertsRecived(@RequestBody Alert alert) {
    	System.out.println(alert.toString());
		/*
		 * ObjectMapper mapper=new ObjectMapper(); try { Alert a=mapper.readValue(alert,
		 * Alert.class); System.out.println(a); } catch (JsonProcessingException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */




    }
}

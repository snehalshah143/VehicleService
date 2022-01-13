package com.snehal.carservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.snehal.carservice.cache.BootStrapCache;

@SpringBootApplication
public class WashWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WashWebApplication.class, args);

	}

	
	
}

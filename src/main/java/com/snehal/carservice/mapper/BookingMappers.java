package com.snehal.carservice.mapper;

import java.util.HashSet;
import java.util.Set;

import com.snehal.carservice.model.domain.Booking;
import com.snehal.carservice.model.dto.AppUserJsonDto;
import com.snehal.carservice.model.dto.BookingJsonDto;
import com.snehal.carservice.model.dto.OrderJsonDto;
import com.snehal.carservice.model.persistable.AppUserPersistable;
import com.snehal.carservice.model.persistable.BookingPersistable;
import com.snehal.carservice.model.persistable.OrderPersistable;

public class BookingMappers extends AbstarctMapper<BookingJsonDto, Booking, BookingPersistable>{

	private static BookingMappers bookingMappers=new BookingMappers();

	public static BookingMappers getBookingMappers() {
		return bookingMappers;
	}

	public BookingJsonDto  mapPersistableToJsonDto(BookingPersistable persistable) {
		
		BookingJsonDto jsonDto=new BookingJsonDto();
		jsonDto.setBookingId(persistable.getBookingId());
		jsonDto.setFinalAmount(persistable.getFinalAmount());
		AppUserPersistable appUserPersistable=persistable.getAppUser();
		AppUserJsonDto appUserJsonDto=new AppUserJsonDto();
		appUserJsonDto.setUserId(persistable.getAppUser().getId());
		jsonDto.setAppUser(appUserJsonDto);
		Set<OrderJsonDto> orderJsonDtos=new HashSet<OrderJsonDto>(); 
		for(OrderPersistable o:persistable.getProductCart()) {
			orderJsonDtos.add(OrderMappers.getOrderMappers().mapPersistableToJsonDto(o));
		}
		jsonDto.setProductCart(orderJsonDtos);
		return jsonDto;
		
	}

}

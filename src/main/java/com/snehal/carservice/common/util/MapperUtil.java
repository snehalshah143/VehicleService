package com.snehal.carservice.common.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class MapperUtil<T> {

	
//	public static  <T>Object convertToEntity(String dbJson) {
	public T convertToEntity(String dbJson) {

		T object = null;
		if(dbJson!=null) {
			ObjectMapper mapper = new ObjectMapper();
		try {
			object=mapper.readValue(dbJson, new TypeReference<T>() {});
	
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mapper=null;
		}


		
		return object;
	}
	
//	public static <T> String convertToString(T t) {
     public   String convertToString(T t) {
		
		ObjectMapper mapper = new ObjectMapper();
		String result=null;
		if(t!=null) {
		try {
			result = mapper.writeValueAsString(t);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		mapper=null;
		return result;
	}
}

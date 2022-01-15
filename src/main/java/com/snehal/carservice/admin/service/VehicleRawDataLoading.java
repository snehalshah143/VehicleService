package com.snehal.carservice.admin.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

public class VehicleRawDataLoading {
	
	@Autowired
	private VehicleService vehicleService;
	
	public static void loadVehicleRawData() {
		
        try {
            URL url = new URL("https://parseapi.back4app.com/classes/Car_Model_List_Honda?limit=10");
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestProperty("X-Parse-Application-Id", "hlhoNKjOvEhqzcVAJ1lxjicJLZNVv36GdbboZj3Z"); // This is the fake app's application id
            urlConnection.setRequestProperty("X-Parse-Master-Key", "SNMJJF0CZZhTPhLDIqGhTlUNV9r60M2Z5spyWfXW"); // This is the fake app's readonly master key
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
    //                System.out.println(line);
                }
                JSONObject data = new JSONObject(stringBuilder.toString()); // Here you have the data that you need
                ObjectMapper mapper=new ObjectMapper();
    //            System.out.println(data.getJSONArray("results").toString());
                ArrayList<VehicleRawData> vehicles=mapper.readValue(data.getJSONArray("results").toString(), ArrayList.class);
                System.out.println("ArrayLit::"+vehicles.toString());
                System.out.println(vehicles.size());
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
	}
	
    public static void main(String[] args) throws Exception {
        try {
            URL url = new URL("https://parseapi.back4app.com/classes/Car_Model_List_Honda?limit=10");
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestProperty("X-Parse-Application-Id", "hlhoNKjOvEhqzcVAJ1lxjicJLZNVv36GdbboZj3Z"); // This is the fake app's application id
            urlConnection.setRequestProperty("X-Parse-Master-Key", "SNMJJF0CZZhTPhLDIqGhTlUNV9r60M2Z5spyWfXW"); // This is the fake app's readonly master key
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
    //                System.out.println(line);
                }
                JSONObject data = new JSONObject(stringBuilder.toString()); // Here you have the data that you need
                ObjectMapper mapper=new ObjectMapper();
    //            System.out.println(data.getJSONArray("results").toString());
                ArrayList<VehicleRawData> vehicles=mapper.readValue(data.getJSONArray("results").toString(), ArrayList.class);
                System.out.println("ArrayLit::"+vehicles.toString());
                System.out.println(vehicles.size());
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}

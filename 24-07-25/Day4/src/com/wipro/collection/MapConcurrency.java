package com.wipro.collection;

import java.util.Map;
import java.util.TreeMap;

public class MapConcurrency {

	public static void main(String[] args) {
		Map<String, String> currencyMap = new TreeMap<>();
		currencyMap.put("USD", "United States Dollar");
        currencyMap.put("INR", "Indian Rupee");
        currencyMap.put("EUR", "Euro");
        
        for(Map.Entry<String,String>data: currencyMap.entrySet()) {
        	
        	System.out.println(data.getKey()+"-"+data.getValue());
        }
	}
}

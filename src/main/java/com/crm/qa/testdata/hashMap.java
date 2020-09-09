package com.crm.qa.testdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class hashMap {
	
	static ArrayList<String> al;
	public static void m1(ArrayList<String> al)
	{
		
		System.out.println("Index 0 and 1 is "+al.get(0) + " " + al.get(1));
	}
	
	public static void main(String [] args)
	{
		HashMap<String,ArrayList<String>> h1 = new HashMap<String, ArrayList<String>>();
		HashMap<String,String> h3 = new HashMap<String,String>();
		Object[][] obj = new Object[3][1];
		h3.put("firstname","Samarth");
		obj[0][0]= h3;
		h3.put("lastname","Jain");
		obj[1][0]= h3;
		h3.put("firstname","Sammy");
		obj[2][0]= h3;
		Map<Object,Object> h2 = obj;
		al = new ArrayList<String>();
		al.add("A");
		al.add("B");
		al.add("C");
		
		h1.put("Refunds",al);	
		System.out.println("Hashmap h is : "+h1);
		m1(al);
	}
	
	

}

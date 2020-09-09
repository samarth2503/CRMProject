package com.org.TestngAttributes;

import org.testng.annotations.Test;

public class Grouping {
 
	 @Test(groups = { "car", "ecar" })            
	    public void car() {
	        System.out.println("Car");
	    }
	   @Test(groups = { "car", "sedan" })
	    public void car1() {
	        System.out.println("Car1");
	    }
	   @Test(groups = { "fcar" })
	    public void car2() {
	        System.out.println("Car2");
	    }
}

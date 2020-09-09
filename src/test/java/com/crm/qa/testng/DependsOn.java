package com.crm.qa.testng;

import org.testng.annotations.Test;

public class DependsOn {
	@Test
    public void login() 
    {
        System.out.println("Code to login into the AUT");
    }
    @Test(dependsOnMethods = { "login" },groups="sedan")
    public void dashboard()
    {
        System.out.println("Dashboard Page");
    }
   @Test(dependsOnMethods = { "dashboard" })
    public void logout() 
    {
        System.out.println("Logout from the application");
    }
   
   @Test(groups="sedan")
   public void SignIn() 
   {
       System.out.println("SignIn into the application");
   }
   
   @Test(invocationCount=2,groups="Smoke")								/// To Execute test multiple times
	public void sum()
	{
		int a=10;
		int b= 20;
		int c=a+b;
		System.out.println("a+b****"+c);
	}
	
	@Test(expectedExceptions=NumberFormatException.class)				// Exception in testng
	public void test1()
	{
		String s = "100A";
		Integer.parseInt(s); 
	}
}

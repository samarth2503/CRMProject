package com.org.TestngAttributes;

import org.testng.annotations.Test;

public class Priority {
	
	@Test(priority = 2)
	public void test01() 
	{
		System.out.println("Inside Test01 Method");
	}
	@Test(priority = 0,enabled=false)
	public void test02() 
	{
		System.out.println("Inside Test02 Method");
	}
	@Test(priority = 1)
	public void test03()
	{
		System.out.println("Inside Test03 Method");
	}
}


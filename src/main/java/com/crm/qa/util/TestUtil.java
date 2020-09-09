package com.crm.qa.util;

import java.util.ArrayList;

public class TestUtil {
	
	public static ExcelReader er;
	public static ArrayList<Object[]> getdataFromExcel()
	{
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		
		try {
			er = new ExcelReader("D:\\Selenium WorkSpace\\FreeCRMTest\\src\\main\\java\\com\\crn\\qa\\util\\Excel_Utility.xlsx");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		for(int i=1; i<=er.getRowCount("UserDetails");i++)
		{
			String data1 = er.getCellData("UserDetails", "Username", i+1);
			String data2 = er.getCellData("UserDetails", "Password", i+1);
			
			mydata.add(new Object[] {data1,data2});
		}
		return mydata;
	}

}

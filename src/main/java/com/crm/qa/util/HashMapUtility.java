package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.crm.qa.util.*;

public class HashMapUtility{
	

	public XSSFWorkbook workbook;
	public FileInputStream f1;
	public XSSFSheet sheet;
	
	public HashMapUtility() throws IOException
	{
		
		try {
			f1= new FileInputStream("C:\\Users\\ADMIN\\Desktop\\Utility.xlsx");
			workbook = new XSSFWorkbook(f1);
			sheet=workbook.getSheetAt(0);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

}
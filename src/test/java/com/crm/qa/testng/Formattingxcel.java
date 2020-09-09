package com.crm.qa.testng;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Formattingxcel {
	
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException
	{
		String filepath="C:\\Users\\ADMIN\\Desktop\\Multi.xlsx";
		try {
			
			fis = new FileInputStream(filepath);
			
			workbook= new XSSFWorkbook(fis);
			sheet=workbook.getSheetAt(0);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		XSSFCell cell = sheet.createRow(0).createCell(2);
		
		XSSFCellStyle style = workbook.createCellStyle();
		
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		cell.setCellStyle(style);
		
		FileOutputStream out = new FileOutputStream(new File("C:\\Users\\ADMIN\\Desktop\\Multi.xlsx"));
	      workbook.write(out);
	      out.close();
	      System.out.println("cellstyle.xlsx written successfully");
		
	}


}

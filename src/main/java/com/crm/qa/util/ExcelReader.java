package com.crm.qa.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;
	
	public ExcelReader(String filepath) throws IOException
	{
		
		
		try {
			
			fis = new FileInputStream(filepath);
			
			workbook= new XSSFWorkbook(fis);
			sheet=workbook.getSheetAt(0);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	
	}
	
	
	
	public String getData(String sheetNum,int rownum, int colnum)
	{
		//sheet=wb.getSheet(sheetNum);
		String data=sheet.getRow(rownum).getCell(colnum).getStringCellValue();

		return data;
	}
	
	public int getRowCount(String sheetName)
	{
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
		{
			return 0;
		}
		else
		{
			sheet=workbook.getSheetAt(index);
			String s=sheet.getSheetName();
			int number=sheet.getLastRowNum();
			return number;
		}
	}
	
	public String getCellData(String sheetname, String colName, int rowNum)
	{
		
			
		
		if (rowNum<0)
		{
			return "";
		}
		int index = workbook.getSheetIndex(sheetname);

		int col_Num=-1;
		if(index==-1)
		{
			return "";
		}

		sheet= workbook.getSheetAt(index);
		row=sheet.getRow(0);

		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals(colName))
			{
				col_Num=i;
			}
		}

		if(col_Num==-1)
		{
			return "";
		}

		sheet=workbook.getSheetAt(index);
		row=sheet.getRow(rowNum-1);

		if(row==null)
			return "";
		cell = row.getCell(col_Num);
		if(cell==null)
		{
			return "";
		}
		else
		{
			return cell.getStringCellValue();
		}
	}

	public boolean setCellData(String sheetname,String colname,int rowNum,String data,String path) throws FileNotFoundException
	{

		try {

			int colnum=-1;
			if(rowNum<0)
			{
				return false;
			}

			int index = workbook.getSheetIndex(sheetname);
			sheet = workbook.getSheetAt(index);
			if(index==-1)
			{
				return false;
			}

			row=sheet.getRow(0);

			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(colname))
				{
					colnum=i;
				}
				
			}

			if(colnum==-1)
			{
				return false;
			}

			row=sheet.getRow(rowNum-1);
			if(row==null)
			{
				row=sheet.createRow(rowNum-1);
			}

			cell=row.getCell(colnum);
			if(cell==null)
			{
				row.createCell(colnum);
			}
			
			row.getCell(colnum).setCellValue(data);
			System.out.println("The value is:"+row.getCell(colnum));
			fileOut=new FileOutputStream(path);

			workbook.write(fileOut);

			fileOut.close();

		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}

		return true;



	}
		
	public boolean isSheetExist(String sheetname)
	{
		int index = workbook.getSheetIndex(sheetname);
		if(index==-1)
		{
			index = workbook.getSheetIndex(sheetname.toUpperCase());
			if(index ==-1)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			return true;
		}
	}
	
	public int getColumncount(String sheetname)
	{
		int index = workbook.getSheetIndex(sheetname);
		
		if(!isSheetExist(sheetname))
		{
			return -1;
		}
		
		sheet=workbook.getSheet(sheetname);
		
		row=sheet.getRow(0);
		
		if(row==null)
		{
			return -1;
		}
		
		int column_count= row.getLastCellNum();
		return column_count;
	}
	
	public int getCellRownum(String sheetname,String colName,String cellData)
	{
		int index = workbook.getSheetIndex(sheetname);
		
		if(index==-1)
		{
			return -1;
		}
		
		row=sheet.getRow(0);
		for(int i=1;i<=getRowCount(sheetname);i++)
		{
			if(getCellData(sheetname,colName,i).equals(colName))
			{
				return i;
			}
		}
		return -1;
	}
	
	public String getSheet(int i)
	{
		sheet = workbook.getSheetAt(i);
		
		if(sheet==null)
		{
			return "";
		}
		
		return sheet.toString();
		
		
	}
	
//	public void setSheetName(XSSFSheet sheet)
//	{
//		
//		this.sheet=sheet;
//	}
	
	public XSSFSheet getSheetName()
	{
		return this.sheet;
	}
}

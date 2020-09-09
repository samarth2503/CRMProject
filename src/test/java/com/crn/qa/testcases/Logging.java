package com.crn.qa.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class Logging {
	
	static Logger log = Logger.getLogger(Logging.class.getName());

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		PropertyConfigurator.configure("log4j.properties");
//		File f = new File("C:\\samarth\\application.log");
//				
//		if(f.exists())
//		{
//			System.out.println("file exists");
//			
//			boolean b=f.delete();
//			if(b)
//			{
//				System.out.println("File is deleted");
//				f.createNewFile();
//				f.
//			}
//			
//		}
		
		log.debug("This is debug");
		log.info("this is info");
	}
}

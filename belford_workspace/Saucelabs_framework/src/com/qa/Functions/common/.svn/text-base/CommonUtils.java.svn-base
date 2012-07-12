package com.qa.Functions.common;

import java.util.Date;
import java.util.Properties;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CommonUtils {
	public static String getDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}
	
	public static void waitForChangesToReflect(int timeInSeconds){
		try {
			System.out.println("System is waiting for "+ timeInSeconds+" Seconds");
			Thread.sleep((timeInSeconds * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	
	/*
	 * This Utility functions is used to read the data from ini file
	 *
	 *  
	 */
	public static String readIni(String str_FileName, String str_KeyName)
	{
		String str_FilePath;
		str_FilePath=System.getProperty("user.dir") + "\\src\\com\\qa\\Config\\" + str_FileName;
		try
		{
			Properties pro = new Properties();
			pro.load(new FileInputStream(str_FilePath));
			return pro.getProperty(str_KeyName);
		}
		catch(Exception ex)
		{
			return "NULL" ;
		}
		
	}

	public static void writeIni(String str_FileName, String str_KeyName, String str_Value)
	{
		String str_FilePath;
		str_FilePath=System.getProperty("user.dir") + "\\src\\com\\qa\\Config\\" + str_FileName;
		try
		{
			Properties pro = new Properties();
			pro.load(new FileInputStream(str_FilePath));
			pro.setProperty(str_KeyName, str_Value);
		}
		catch(Exception ex)
		{
		}
		
	}
	public static void writeIni(String str_FileName, String str_KeyName, int int_Value)
	{
		String str_FilePath;
		str_FilePath=System.getProperty("user.dir") + "\\src\\com\\qa\\Config\\" + str_FileName;
		try
		{
			Properties pro = new Properties();
			pro.load(new FileInputStream(str_FilePath));
			pro.setProperty(str_KeyName, Integer.toString(int_Value));
		}
		catch(Exception ex)
		{
		}
		
	}
	public static int toInt(String str_String)
	{
	    try
	    {
	      // the String to int conversion happens here
	      int i = Integer.parseInt(str_String.trim());
	      return(i);
	    }
	    catch (NumberFormatException nfe)
	    {
	      System.out.println("NumberFormatException: " + nfe.getMessage());
	    }
	    return(0);
	}
	
	public static void updateBuildParameter()
	{
		int value = toInt(readIni("Environment.ini", "Build_Number"));
		value=value+1;
		writeIni("Environment.ini", "Build_Number", value);
		commitFile();	
		
	}
	
	public static void commitFile()
	{
		String str_FilePath;
		str_FilePath=System.getProperty("user.dir");
		String cmdString = readIni("Environment.ini", "SVN_CLIENT")+" commit " + str_FilePath+" -m updated";
		System.out.println("CommandString: " + cmdString);
		String[] cmd = {"cmd.exe", "/C", cmdString};
		try{
			RunWindowCommand runWndCmdObj = new RunWindowCommand();
			runWndCmdObj.runWndCommand(cmd, true);
		}
		catch(Exception e)
		{
			System.out.println("Could not commit file");
		}
		
	}
}


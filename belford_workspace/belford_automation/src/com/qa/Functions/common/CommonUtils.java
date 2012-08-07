package com.qa.Functions.common;

import java.util.Date;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import org.ini4j.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class CommonUtils {
	/*
	 * This Utility function is used to find the current date and time of system.
	 *
	 *  
	 */
public static String getCurrentDateTime () {
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}
	/*
	 * This Utility function is used to wait for the given interval.
	 *
	 *  
	 */
public static void waitForChangesToReflect(int timeInSeconds){
		try {
			System.out.println("System is waiting for "+ timeInSeconds+" Seconds");
			Thread.sleep((timeInSeconds * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/*
	 * This Utility function is used to read the data from ini file
	 *
	 *  
	 */
public static String readIni(String str_FileName, String str_KeyName)
	{
		String str_FilePath;
		str_FilePath=System.getProperty("user.dir") + "/src/com/qa/Config/" + str_FileName;
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
	/*
	 * This Utility functions is used to write the String data to ini file
	 *
	 *  
	 */
public static void writeIni(String str_FileName, String Section, String str_KeyName, String str_Value)
	{
		String str_FilePath;
		str_FilePath=System.getProperty("user.dir") + "/src/com/qa/Config/" + str_FileName;
		try
		{
			Ini ini=new Ini(new FileInputStream(str_FilePath));
			ini.put(Section, str_KeyName, str_Value);
			ini.store(new FileOutputStream(str_FilePath));
		}
		catch(Exception ex)
		{
		}
		
	}
	/*
	 * This Utility functions is used to write the integer data to ini file
	 *
	 *  
	 */
public static void writeintIni(String str_FileName, String Section, String str_KeyName, int int_Value)
	{
		String str_FilePath;
		str_FilePath=System.getProperty("user.dir") + "/src/com/qa/Config/" + str_FileName;
		try
		{
			Ini ini=new Ini(new FileInputStream(str_FilePath));
			ini.put(Section, str_KeyName, int_Value);
			ini.store(new FileOutputStream(str_FilePath));
		}
		catch(Exception ex)
		{
		}
		
		
	}
	/*
	 * This Utility functions is used to  convert the String to int
	 *
	 *  
	 */
public static int toInt(String str_String)
	{
	    try
	    {
	      int i = Integer.parseInt(str_String.trim());
	      return(i);
	    }
	    catch (NumberFormatException nfe)
	    {
	      System.out.println("NumberFormatException: " + nfe.getMessage());
	    }
	    return(0);
	}
	/*
	 * This Utility functions is used to update the build parameter
	 *
	 *  
	 */	
public static void updateBuildParameter()
	{
		int value = toInt(readIni("Environment.ini", "Build_Number"));
		value=value+1;
		writeintIni("Environment.ini","", "Build_Number", value);
//		commitFile();	
		
	}
	/*
	 * This Utility functions is used to generate a random number
	 *
	 *  
	 */	
public static int generateRandomNumber()
	{
		Random rand = new Random();
		return rand.nextInt(10000);

	}
	/*
	 * This Utility functions is used to update the application number
	 *
	 *  
	 */	
public static void UpdateConfigAppNo()
	{
		int value = toInt(readIni("TestData.ini", "Config_App_Number"));
		value=value+1;
		writeintIni("TestData.ini", "Others", "Config_App_Number", value);
		System.out.println("Application number is updated");
	}
	/**
	 * This function Changes the status of the test cases to Passed/Failed
	 * @param testcaseid  Test case id of the test case.
	 * @param status marks the status of testcase ID as Pass/Fail/
	 **/
	public static void tcmsReport(String testcaseid, String status)
	{
		try 
		{
			XmlRpcClient rpcClient;
			XmlRpcClientConfigImpl config;
			
			config = new XmlRpcClientConfigImpl();
			config.setServerURL(new URL(CommonUtils.readIni("Environment.ini", "str_TCMSURL")));
			rpcClient = new XmlRpcClient();
			rpcClient.setConfig(config);		
			
			ArrayList<Object> params = new ArrayList<Object>();
			Hashtable<String, Object> executionData = new Hashtable<String, Object>();				
			executionData.put("devKey", CommonUtils.readIni("Environment.ini", "str_DevKey"));
			executionData.put("testcaseexternalid", testcaseid);
			executionData.put("testplanid", CommonUtils.readIni("Environment.ini", "str_TestPlanId"));
			executionData.put("status", status);
			executionData.put("buildname", CommonUtils.readIni("Environment.ini", "str_BuildName"));
			executionData.put("overwrite", true);
			params.add(executionData);
			
			Object[] result = (Object[]) rpcClient.execute("tl.reportTCResult", params);
	        
			System.out.println("Result was:\n");            
	         for (int i=0; i< result.length; i++)
	         {
	            Map item = (Map)result[i];
	            System.out.println("Keys: " + item.keySet().toString() + " values: " + item.values().toString());
	         }

		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (XmlRpcException e)
		{
			e.printStackTrace();
		}
	}
		
}


package com.qa.Functions.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunWindowCommand {
	public void runWndCommand(String cmd[]) throws Exception {
		System.out.println("executing command");
        try {
            Process p = Runtime.getRuntime().exec(cmd);  
            BufferedReader in = new BufferedReader(  
                                new InputStreamReader(p.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                System.out.println(line);  
            }
            BufferedReader stdError = new BufferedReader(new 
                    InputStreamReader(p.getErrorStream()));
               
              String s = null;
              String error = null;
              s = stdError.readLine();
   			if(s != null) {
   				error += s;
   				while ((s = stdError.readLine()) != null) {
   					error += s;
   				}
   				throw new Exception("Error " + error);
   			}
        } catch (IOException e) {  
            e.printStackTrace();  
        }
	}
	
	public void runWndCommand(String cmd[], boolean ignoreSTDErr) throws Exception{		
        try {  
            Process p = Runtime.getRuntime().exec(cmd);  
            BufferedReader in = new BufferedReader(  
                                new InputStreamReader(p.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                System.out.println(line);  
            }
            BufferedReader stdError = new BufferedReader(new 
                    InputStreamReader(p.getErrorStream()));
               
              String s = null;
              String error = null;
              s = stdError.readLine();
   			if(s != null) {
   				error += s;
   				while ((s = stdError.readLine()) != null) {
   					error += s;
   				}
   				if(!(ignoreSTDErr)){
   					throw new Exception("Error occurred while executing the command: " + error);
   				}
   			}
        } catch (IOException e) {  
            e.printStackTrace();  
        }        
	}
	
	public void runWndCommand(String cmd[], String matchString, int timeOut) throws Exception {
        try {
        	
        	long startTime = System.currentTimeMillis();
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader in = new BufferedReader(  
                                new InputStreamReader(p.getInputStream()));  
            
            String line = null;  
            
            while ((line = in.readLine()) != null) {
            	if(line.indexOf(matchString) != -1){
            		System.out.println(line);
            		System.out.println("Boot process completed");
            		return;
            	}
            	long elapsed = System.currentTimeMillis() - startTime;
            	System.out.println("Elapsed: " + elapsed);
            	if(elapsed >= (timeOut * 1000)){
            		throw new Exception ("Timeout while waiting for boot up to complete");
            	}
            }
            
            BufferedReader stdError = new BufferedReader(new 
                    InputStreamReader(p.getErrorStream()));
               
            String s = null;
            String error = null;
            s = stdError.readLine();
   			
            if(s != null) {
   				error += s;
   				while ((s = stdError.readLine()) != null) {
   					error += s;
   				}
   				throw new Exception("Error occurred: " + error);
   			}
        } catch (IOException e) {  
            e.printStackTrace();  
        }
	}
}

package com.qa.setup;

import com.qa.setup.AndroidUtilities;

import com.qa.Functions.common.*;


public class AndroidEmulatorSetup {	
	public void setUpEnvironment() throws Exception {
	//public static void main(String args[]) throws Exception {
    	
    	String avd_name = CommonUtils.readIni("Environment.ini", "Device_Name");
    	
      	System.out.println("Trying to launch it now " + avd_name);
      	  			
    	boolean bootupComplete = false;
    	int count = 0;
    	while(bootupComplete != true && count < CommonUtils.toInt(CommonUtils.readIni("Environment.ini", "RETRY_COUNT"))){
    		count++;
    		Thread startAVDThread = null;
    		try {
    			startAVDThread = new Thread(new StartAVD(CommonUtils.readIni("Environment.ini", "ANDROID_EMULATOR_EXE"), avd_name), "StartAVD");
    	    	startAVDThread.start();
    	    	
    	    	CommonUtils.waitForChangesToReflect(10);
    	    	
    			if((startAVDThread.getState()).toString() == "TERMINATED"){
    				System.out.println("Starting of the AVD Emulator failed ");
    				startAVDThread.interrupt();
    				AndroidUtilities.stopEmulator();
    				continue;
    			}
    			//AndroidUtilities.monitorEmulator(avd_name);
    			AndroidUtilities.waitForBootUp(CommonUtils.readIni("Environment.ini", "ANDROID_ADB"), CommonUtils.readIni("Environment.ini", "SUCCESS_MESSAGE"), CommonUtils.toInt(CommonUtils.readIni("Environment.ini", "BOOT_TIMEOUT")));
    			bootupComplete = true;
    		}
    		catch (Exception e){
				System.out.println("Emulator hanged. Going to kill it");
				startAVDThread.interrupt();
				AndroidUtilities.stopEmulator();
				continue;
    			
    		}
    	}
		
    	if(!bootupComplete){
    		throw new Exception ("Bootup is not successful. Please check error logs for more details. No of retries done: " + count);
    	}
    	
    	AndroidUtilities.unlockEmulator(CommonUtils.readIni("Environment.ini", "ANDROID_ADB"));
    	AndroidUtilities.enablePortForwarding(CommonUtils.readIni("Environment.ini", "ANDROID_ADB"));
    	AndroidUtilities.startAndroidProcess(CommonUtils.readIni("Environment.ini", "ANDROID_ADB"), CommonUtils.readIni("Environment.ini", "WEBDRIVER_APP_COMPONENT"));
    	AndroidUtilities.startAndroidService(CommonUtils.readIni("Environment.ini", "ANDROID_ADB"), CommonUtils.readIni("Environment.ini", "WEBDRIVER_JETTY_SERVICE"));
    	CommonUtils.waitForChangesToReflect(CommonUtils.toInt(CommonUtils.readIni("Environment.ini", "DELAY")));
    }
}

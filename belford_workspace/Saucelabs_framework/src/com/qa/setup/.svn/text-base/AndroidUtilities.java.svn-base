package com.qa.setup;

import com.qa.Functions.common.CommonUtils;
import com.qa.Functions.common.RunWindowCommand;

public class AndroidUtilities {
	public static void waitForBootUp (String adbPath, String successMsg, int timeOut) throws Exception {
		//String[] cmd = {"cmd.exe", "/C", cmdString};
		String[] cmd = {adbPath, "wait-for-device"};
		
		RunWindowCommand runWndCmdObj = new RunWindowCommand();
		
		runWndCmdObj.runWndCommand(cmd);
		String[] processMonitorCmd = {adbPath, "logcat"};
		runWndCmdObj.runWndCommand(processMonitorCmd, successMsg, timeOut);
	}
	
	public static void installAPK (String adbPath, String absAPKName) throws Exception {
		
		String cmdString = adbPath + " -e install -r " + absAPKName;

		System.out.println("CommandString: " + cmdString);
		
		String[] cmd = {"cmd.exe", "/C", cmdString};
		
		RunWindowCommand runWndCmdObj = new RunWindowCommand();
		runWndCmdObj.runWndCommand(cmd, true);
	}
	
	public static void enablePortForwarding (String adbPath) throws Exception {
		String[] cmd = {adbPath, "forward", "tcp:8080", "tcp:8080"};
		
		RunWindowCommand runWndCmdObj = new RunWindowCommand();
		
		runWndCmdObj.runWndCommand(cmd);
	}
	
	public static void startAndroidProcess (String adbPath, String appComponent) throws Exception {
		String[] cmd = {adbPath, "shell", "am", "start", "-W", "-a", "android.intent.action.MAIN", "-n", appComponent};
		
		RunWindowCommand runWndCmdObj = new RunWindowCommand();
		
		runWndCmdObj.runWndCommand(cmd);
	}
	
	public static void startAndroidService (String adbPath, String appComponent) throws Exception {
		String[] cmd = {"cmd.exe", "/C", adbPath, "shell", "am", "startservice", "-a", "android.intent.action.MAIN", "-n", appComponent};
		
		RunWindowCommand runWndCmdObj = new RunWindowCommand();
		
		runWndCmdObj.runWndCommand(cmd);
	}
	
	public static void stopEmulator () throws Exception {
		String StopEmulator = System.getProperty("user.dir")+ "\\src\\com\\qa\\setup\\CloseEmulator.exe" ;
		String[] cmd = {"cmd.exe", "/C", StopEmulator};
		
		RunWindowCommand runWndCmdObj = new RunWindowCommand();
		
		runWndCmdObj.runWndCommand(cmd);
	}
	
	public static void startBrowser(String url) throws Exception {
		
		String adbPath = CommonUtils.readIni("Environment.ini", "ANDROID_ADB");
		String[] cmd = {adbPath, "shell", "am", "start", "-a", "android.intent.action.VIEW", "-d", url};
		
		RunWindowCommand runWndCmdObj = new RunWindowCommand();
		
		runWndCmdObj.runWndCommand(cmd);
	}
	
	public static void configureBrowser() throws Exception {
		
		String adbPath = CommonUtils.readIni("Environment.ini", "ANDROID_ADB");
		String BrowserConfigurations = System.getProperty("user.dir")+ "\\src\\com\\qa\\setup\\com.android.browser_preferences.xml";
		String cmdString = adbPath + " push " + BrowserConfigurations + " /data/data/com.android.browser/shared_prefs/com.android.browser_preferences.xml";

		System.out.println("CommandString: " + cmdString);
		
		String[] cmd = {"cmd.exe", "/C", cmdString};
		
		RunWindowCommand runWndCmdObj = new RunWindowCommand();
		runWndCmdObj.runWndCommand(cmd, true);

	}
	public static void unlockEmulator(String adbPath) throws Exception {
		
		String cmdString = adbPath + " shell input keyevent 82";

		System.out.println("CommandString: " + cmdString);
		
		String[] cmd = {"cmd.exe", "/C", cmdString};
		
		RunWindowCommand runWndCmdObj = new RunWindowCommand();
		runWndCmdObj.runWndCommand(cmd, true);
	}
}

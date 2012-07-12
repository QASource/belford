package com.qa.setup;
import com.qa.Functions.common.RunWindowCommand;

public class StartAVD implements Runnable{
	private static String[] cmd;
	StartAVD(String emulatorPath, String avdName) {
		
		//String cmdString = "start /B " + emulatorPath + " -avd "+ avdName;
		String cmdString = emulatorPath + " -avd "+ avdName;
		System.out.println("CommandString: " + cmdString);
		String [] newCmd = {"cmd.exe", "/C", cmdString};
		cmd = newCmd;
	}
	
	public void run () {		
		RunWindowCommand runWndCmdObj = new RunWindowCommand();
		try {
			runWndCmdObj.runWndCommand(cmd);
		}
		catch (Exception e){
			System.out.println(e.getStackTrace());
		}
	}
}


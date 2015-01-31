package org.usfirst.frc.team238.robot;

public class CommandController {
	
	Command operatorCommandList[];
	Command driverCommandList[];
	
	public void  init(){
		int numCommands = 10; 
		System.out.println("ControlBoard Init:NUMCMDS = " + numCommands);
		operatorCommandList = new Command[numCommands];
		driverCommandList = new Command[numCommands];
		
	}
	
	public void setCommand(int list, int slot, Command command){
		if(list == CrusaderCommon.OPR_CMD_LIST) {
			operatorCommandList[slot] = command;
		}
		else
		{
			driverCommandList[slot] = command;
		}
	}
	
	public void buttonPressed(int slot[]){
		operatorCommandList[slot[0]].execute();
		//driverCommandList[slot[1]].execute();
	}
}

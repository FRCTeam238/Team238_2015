package org.usfirst.frc.team238.robot;

public class CommandController {
	Command commandList[];
	
	public void  init(){
		int numCommands = 10; 
		System.out.println("ControlBoard Init:NUMCMDS = " + numCommands);
		commandList = new Command[numCommands];
		
	}
	
	public void setCommand( int slot, Command command){
		commandList[slot] = command;
	}
	
	public void buttonPressed(int slot){
		commandList[slot].execute();
	}
}

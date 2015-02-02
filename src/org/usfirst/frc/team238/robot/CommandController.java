package org.usfirst.frc.team238.robot;

public class CommandController {
	
	Command operatorCommandList[];
	Command driverCommandList[];
	Command manualOperatorCommandList[];
	
	public void  init()
	{
		int numCommands = 10; 
		System.out.println("ControlBoard Init:NUMCMDS = " + numCommands);
		operatorCommandList = new Command[numCommands];
		driverCommandList = new Command[numCommands];
		manualOperatorCommandList = new Command[numCommands];
	}
	
	public void setCommand(int list, int slot, Command command){
		
		switch(list)
		{
		case CrusaderCommon.OPR_CMD_LIST:
			operatorCommandList[slot] = command;
			break;
		case CrusaderCommon.DRIVER_CMD_LIST:
			driverCommandList[slot] = command;
			break;
		default:
			manualOperatorCommandList[slot] = command;
		}
		
		
	}
	
	public void buttonPressed(int slot[]){
		
		//if the override switch is enabled the joystick in slot 0  will control motion of the lift, 
		//the upper and lower limit switched wired directly into the jags will protect over driving the motors in either direction 
		//but none of the other sensors will be used, this is for testing and extreme circumstances when 
		//sensors are compromised
		if(ControlBoard.overRide()){
			
			//get the value( button pressed) from the array
			int buttonpressed = slot[CrusaderCommon.INPUT_MANUAL_OVERRIDE];
			//use the index to get the command that was loaded during robot init
			Command manualCmd = manualOperatorCommandList[buttonpressed];
			//ask the control Board for a value to feed to the execute command
			double valueForMotors = ControlBoard.getManualCommandValue();
			//execute the command
			manualCmd.execute(valueForMotors);
		}
		else
		{
			//this one line does the same thing as the above 4 lines  except it's using the operatorCommandList
			operatorCommandList[slot[CrusaderCommon.INPUT_OPR_CONTROL]].execute();
		}
		
		driverCommandList[slot[CrusaderCommon.INPUT_DRIVER]].execute();
	}
}

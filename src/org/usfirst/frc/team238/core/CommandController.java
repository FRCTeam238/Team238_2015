package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CommandController {
	
	Command operatorCommandList[];
	Command driverRightCommandList[];
	Command driverLeftCommandList[];
	Command manualOperatorCommandList[];
	Command autonomousCommandList[];
	
	public void  init()
	{
		int numCommands = 10; 
		System.out.println("ControlBoard Init:NUMCMDS = " + numCommands);
		operatorCommandList = new Command[numCommands];
		driverLeftCommandList = new Command[numCommands];
		driverRightCommandList = new Command[numCommands];
		manualOperatorCommandList = new Command[numCommands];
		autonomousCommandList = new Command[numCommands];
	}
	
	public void setCommand(int list, int slot, Command command){
		
		switch(list)
		{
		case CrusaderCommon.OPR_CMD_LIST:
			operatorCommandList[slot] = command;
			break;
		case CrusaderCommon.LEFTDRIVER_CMD_LIST:
			driverLeftCommandList[slot] = command;
			break;
		case CrusaderCommon.RIGHTDRIVER_CMD_LIST:
			driverRightCommandList[slot] = command;
			break;
		case CrusaderCommon.AUTONOMOUS_CMD_LIST:
			autonomousCommandList[slot] = command;
			break;
		default:
			manualOperatorCommandList[slot] = command;
		}
	}
	
	/*
	 * Gets the buttons that are pressed or switches that are set from the controls (joysticks or custom)  
	 * which the values  ( button1 = 1 etc) are an index into the array of commands that have been pre-loaded 
	 * in robot.init, gets the command at that slot in the array and calls the execute function on that command.
	 */
	public void buttonPressed(int slot[]){
		
		//if the override switch is enabled the joystick in slot 0  will control motion of the lift, 
		//the upper and lower limit switched wired directly into the jags will protect over driving the motors in either direction 
		//but none of the other sensors will be used, this is for testing and extreme circumstances when 
		//sensors are compromised
		if(ControlBoard.overRide()){
			//the next 4 lines are what's done in the one line for operator and driverleft/right below
			//but has been expanded for clarity and teaching
			
			//get the value( button pressed) from the array
			int buttonpressed = slot[CrusaderCommon.INPUT_MANUAL_OVERRIDE];
			//use the index to get the command that was loaded during robot init
			Command manualCmd = operatorCommandList[buttonpressed];
			//ask the control Board for a value to feed to the execute command
			double valueForMotors = ControlBoard.getManualCommandValue();
			//execute the command
			manualCmd.execute(-valueForMotors);
		}
		else
		{
			//this one line does the same thing as the above 4 lines  except it's using the operatorCommandList
			operatorCommandList[slot[CrusaderCommon.INPUT_OPR_CONTROL]].execute();
		}
		
		driverLeftCommandList[slot[CrusaderCommon.INPUT_DRIVER_LEFT_JS]].execute();
		driverRightCommandList[slot[CrusaderCommon.INPUT_DRIVER_RIGHT_JS]].execute();
	}
	
	public void autoButtonPressed(int slot[])
	{
		for (int idx = 0; idx < slot.length; idx++)
		{
			System.out.print(" " + Integer.toString(slot[idx]));
		}
		System.out.println();
		
		buttonPressed(slot);
		Command command = autonomousCommandList[slot[CrusaderCommon.INPUT_AUTO_DRIVE]];
		System.out.println(command);
		
		SmartDashboard.putString("auto cmd", command.toString());
		command.execute();
	}
}

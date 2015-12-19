package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.Lift;

public class CommandManualLiftControlClampsOff implements Command 
{
	Lift myLift;
	//SaloonDoors mySaloonDoors;

	public CommandManualLiftControlClampsOff(Lift theLift)
	{
		this.myLift = theLift;
	}

	public void execute()
	{
		myLift.manualControlOfLifter(0);
	}

	public void execute(double overRideValue){
	}
}

package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.Lift;

public class CommandGoToTravel implements Command 
{
	Lift myLift;
	
	public CommandGoToTravel(Lift theLift)
	{
		this.myLift = theLift;
	}
	
	public void execute()
	{
		myLift.clampOn();
		myLift.travelingMode();
	}
	
	public void execute(double overRideValue)
	{
		myLift.clampOn();
		myLift.manualControlOfLifter(overRideValue);
	}
}

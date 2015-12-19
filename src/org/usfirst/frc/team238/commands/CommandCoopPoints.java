package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.Lift;

public  class CommandCoopPoints implements Command {
	
	public Lift myLift;
	
	public CommandCoopPoints(Lift theLift)
	{
		this.myLift = theLift;
	}
	
	public void execute()
	{
		myLift.setToCoop();
	}
	
	public void execute(double overRideValue) 
	{
		myLift.manualControlOfLifter(overRideValue);
	}
}

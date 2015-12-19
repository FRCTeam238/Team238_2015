package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.Lift;

public abstract class CommandManualLiftControlClampsOn implements Command
{
	Lift myLift;
	public CommandManualLiftControlClampsOn(Lift theLift)
	{

		this.myLift = theLift;
	}

	public void execute()
	{
		
		myLift.clampOn();
	}
	public void execute(double overRideValue){
		myLift.manualControlOfLifter(overRideValue);    
	}
}



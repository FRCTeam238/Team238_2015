package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.Lift;

public class CommandGoToDeliver implements Command {

	public Lift myLift;
	//public SaloonDoors mySaloonDoor;

	public CommandGoToDeliver(Lift theLift)
	{
		this.myLift = theLift;
		// this.mySaloonDoor = theSaloonDoor;
	}

	public void execute()
	{	
		myLift.clampOn();
		myLift.setToCatch();

	}

	public void execute(double overRideValue)
	{
		myLift.manualControlOfLifter(overRideValue);
		
	}
}

package org.usfirst.frc.team238.robot;

public class CommandGoToDeliver implements Command {

	public Lift myLift;
	//public SaloonDoors mySaloonDoor;

	public CommandGoToDeliver(Lift theLift, SaloonDoors theSaloonDoor)
	{
		this.myLift = theLift;
		// this.mySaloonDoor = theSaloonDoor;
	}

	public void execute()
	{	
		myLift.setToCatch();;

	}

	public void execute(double overRideValue)
	{
		myLift.manualControlOfLifter(overRideValue);
		
	}
}

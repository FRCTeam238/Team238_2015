package org.usfirst.frc.team238.robot;

public class CommandGoToTravel implements Command 
{
	Lift myLift;
	SaloonDoors mySaloonDoors;
	
	public CommandGoToTravel(Lift theLift, SaloonDoors theSaloonDoors)
	{
		this.myLift = theLift;
		this.mySaloonDoors = theSaloonDoors;
	}
	
	public void execute()
	{
		myLift.clampOn();
		myLift.travelingMode();
		mySaloonDoors.CloseDoors();
		
	}
	
	public void execute(double overRideValue) {
	}
}

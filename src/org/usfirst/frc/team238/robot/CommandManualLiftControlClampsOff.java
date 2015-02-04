package org.usfirst.frc.team238.robot;

public class CommandManualLiftControlClampsOff implements Command 
{
	Lift myLift;
	SaloonDoors mySaloonDoors;

	public CommandManualLiftControlClampsOff(Lift theLift, SaloonDoors theSaloonDoors)
	{
		this.myLift = theLift;
		this.mySaloonDoors = theSaloonDoors;
	}

	public void execute()
	{
		myLift.manualControlOfLifter(0);
		//mySaloonDoors.CloseDoors();

	}

	public void execute(double overRideValue){
	}
}

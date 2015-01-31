package org.usfirst.frc.team238.robot;

public class CommandGoToLift implements Command {
	
	Lift myLift;
	SaloonDoors mySaloonDoor;
	
	public CommandGoToLift(Lift theLift, SaloonDoors theSaloonDoor)
	{
		this.myLift = theLift;
		this.mySaloonDoor = theSaloonDoor;
	}
	public void execute()
	{
		myLift.clampOn();
		myLift.liftGameObjects();
		mySaloonDoor.CloseDoors();
	}
}
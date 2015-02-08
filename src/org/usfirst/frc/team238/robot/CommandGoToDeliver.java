package org.usfirst.frc.team238.robot;

public class CommandGoToDeliver implements Command {
	
	public Lift myLift;
	public SaloonDoors mySaloonDoor;
	
	public CommandGoToDeliver(Lift theLift, SaloonDoors theSaloonDoor)
	{
		this.myLift = theLift;
		this.mySaloonDoor = theSaloonDoor;
	}
	
	public void execute()
	{
	//	myLift.liftGoesDown();
		
		int liftLevel = 2; //myLift.getLevel();
		
		if (liftLevel == CrusaderCommon.TRAVEL_LEVEL)
		{
			myLift.letItGo();
			
			mySaloonDoor.OpenDoors();
		}
		
	}
	
	public void execute(double overRideValue) {
	}
}

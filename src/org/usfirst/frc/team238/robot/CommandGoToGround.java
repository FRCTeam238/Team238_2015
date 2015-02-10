package org.usfirst.frc.team238.robot;

public  class CommandGoToGround implements Command {
	
	public Lift myLift;
	public SaloonDoors mySaloonDoor;
	
	public CommandGoToGround(Lift theLift, SaloonDoors theSaloonDoor)
	{
		this.myLift = theLift;
		this.mySaloonDoor = theSaloonDoor;
	}
	
	public void execute()
	{
		myLift.setToGround();
		myLift.letItGo();
		mySaloonDoor.CloseDoors();
	}
	
	public void execute(double overRideValue)
	{
		myLift.manualControlOfLifter(overRideValue);
		
		if(myLift.getLevel() == CrusaderCommon.GROUND_LEVEL)
		{
			myLift.letItGo();
			mySaloonDoor.CloseDoors();
		}
	}
}

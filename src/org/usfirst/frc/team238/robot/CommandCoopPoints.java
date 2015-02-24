package org.usfirst.frc.team238.robot;

public  class CommandCoopPoints implements Command {
	
	public Lift myLift;
	//public SaloonDoors mySaloonDoor;
	public Claws myClaws;
	
	public CommandCoopPoints(Lift theLift, SaloonDoors theSaloonDoors)
	{
		//this.myClaws = theClaws;
		this.myLift = theLift;
		//this.mySaloonDoor = theSaloonDoors;
	}
	
	public void execute()
	{
		myLift.clampOn();
		//myLift.setToCoop();
		//mySaloonDoor.OpenDoors();
		//myClaws.spitItemsOut();
	}
	
	public void execute(double overRideValue) 
	{
		myLift.manualControlOfLifter(overRideValue);
		//mySaloonDoor.OpenDoors();
	}
}

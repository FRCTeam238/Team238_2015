package org.usfirst.frc.team238.robot;

public abstract class CommandManualLiftControlClampsOn implements Command
{
	Lift myLift;
	public CommandManualLiftControlClampsOn(Claws theClaws, Lift theLift, SaloonDoors theSaloonDoor)
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



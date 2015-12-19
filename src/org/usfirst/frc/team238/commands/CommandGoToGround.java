package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.CrusaderCommon;
import org.usfirst.frc.team238.robot.Lift;
public  class CommandGoToGround implements Command {
	
	public Lift myLift;
	
	public CommandGoToGround(Lift theLift)
	{
		this.myLift = theLift;
	}
	
	public void execute()
	{
		myLift.setToGround();
		myLift.letItGo();
	}
	
	public void execute(double overRideValue)
	{
		myLift.manualControlOfLifter(overRideValue);
		
		if(myLift.getLevel() == CrusaderCommon.GROUND_LEVEL)
		{
			myLift.letItGo();
		}
	}
}

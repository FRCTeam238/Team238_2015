package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.Shifter;

public class CommandShiftLow   implements Command
{
	public Shifter myShifter;
	int shiftState;
	
	public CommandShiftLow(Shifter theShifter)
	{
		this.myShifter = theShifter;
	}
	
	public void execute()
	{
		
		myShifter.setLowGear();
		
	}
	
	public void execute(double overRideValue) 
	{
		
	}
}


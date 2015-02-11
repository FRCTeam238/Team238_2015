package org.usfirst.frc.team238.robot;

public class CommandShifter   implements Command
{
	public Shifter myShifter;
	
	public CommandShifter(Shifter theShifter)
	{
		this.myShifter = theShifter;
	}
	
	public void execute()
	{
		myShifter.shiftingGears();
		
	}
	
	public void execute(double overRideValue) 
	{
		
	}
}


package org.usfirst.frc.team238.robot;

public class CommandShiftHigh   implements Command
{
	public Shifter myShifter;
	int shiftState;
	
	public CommandShiftHigh(Shifter theShifter)
	{
		this.myShifter = theShifter;
	}
	
	public void execute()
	{
		
		myShifter.setHighGear();
		
	}
	
	public void execute(double overRideValue) 
	{
		
	}
}
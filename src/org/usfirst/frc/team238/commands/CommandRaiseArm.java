package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.Arm;

public class CommandRaiseArm implements Command 
{
	
	public Arm myArm;
	
	public CommandRaiseArm(Arm theArm) 
	{
		
		this.myArm = theArm;
		
	}
	
	public void execute()
	{
		
		myArm.raiseArm();
		
	}

	public void execute(double overRideValue) 
	{
		
	}
	
}

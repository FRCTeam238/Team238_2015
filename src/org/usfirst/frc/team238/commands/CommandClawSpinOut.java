package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.Claws;

public class CommandClawSpinOut implements Command 
{
	
	public Claws myClaws;
	
	public CommandClawSpinOut(Claws theClaws) 
	{
		this.myClaws = theClaws;
	}
	
	public void execute()
	{
		myClaws.spinOut();
	}
	
	public void execute(double OverRideValue)
	{
		
	}

}

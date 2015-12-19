package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.Claws;

public class CommandClawSpinIn implements Command
{

	public Claws myClaws;
	
	public CommandClawSpinIn(Claws theClaws) 
	{
		this.myClaws = theClaws;
	}
	
	public void execute()
	{
		myClaws.spinIn();
	}
	
	public void execute(double overRideValue)
	{
		
	}

}

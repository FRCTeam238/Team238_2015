package org.usfirst.frc.team238.robot;

public class CommandClawOut implements Command {
	
	public Claws myClaws;

	public CommandClawOut(Claws theClaws)
	{
		this.myClaws = theClaws;
	}
	@Override
	public void execute() 
	{
		myClaws.spitItemsOut();
	
	}

	@Override
	public void execute(double overRideValue) {


	}

}

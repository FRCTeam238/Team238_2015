package org.usfirst.frc.team238.robot;

public class CommandClawSpinRight implements Command {

	public Claws myClaws;

	public CommandClawSpinRight(Claws theClaws)
	{
		this.myClaws = theClaws;
	}

	@Override
	public void execute() 
	{
		myClaws.spinItemsRight();
		
	}

	@Override
	public void execute(double overRideValue) {

	}

}

package org.usfirst.frc.team238.robot;

public class CommandClawIn  implements Command {

	public Claws myClaws;
	
	public CommandClawIn(Claws theClaws)
	{
		this.myClaws = theClaws;
	}
	
	public void execute()
	{
		myClaws.suckItemsIn();
	}
	public void execute(double overRideValue)
	{
	
	}
}

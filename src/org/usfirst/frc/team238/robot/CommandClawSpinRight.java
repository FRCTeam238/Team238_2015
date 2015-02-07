package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		SmartDashboard.putString("ClawsSpinRight", "YES");
	}

	@Override
	public void execute(double overRideValue) {

	}

}

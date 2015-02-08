package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CommandClawSpinLeft implements Command {

	public Claws myClaw;

	public CommandClawSpinLeft(Claws theClaw)
	{
		this.myClaw = theClaw;
	} 

	@Override
	public void execute() 
	{
		myClaw.spinItemsLeft();
		SmartDashboard.putString("ClawsSpinLeft", "YES");
	}

	@Override
	public void execute(double overRideValue) 
	{

	}

}

package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CommandClawSpinRight implements Command {

	public Claws myClaw;

	public CommandClawSpinRight(Claws theClaw)
	{
		this.myClaw = theClaw;
	}

	@Override
	public void execute() 
	{
		myClaw.spinItemsRight();
		SmartDashboard.putString("ClawsSpinRight", "YES");
	}

	@Override
	public void execute(double overRideValue) {

	}

}

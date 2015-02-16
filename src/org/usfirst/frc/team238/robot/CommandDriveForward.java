package org.usfirst.frc.team238.robot;



public class CommandDriveForward implements Command {

	
	Robot myDT;
	
	public CommandDriveForward(Robot theRobot)
	{
		this.myDT = theRobot;
	}
	
	public void execute() 
	{

		myDT.myRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_FORWARD, CrusaderCommon.AUTO_DRIVE_FORWARD);
	}

	public void execute(double overRideValue) {
	

	}

}

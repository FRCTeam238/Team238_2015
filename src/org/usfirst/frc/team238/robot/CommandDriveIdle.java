package org.usfirst.frc.team238.robot;

public class CommandDriveIdle {

	//CAT CONSIDER: Remove the Robot object and use only the ... 
	//CAT  ... RobotDrive in CommandDriveForward, Backward and Idle
	Robot myDT;
	
	public CommandDriveIdle(Robot theRobot)
	{
		this.myDT = theRobot;
	}
	
	public void execute() 
	{

		myDT.myRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_IDLE, CrusaderCommon.AUTO_DRIVE_IDLE);
	}

	public void execute(double overRideValue) {
	

	}

}

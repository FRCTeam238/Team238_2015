package org.usfirst.frc.team238.robot;



public class CommandDriveForward implements Command {

	//CAT CONSIDER: Remove the Robot object and use only the ... 
	//CAT  ... RobotDrive in CommandDriveForward, Backward and Idle
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

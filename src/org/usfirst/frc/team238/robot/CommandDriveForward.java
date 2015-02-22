package org.usfirst.frc.team238.robot;

public class CommandDriveForward implements Command {

	AutonomousDrive myRobotDrive; 
	public CommandDriveForward(AutonomousDrive theRobotDrive)
	{
		this.myRobotDrive = theRobotDrive;
	}
	
	public void execute() 
	{

		myRobotDrive.forward();
	}

	public void execute(double overRideValue) {
	

	}

}

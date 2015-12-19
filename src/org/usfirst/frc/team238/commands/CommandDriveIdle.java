package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.AutonomousDrive;

public class CommandDriveIdle implements Command {

	//CAT CONSIDER: Remove the Robot object and use only the ... 
	//CAT  ... RobotDrive in CommandDriveForward, Backward and Idle
	AutonomousDrive myRobotDrive;
	
	public CommandDriveIdle(AutonomousDrive theRobotDrive)
	{
		this.myRobotDrive = theRobotDrive;
	}
	
	public void execute() 
	{

		myRobotDrive.idle();
	}

	public void execute(double overRideValue) {
	

	}

}

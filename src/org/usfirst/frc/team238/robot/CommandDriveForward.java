package org.usfirst.frc.team238.robot;
import edu.wpi.first.wpilibj.RobotDrive;


public class CommandDriveForward implements Command {

	
	RobotDrive myRobotDrive; 
	public CommandDriveForward(RobotDrive theRobotDrive)
	{
		this.myRobotDrive = theRobotDrive;
	}
	
	public void execute() 
	{

		myRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_FORWARD, CrusaderCommon.AUTO_DRIVE_FORWARD);
	}

	public void execute(double overRideValue) {
	

	}

}

package org.usfirst.frc.team238.robot;
import edu.wpi.first.wpilibj.RobotDrive;


public class CommandDriveBackwards implements Command {

	
	RobotDrive myRobotDrive; 
	public CommandDriveBackwards(RobotDrive theRobotDrive)
	{
		this.myRobotDrive = theRobotDrive;
	}
	
	public void execute() 
	{

		myRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_BACKWARD, CrusaderCommon.AUTO_DRIVE_BACKWARD);
	}

	public void execute(double overRideValue) {
	

	}

}

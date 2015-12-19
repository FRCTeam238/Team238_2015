package org.usfirst.frc.team238.robot;

public class CommandDriveBackwards implements Command {

	AutonomousDrive myRobotDrive;

	public CommandDriveBackwards(AutonomousDrive theRobotDrive) {
		this.myRobotDrive = theRobotDrive;
	}

	public void execute() {
		myRobotDrive.backward();
	}

	public void execute(double overRideValue) {

	}

}

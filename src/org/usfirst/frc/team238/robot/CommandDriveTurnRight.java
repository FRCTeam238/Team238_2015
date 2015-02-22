package org.usfirst.frc.team238.robot;

public class CommandDriveTurnRight implements Command {

	AutonomousDrive myRobotDrive;

	public CommandDriveTurnRight(AutonomousDrive theRobotDrive) {
		this.myRobotDrive = theRobotDrive;
	}

	@Override
	public void execute() {
		myRobotDrive.turnRight();
	}

	@Override
	public void execute(double overRideValue) {
		// TODO Auto-generated method stub

	}

}

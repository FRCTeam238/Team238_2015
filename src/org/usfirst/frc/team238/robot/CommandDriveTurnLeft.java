package org.usfirst.frc.team238.robot;

public class CommandDriveTurnLeft implements Command {

	AutonomousDrive myRobotDrive;

	public CommandDriveTurnLeft(AutonomousDrive theRobotDrive) {
		this.myRobotDrive = theRobotDrive;
	}

	@Override
	public void execute() {
		myRobotDrive.turnLeft();
	}

	@Override
	public void execute(double overRideValue) {
		// TODO Auto-generated method stub

	}

}

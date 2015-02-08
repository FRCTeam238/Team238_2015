package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain {

	TalonSRX FRONT_LEFT_WHEEL; 
	TalonSRX FRONT_RIGHT_WHEEL; 
	TalonSRX REAR_LEFT_WHEEL; 
	TalonSRX REAR_RIGHT_WHEEL; 

	RobotDrive drive;

	public void dtInit()
	{

		FRONT_LEFT_WHEEL = new TalonSRX(0);
		SmartDashboard.putNumber("Front Left Wheel", FRONT_LEFT_WHEEL.get());
		FRONT_RIGHT_WHEEL = new TalonSRX(1);
		SmartDashboard.putNumber("Rear Left Wheel", REAR_LEFT_WHEEL.get());
		REAR_LEFT_WHEEL = new TalonSRX(2);
		SmartDashboard.putNumber("Front Right Wheel", FRONT_RIGHT_WHEEL.get());
		REAR_RIGHT_WHEEL = new TalonSRX(3);
		SmartDashboard.putNumber("Rear Right Wheel", REAR_RIGHT_WHEEL.get());

		drive = new RobotDrive(FRONT_LEFT_WHEEL,REAR_LEFT_WHEEL,FRONT_RIGHT_WHEEL,REAR_RIGHT_WHEEL);
		SmartDashboard.putString("DriveTrain initialized", "Initialize");
	}

	public void leftSideStop()
	{
		//if((leftDriveJoy.getY() <= CrusaderCommon.JOY_MAX) && (leftDriveJoy.getY() >= CrusaderCommon.JOY_MIN))
		{
			FRONT_LEFT_WHEEL.set(0);
			REAR_LEFT_WHEEL.set(0);
		}
	}

	public void rightSideStop()
	{
		//if((rightDriveJoy.getY() <= CrusaderCommon.JOY_MAX) && (rightDriveJoy.getY() >= CrusaderCommon.JOY_MIN))
		{
			FRONT_RIGHT_WHEEL.set(0);
			REAR_LEFT_WHEEL.set(0);
		}
	}
	public void stop()
	{
		rightSideStop();
		leftSideStop();
	}
	public void leftSideActivate()
	{
		
	}
}

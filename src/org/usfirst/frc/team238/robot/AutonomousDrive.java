package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

public class AutonomousDrive {
	RobotDrive autoRobotDrive;
	Timer autonomousTimer;
	
	public AutonomousDrive(RobotDrive theRobotDrive)
	{
		this.autoRobotDrive = theRobotDrive;
	}
	
	public void init()
	{
		autonomousTimer = new Timer();
		autonomousTimer.reset();
		autonomousTimer.start();
	}
	
	public void killTimer()
	{
		autonomousTimer.stop();
	}
	
	public void forward()
	{
		if(autonomousTimer.get() <= 3)
		{
			autoRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_FORWARD, CrusaderCommon.AUTO_DRIVE_FORWARD);
		}else
		{
			autoRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_IDLE, CrusaderCommon.AUTO_DRIVE_IDLE);
		}
	}

	public void backward()
	{
		if(autonomousTimer.get() <= 3)
		{
			autoRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_BACKWARD, CrusaderCommon.AUTO_DRIVE_BACKWARD);
		}
		else
		{
			autoRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_IDLE, CrusaderCommon.AUTO_DRIVE_IDLE);
		}
	}
	
	public void turnRight()
	{
		if(autonomousTimer.get() <= 3)
		{
			autoRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_FORWARD, CrusaderCommon.AUTO_DRIVE_BACKWARD);
		}
		else
		{
			autoRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_IDLE, CrusaderCommon.AUTO_DRIVE_IDLE);
		}
	}
	
	public void turnLeft()
	{
		if(autonomousTimer.get() <= 3)
		{
			autoRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_BACKWARD, CrusaderCommon.AUTO_DRIVE_FORWARD);
		}
		else
		{
			autoRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_IDLE, CrusaderCommon.AUTO_DRIVE_IDLE);
		}
	}
}

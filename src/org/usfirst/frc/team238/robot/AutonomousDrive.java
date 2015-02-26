package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		actionComplete = false;
	}

	/*CAT Need to plan for two types of actions:
	 *   1. drive forward for three seconds
	 *   2. turn to the right 90 degrees
	 *   
	 *   Currently, both are implemented with the timer that runs for 3 seconds
	 *   before reporting action complete
	 *   
	 */
	boolean actionComplete = false;
	public void resetAction()
	{
		actionComplete = false;
	}
	
	public boolean isActionComplete()
	{
		if (!actionComplete)
		{
			actionComplete = autonomousTimer.get() > 3;
		}
		return actionComplete;
	}
	
	public void killTimer()
	{
		autonomousTimer.stop();
	}
	
	public void startTimer()
	{
		autonomousTimer.reset();
		autonomousTimer.start();
	}
	
	public void forward()
	{
		//CAT consider making forward, backward, turn left, turn right dumber and let ...
		//CAT ... the caller decide whetehr to drive or not, no matter what the timer is ...
		//CAT ... saying
		
		if(autonomousTimer.get() <= 3)
		{
			SmartDashboard.putString("AutonomousDrive", "forward");
			autoRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_FORWARD, CrusaderCommon.AUTO_DRIVE_FORWARD);
		}
		else
		{
			idle();
		}
	}

	public void backward()
	{
		if(autonomousTimer.get() <= 3)
		{
			SmartDashboard.putString("AutonomousDrive", "backward");
			autoRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_BACKWARD, CrusaderCommon.AUTO_DRIVE_BACKWARD);
		}
		else
		{
			idle();
		}
	}
	
	public void turnRight()
	{
		if(autonomousTimer.get() <= 3)
		{
			SmartDashboard.putString("AutonomousDrive", "turn right");
			autoRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_FORWARD, CrusaderCommon.AUTO_DRIVE_BACKWARD);
		}
		else
		{
			idle();
		}
	}
	
	public void turnLeft()
	{
		if(autonomousTimer.get() <= 3)
		{
			SmartDashboard.putString("AutonomousDrive", "turn left");
			autoRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_BACKWARD, CrusaderCommon.AUTO_DRIVE_FORWARD);
		}
		else
		{
			idle();
		}
	}
	
	public void idle()
	{
		SmartDashboard.putString("AutonomousDrive", "idle");
		autoRobotDrive.tankDrive(CrusaderCommon.AUTO_DRIVE_IDLE, CrusaderCommon.AUTO_DRIVE_IDLE);
	}
}
package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous 
{
	static int[] commandValue;
	
	private static final int Mode_GrabTurnAndDrive = 1;
	private static final int Mode_GrabAndDriveForward = 2;
	private static final int Mode_DriveForward = 3;
	public static final int Mode_Idle = 4;
	
	private AutoMode1Impl myAutoMode1;
	private AutoMode2Impl myAutoMode2;
	private AutoMode3Impl myAutoMode3;
	private AutoMode4Impl myAutoMode4;

	public void autoInit(AutonomousDrive theDrive, Lift theLift)
	{
		try
		{
			commandValue = new int[4];
			
			myAutoMode1 = new AutoMode1Impl();
			myAutoMode1.init(theDrive, theLift);
			myAutoMode2 = new AutoMode2Impl();
			myAutoMode2.init(theDrive, theLift);
			myAutoMode3 = new AutoMode3Impl();
			myAutoMode3.init(theDrive, theLift);
			myAutoMode4 = new AutoMode4Impl();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void reset()
	{
		myAutoMode1.reset();
	}
	
	public int[] buildAutoCommands(int autoModeID)
	{
		String modeName = "unknown";
		
		switch(autoModeID){
		case Autonomous.Mode_GrabTurnAndDrive:
			modeName = "GrabTurnAndDrive";
			commandValue = myAutoMode1.buildCommands();
			break;
		case Autonomous.Mode_GrabAndDriveForward:
			modeName = "GrabAndDriveForward";
			commandValue = myAutoMode2.buildCommands();
			break;
		case Autonomous.Mode_DriveForward:
			modeName = "DriveForward";
			commandValue = myAutoMode3.buildCommands();
			break;
		case Autonomous.Mode_Idle:
			modeName = "Idle";
			myAutoMode4.setCommandBuffer(commandValue);
			myAutoMode4.execute();
			break;
		default:
			break;
		}
		
		SmartDashboard.putString("AM Mode", modeName);
		return commandValue;
	}
}

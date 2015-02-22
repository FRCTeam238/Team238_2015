package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous 
{
	static int[] commandValue;
	
	public static final int Mode_GrabAndDrive = 1;
	public static final int Mode_Idle = 2;
	
	private AutoMode1Impl myAutoMode1;
	private AutoMode2Impl myAutoMode2;

	public void autoInit(AutonomousDrive theDrive, Lift theLift)
	{
		try
		{
			commandValue = new int[4];
			
			myAutoMode1 = new AutoMode1Impl();
			myAutoMode1.init(theDrive, theLift);
			myAutoMode2 = new AutoMode2Impl();
			//myAutoMode2.init();
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
		case Autonomous.Mode_GrabAndDrive:
			modeName = "GrabAndDrive";
			commandValue = myAutoMode1.buildCommands();
			break;
		case Autonomous.Mode_Idle:
			modeName = "Idle";
			myAutoMode2.setCommandBuffer(commandValue);
			myAutoMode2.execute();
			break;
		default:
			break;
		}
		
		SmartDashboard.putString("AM Mode", modeName);
		return commandValue;
	}
}

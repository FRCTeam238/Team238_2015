package org.usfirst.frc.team238.robot;

public class Autonomous 
{
	static int[] commandValue;
	
	public static final int Mode_GrabAndDrive = 1;
	public static final int Mode_Idle = 2;

	public void autoInit()
	{
		try
		{
			commandValue = new int[4];
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	private void autoMode1(){
		commandValue[0] = 0; // do nothing command
		commandValue[1] = 2; // move to travel mode
		commandValue[2] = 1; // left claw spins right 
		commandValue[3] = 2; // right claw spins left
	}
	private void autoMode2(){
		commandValue[0] = 0;
	}
	
	private void autoMode3(){
		
		commandValue[0] =0;
		commandValue[1] =0;
		commandValue[2] =0;
		commandValue[3] =0;
				
	}
	
	public int[] buildAutoCommands(String autoMode)
	{
		int test = Integer.parseInt(autoMode);
		switch(test){
		case Autonomous.Mode_GrabAndDrive:
			autoMode1();
			break;
		case Autonomous.Mode_Idle:
			autoMode2();
			break;
		default:
			break;
		}
		
		return commandValue;
	}
}

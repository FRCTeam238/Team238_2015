package org.usfirst.frc.team238.robot;

public class Autonomous 
{
	static int[] commandValue;
	
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
		commandValue[0] = 0;
		commandValue[1] = 2; //2 is the lift travel command
		commandValue[2] = 1;
		commandValue[3] = 2;
	}
	
	private void autoMode2(){
		
	}
	
	public int[] buildAutoCommands(String autoMode)
	{
		int test = Integer.parseInt(autoMode);
		switch(test){
		case 1:
			autoMode1();
			break;
		case 2:
			autoMode2();
			break;
		default:
		
		}
		
		
		return commandValue;
		
	}
	
}

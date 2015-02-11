package org.usfirst.frc.team238.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ControlBoard { 
	//Here are the joysticks for controlling  the robot
	static Joystick manualOverrideJs; 	// operator manual overide
	static Joystick operatorJs;  	// operator control board
	static Joystick driverLeftJs; 	// driveTrain left
	static Joystick driverRightJs; 	// driveTrain right
	static int commands[];
	
	public void controlBoardInit()
	{
		try
		{
			manualOverrideJs = new Joystick(0);
			operatorJs = new Joystick(1);
			driverLeftJs = new Joystick(2);
			driverRightJs = new Joystick(3);
			
			//array that holds the command sent by each control device
			commands = new int[4];
			
			SmartDashboard.putString("operatorJs", "operatorJs Is Intialized");
			
		}
		
		catch(Exception ex)
		{
			System.out.println("ControlBoard Init Failed");
		}
	}
	
	
	
	/**
	 * loops thru all the buttons on the joystick until it gets to the one that is pressed
	 * works as long as we only need one button pressed at a time, if we need  more than one
	 * button we'll need to create an array of commands.... int command[]
	 * @return command value
	 */
	public int getCommand(Joystick theJoyStick){
		int command;
		boolean jsButtonValue = false;
		
		int interator = theJoyStick.getButtonCount(); 
		
		for(command = 1; command < interator; command++){
			jsButtonValue = theJoyStick.getRawButton(command);
			if(jsButtonValue){
				break;
			}
		}
		if(!jsButtonValue){
			command = 0;
		}
		
		SmartDashboard.putNumber("Opperator Command", command);
		return command;
	}
	
	/**
	 * 
	 * @param theJoyStick
	 * @return
	 */
	public int getDriverCommand(Joystick theJoyStick){
		int command = 0;
		double zPos =  0.0;
		
		boolean jsButtonValue = theJoyStick.getRawButton(1);
		
		//if the triggers is pressed get the z axis  for direction to spin the wheel
		if(jsButtonValue)
		{
			zPos = theJoyStick.getZ(); 

			if( zPos > .10)
			{
				command = 1;
			}
			else if(zPos < -.10)
			{
				command = 2;
			}			
		}
		else if(theJoyStick.getRawButton(3)){
			command = 3;
		}
		
		SmartDashboard.putNumber("Driver Command", command);
		SmartDashboard.putNumber("ZPOS", zPos);
		
		return command;
	}
	
	//populates each array element with the corresponding value for the joys stick
	public int[] getCommands(){
		
		commands[0] = getCommand(manualOverrideJs);
		commands[1] = getCommand(operatorJs);
		commands[2] = getDriverCommand(driverLeftJs);
		commands[3] = getDriverCommand(driverRightJs);
		
		return commands;
	}
	
	//gets the y value of the manual overide joy stick to feed to the command controller
	public static double getManualCommandValue()
	{
		return manualOverrideJs.getY();
	}

	//hardcoded to false until we get a switch  or possibly use SmartDshBd
	public static boolean overRide(){
		boolean overRide = operatorJs.getRawButton(7);
		
		return overRide;
					
	}
	
	
	// This is Button 1, it makes the claws suck things in
	public static boolean isTriggerPressed()
	{
		boolean trigger = false;
		
		try
		{
			trigger = operatorJs.getRawButton(1);
			SmartDashboard.putString("Button 1", "Button 1 Is Initialized");
			return trigger;
		}
		
		catch(Exception ex)
		{
			System.out.println("Not Working");
			return trigger;
		}
		
	}
	// This is Button 2, it makes the claws spit things out
	public static boolean isButtonTwoPressed()
	{
		boolean trigger = operatorJs.getRawButton(2);
		SmartDashboard.putString("Button 2", "Button 2 Is Initialized");
		return trigger;
	}
	// This is Button 3, it will make the claws spin items left
	public static boolean isButtonThreePressed()
	{
		boolean trigger = operatorJs.getRawButton(3);
		SmartDashboard.putString("Button 3", "Button 3 Is Initialized");
		return trigger;
	}
	// This is Button 4, it will make the claws spin items right
	public static boolean isButtonFourPressed()
	{
		boolean trigger = operatorJs.getRawButton(4);
		SmartDashboard.putString("Button 4", "Button 4 Is Initialized");
		return trigger;
	}
	// This is Button 5, it will open the Saloon Doors
	public static boolean isButtonFivePressed()
	{
		boolean trigger = operatorJs.getRawButton(5);
		SmartDashboard.putString("Button 5", "Button 5 Is Initialized");
		return trigger;
	}
	// This is Button 6, it will close the Saloon Doors
	public static boolean isButtonSixPressed()
	{
		boolean trigger = operatorJs.getRawButton(6);
		SmartDashboard.putString("Button 6", "Button 6 Is Initialized");
		return trigger;
	}
	
	public static boolean isButtonSevenPressed()
	{
		boolean trigger = operatorJs.getRawButton(7);
				
		SmartDashboard.putString("Button 7", "Button 7 Is Initialized");
		return trigger;
	}
	
	public static boolean isButtonEightPressed()
	{
		boolean trigger = operatorJs.getRawButton(8);
		SmartDashboard.putString("Button 8", "Button 8 Is Initialized");
		return trigger;
	}
	
	public static boolean isButtonNinePressed()
	{
		boolean trigger = operatorJs.getRawButton(9);
		SmartDashboard.putString("Button 9", "Button 9 Is Initialized");
		return trigger;
	}
	
	public static boolean isButtonTenPressed()
	{
		boolean trigger = operatorJs.getRawButton(10);
		SmartDashboard.putString("Button 10", "Button 10 Is Initialized");
		return trigger;
	}
	
	
	
	public void controlBoardTest()
	{
		boolean buttonOne = isTriggerPressed();
    	SmartDashboard.putBoolean("TestCB", buttonOne);
    	
    	boolean buttonTwo = isButtonTwoPressed();
    	SmartDashboard.putBoolean("TestCB", buttonTwo);
    	
    	boolean buttonThree = isButtonThreePressed();
    	SmartDashboard.putBoolean("TestCB", buttonThree);
    	
    	boolean buttonFour = isButtonFourPressed();
    	SmartDashboard.putBoolean("TestCB", buttonFour);
    	
    	boolean buttonFive = isButtonFivePressed();
    	SmartDashboard.putBoolean("TestCB", buttonFive);
    	
    	boolean buttonSix = isButtonSixPressed();
    	SmartDashboard.putBoolean("TestCB", buttonSix);
    	
    	boolean joyTwoButtonOne = isButtonSixPressed();
    	SmartDashboard.putBoolean("TestCB", joyTwoButtonOne);
    	
    	boolean joyTwoButtonTwo = isButtonSixPressed();
    	SmartDashboard.putBoolean("TestCB", joyTwoButtonTwo);
    	
    	boolean joyTwoButtonThree = isButtonSixPressed();
    	SmartDashboard.putBoolean("TestCB", joyTwoButtonThree);
    	
    	boolean joyTwoButtonFour = isButtonSixPressed();
    	SmartDashboard.putBoolean("TestCB", joyTwoButtonFour);
	}

	
	}

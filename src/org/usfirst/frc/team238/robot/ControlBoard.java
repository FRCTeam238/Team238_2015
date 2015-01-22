package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ControlBoard { //Here are the joysticks for controlling the robot
	static Joystick joy1;  
	static Joystick joy2;
	
	public void controlBoardInit()
	{
		try
		{
			joy1 = new Joystick(1);
			joy2 = new Joystick(2);
			
		}
		
		catch(Exception ex)
		{
			System.out.println("ControlBoard Init Failed");
		}
	}
	// This is Button 1, it makes the claws suck things in
	public static boolean isTriggerPressed()
	{
		boolean trigger = false;
		
		try
		{
			trigger = joy1.getRawButton(1);
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
		boolean trigger = joy1.getRawButton(2);
		SmartDashboard.putString("Button 2", "Button 2 Is Initialized");
		return trigger;
	}
	// This is Button 3, it will make the claws spin items left
	public static boolean isButtonThreePressed()
	{
		boolean trigger = joy1.getRawButton(3);
		SmartDashboard.putString("Button 3", "Button 3 Is Initialized");
		return trigger;
	}
	// This is Button 4, it will make the claws spin items right
	public static boolean isButtonFourPressed()
	{
		boolean trigger = joy1.getRawButton(4);
		SmartDashboard.putString("Button 4", "Button 4 Is Initialized");
		return trigger;
	}
	// This is Button 5, it will open the Saloon Doors
	public static boolean isButtonFivePressed()
	{
		boolean trigger = joy1.getRawButton(5);
		SmartDashboard.putString("Button 5", "Button 5 Is Initialized");
		return trigger;
	}
	// This is Button 6, it will close the Saloon Doors
	public static boolean isButtonSixPressed()
	{
		boolean trigger = joy1.getRawButton(6);
		SmartDashboard.putString("Button 6", "Button 6 Is Initialized");
		return trigger;
	}
	
	public static boolean isJoy2ButtonOnePresses()
	{
		boolean trigger = joy2.getRawButton(1);
		SmartDashboard.putString("Joy2 Button 1", "Button 1 Is Initialized");
		return trigger;
	}
	
	public static boolean isJoy2ButtonTwoPresses()
	{
		boolean trigger = joy2.getRawButton(2);
		SmartDashboard.putString("Joy2 Button 2", "Button 2 Is Initialized");
		return trigger;
	}
	
	public static boolean isJoy2ButtonThreePresses()
	{
		boolean trigger = joy2.getRawButton(3);
		SmartDashboard.putString("Joy2 Button 3", "Button 3 Is Initialized");
		return trigger;
	}
	
	public static boolean isJoy2ButtonFourPresses()
	{
		boolean trigger = joy2.getRawButton(4);
		SmartDashboard.putString("Joy2 Button 4", "Button 4 Is Initialized");
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

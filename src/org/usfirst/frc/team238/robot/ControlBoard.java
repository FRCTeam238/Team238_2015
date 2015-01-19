package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ControlBoard { //Here are the joysticks for controlling the robot
	Joystick joy1;  
	Joystick joy2;
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
	public boolean isTriggerPressed()
	{
		boolean trigger = joy1.getRawButton(1);
		SmartDashboard.putString("Button 1", "Button 1 Is Presses");
		return trigger;
	}
	// This is Button 2, it makes the claws spit things out
	public boolean isButtonTwoPressed()
	{
		boolean trigger = joy1.getRawButton(2);
		SmartDashboard.putString("Button 2", "Button 2 Is Presses");
		return trigger;
	}
	// This is Button 3, it will make the claws spin items left
	public boolean isButtonThreePressed()
	{
		boolean trigger = joy1.getRawButton(3);
		SmartDashboard.putString("Button 3", "Button 3 Is Presses");
		return trigger;
	}
	// This is Button 4, it will make the claws spin items right
	public boolean isButtonFourPressed()
	{
		boolean trigger = joy1.getRawButton(4);
		SmartDashboard.putString("Button 4", "Button 4 Is Presses");
		return trigger;
	}
	// This is Button 5, it will open the Saloon Doors
	public boolean isButtonFivePressed()
	{
		boolean trigger = joy1.getRawButton(5);
		SmartDashboard.putString("Button 5", "Button 5 Is Presses");
		return trigger;
	}
	// This is Button 6, it will close the Saloon Doors
	public boolean isButtonSixPressed()
	{
		boolean trigger = joy1.getRawButton(6);
		SmartDashboard.putString("Button 6", "Button 6 Is Presses");
		return trigger;
	}
	
	public boolean isJoy2ButtonOnePresses()
	{
		boolean trigger = joy2.getRawButton(1);
		SmartDashboard.putString("Joy2 Button 1", "Button 1 Is Presses");
		return trigger;
	}
	
	public boolean isJoy2ButtonTwoPresses()
	{
		boolean trigger = joy2.getRawButton(2);
		SmartDashboard.putString("Joy2 Button 2", "Button 2 Is Presses");
		return trigger;
	}
	
	public boolean isJoy2ButtonThreePresses()
	{
		boolean trigger = joy2.getRawButton(3);
		SmartDashboard.putString("Joy2 Button 3", "Button 3 Is Presses");
		return trigger;
	}
	
	public boolean isJoy2ButtonFourPresses()
	{
		boolean trigger = joy2.getRawButton(4);
		SmartDashboard.putString("Joy2 Button 4", "Button 4 Is Presses");
		return trigger;
	}
}

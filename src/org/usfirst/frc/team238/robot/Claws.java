package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Claws {
	
	Relay leftClawMotor;//These lines declare the spikes
	Relay rightClawMotor; //that will control the claw motors
	ControlBoard theControlBoard;
	
	//These lines are initializing the Relays and the controlboard
	public void clawsInit()
	{
		try
		{
			leftClawMotor = new Relay(4);
			SmartDashboard.putString("leftClawMotor", "initialized");
			rightClawMotor = new Relay(5);
			SmartDashboard.putString("rightClawMotor", "initialized");
			theControlBoard = new ControlBoard();
			SmartDashboard.putString("theControlBoard", "initialized");
		}
		
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	//This function will cause the claws to spin inwards
	public void suckItemsIn()
	{
		
		if(theControlBoard.isTriggerPressed() == true)
		{
			leftClawMotor.set(Relay.Value.kForward);
			rightClawMotor.set(Relay.Value.kReverse);
			SmartDashboard.putString("suckItemsIn", "I'm On");
		}
		else
		{
			leftClawMotor.set(Relay.Value.kOff);
			rightClawMotor.set(Relay.Value.kOff);
			SmartDashboard.putString("suckItemsIn", "I'm Off");
		}	
	}
	
	//This function will cause the claws to spin outwards
	public void spitItemsOut()
	{
		if(theControlBoard.isButtonTwoPressed() == true)
		{
			leftClawMotor.set(Relay.Value.kReverse);
			rightClawMotor.set(Relay.Value.kForward);
			SmartDashboard.putString("spitItemsOut", "I'm On");
		}
		else
		{
			leftClawMotor.set(Relay.Value.kOff);
			rightClawMotor.set(Relay.Value.kOff);
			SmartDashboard.putString("spitItemsOut", "I'm Off");
		}
	}
		
		

	
	//This function will cause the claw motors to spin left, rotating game pieces right
	public void spinItemsRight()
	{
		
		if(theControlBoard.isButtonFourPressed() == true)
		{
			leftClawMotor.set(Relay.Value.kForward);
			rightClawMotor.set(Relay.Value.kForward);
			SmartDashboard.putString("spinItemsRight", "I'm On");
		}
		else
		{
			leftClawMotor.set(Relay.Value.kOff);
			rightClawMotor.set(Relay.Value.kOff);
			SmartDashboard.putString("spinItemsRight", "I'm Off");
		}
	}
	
	//This function will cause the claw motors to spin right, rotating game pieces left
	public void spinItemsLeft()
	{
		if(theControlBoard.isButtonThreePressed() == true)
		{
			leftClawMotor.set(Relay.Value.kReverse);
			rightClawMotor.set(Relay.Value.kReverse);
			SmartDashboard.putString("spinItemsLeft", "I'm On");
		}
		else
		{
			leftClawMotor.set(Relay.Value.kOff);
			rightClawMotor.set(Relay.Value.kOff);
			SmartDashboard.putString("spinItemsLeft", "I'm Off");
		}	
	}
}


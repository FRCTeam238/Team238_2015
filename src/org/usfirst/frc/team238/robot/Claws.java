package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Jaguar;
//import edu.wpi.first.wpilibj.Relay;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Claws {

	Talon leftClawMotor;//These lines declare the talons
	Jaguar rightClawMotor; //that will control the claw motors
	//Relay test;

	//These lines are initializing the Relays and the controlboard
	public void clawsInit()
	{
		try
		{
			leftClawMotor = new Talon(4);
			SmartDashboard.putString("leftClawMotor", "initialized");
			rightClawMotor = new Jaguar(5);
			SmartDashboard.putString("rightClawMotor", "initialized");
			SmartDashboard.putString("theControlBoard", "initialized");
			//test = new Relay(0);
		}

		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	//This function will cause the claws to spin inwards
	public void suckItemsIn()
	{


		leftClawMotor.set(ControlBoard.joy1.getX());
		rightClawMotor.set(ControlBoard.joy1.getX());
		SmartDashboard.putString("suckItemsIn", "I'm On");
		//test.set(Relay.Value.kForward);

	}
		//This function will cause the claws to spin outwards
	public void spitItemsOut()
	{

		leftClawMotor.set(CrusaderCommon.CLAWMOTORSPEED);
		rightClawMotor.set(CrusaderCommon.CLAWMOTORSPEEDREVERSE);
		SmartDashboard.putString("spitItemsOut", "I'm On");

	}

		//This function will cause the claw motors to spin left, rotating game pieces right
	public void spinItemsRight()
	{


		leftClawMotor.set(CrusaderCommon.CLAWMOTORSPEED);
		rightClawMotor.set(CrusaderCommon.CLAWMOTORSPEED);
		SmartDashboard.putString("spinItemsRight", "I'm On");

	}

	//This function will cause the claw motors to spin right, rotating game pieces left
	public void spinItemsLeft()
	{

		leftClawMotor.set(CrusaderCommon.CLAWMOTORSPEEDREVERSE);
		rightClawMotor.set(CrusaderCommon.CLAWMOTORSPEEDREVERSE);
		SmartDashboard.putString("spinItemsLeft", "I'm On");

	}

	public void stop()
	{
		leftClawMotor.set(CrusaderCommon.MOTOROFF);
		rightClawMotor.set(CrusaderCommon.MOTOROFF);
		SmartDashboard.putString("Claws.stop()", "I'm Off");
	}
}
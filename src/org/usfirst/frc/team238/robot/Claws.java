package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Jaguar;
//import edu.wpi.first.wpilibj.Relay;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Claws {

	Talon clawMotor;//These lines declare the talons
	int channel;
	//These lines are initializing the Relays and the controlboard
	public void clawsInit(int channel)
	{
		this.channel = channel;
		try
		{
			clawMotor = new Talon(channel);
			SmartDashboard.putString("ClawMotorChannel:"+ channel, "initialized");
		}

		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	//This function will cause the claws to spin inwards
	public void suckItemsIn()
	{


		//lawMotor.set(ControlBoard.driverLeftJs.getX());
		SmartDashboard.putString("suckItemsIn", "I'm On");
		//test.set(Relay.Value.kForward);

	}
		//This function will cause the claws to spin outwards
	public void spitItemsOut()
	{

		//clawMotor.set(CrusaderCommon.CLAWMOTORSPEED);
		SmartDashboard.putString("spitItemsOut", "I'm On");

	}

		//This function will cause the claw motors to spin left, rotating game pieces right
	public void spinItemsRight()
	{
		clawMotor.set(CrusaderCommon.CLAWMOTORSPEED);
		
		SmartDashboard.putString("spinItemsRight", "I'm On");
	}

	//This function will cause the claw motors to spin right, rotating game pieces left
	public void spinItemsLeft()
	{

		clawMotor.set(CrusaderCommon.CLAWMOTORSPEEDREVERSE);
		SmartDashboard.putString("spinItemsLeft", "I'm On");

	}

	public void stop()
	{
		clawMotor.set(CrusaderCommon.MOTOROFF);
		
		SmartDashboard.putString("Claws.stop()", "I'm Off");
	}
}
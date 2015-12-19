package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.Talon;


//import edu.wpi.first.wpilibj.Relay;

public class Claws {

	Talon clawMotorLeft;//These lines declare the talons
	Talon clawMotorRight;
	
	public void clawsInit()
	{
		clawMotorLeft = new Talon(8);
		clawMotorRight = new Talon(9);
	}
	
	public void spinIn()
	{
		clawMotorLeft.set(CrusaderCommon.CLAWMOTORSPEED);
		clawMotorRight.set(CrusaderCommon.CLAWMOTORSPEEDREVERSE);
	}
	
	public void spinOut()
	{
		clawMotorLeft.set(CrusaderCommon.CLAWMOTORSPEEDREVERSE);
		clawMotorRight.set(CrusaderCommon.CLAWMOTORSPEED);
	}
}
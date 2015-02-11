package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shifter {
	
	Solenoid leftSolenoid;
	Solenoid rightSolenoid;
	int shiftState;
	
	public void init() {
		
		leftSolenoid = new Solenoid(4);
		
		rightSolenoid = new Solenoid(5);
		
		setLowGear();
		
			
	}
	
	private void setHighGear() 
	{
		
		leftSolenoid.set(CrusaderCommon.SHIFTER_HIGH_GEAR);
		SmartDashboard.getBoolean("leftSolenoid", leftSolenoid.get());
		rightSolenoid.set(CrusaderCommon.SHIFTER_HIGH_GEAR);
		SmartDashboard.getBoolean("rightSolenoid", rightSolenoid.get());
		
		shiftState = CrusaderCommon.SHIFT_STATE_HIGH_GEAR;
			
	}

	private void setLowGear()
	{

		leftSolenoid.set(CrusaderCommon.SHIFTER_LOW_GEAR);
		SmartDashboard.getBoolean("leftSolenoid", leftSolenoid.get());
		rightSolenoid.set(CrusaderCommon.SHIFTER_LOW_GEAR);
		SmartDashboard.getBoolean("rightSolenoid", rightSolenoid.get());
		
		shiftState = CrusaderCommon.SHIFT_STATE_LOW_GEAR;
		
	}	
	
	public void shiftingGears()
	{
	//We need a class level variable called shift state
		//if low shift to high; set shift state to high
		//else its high; shift to low; set shift state to low
		//
		
	}
	
	
}
	
	

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
	
	public void setHighGear() 
	{
		
		leftSolenoid.set(CrusaderCommon.SHIFTER_HIGH_GEAR);
		SmartDashboard.putBoolean("leftSolenoid", leftSolenoid.get());
		rightSolenoid.set(CrusaderCommon.SHIFTER_HIGH_GEAR);
		SmartDashboard.putBoolean("rightSolenoid", rightSolenoid.get());
		
		
		shiftState = CrusaderCommon.SHIFT_STATE_HIGH_GEAR;
			
	}

	public void setLowGear()
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
		//if state is high it will stay in high till pressed low
		//else its high; shift to low; set shift state to low
		//
		
		if(shiftState == CrusaderCommon.SHIFT_STATE_LOW_GEAR)
		{
			shiftState = CrusaderCommon.SHIFT_STATE_HIGH_GEAR;
		}
		
		else
		{
			shiftState = CrusaderCommon.SHIFT_STATE_LOW_GEAR;
		}
		
		
	}
	
}
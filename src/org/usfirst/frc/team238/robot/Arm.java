package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/*
 * added talon, pid, encoder, joystick to code and intalalized them and added arm to robot.java
 */
public class Arm {
	Talon armTalon;
	PIDController armPID;
	DigitalInput armEncoder;
	Joystick armJoySlider;
	SmartDashboard smartDash;
	
	double sliderValue;
	
	public void armInit() 
	{
		armTalon = new Talon(4);
		armEncoder = new DigitalInput(9);
		armJoySlider = new Joystick(1);
		
	}
/* i added slider value to smartdash and inizalized it/
 *  we want to be able to use all the arms to the whole extent of the X axis 
 *  (even thought the slider looks like it is using the Y axis, look at Driver Station)
 *  
 *  the arm will be reading in the value of the slider and transfer that into the 
 *  amount of ticks the encoder needs to spin until it stops.
 *  Most likely there will be some if-else statements in both.
 *  Commenting done by SD and AT(@) */
	public void raiseArm()
	{
		//if the slidervalue equals encoder value, do nothing
		//else go up
		sliderValue = armJoySlider.getX();
		SmartDashboard.putNumber("sliderValue", sliderValue);
		System.out.println("Hello World");
		//armTalon.set(CrusaderCommon.ARM_MOTOR_SPEED);
		
		if (armJoySlider.getX() > 0.2)
		{
			armTalon.set(CrusaderCommon.ARM_MOTOR_SPEED);
		}
		else if (armJoySlider.getX() < -0.2)
		{
			armTalon.set(CrusaderCommon.ARM_MOTOR_SPEED_REVERSE);
		}
		else
		{
			armTalon.set(CrusaderCommon.MOTOROFF);
		}
			
	}
	
	public void lowerArm()
	{
		//if the slidervalue equals encoder value, do nothing
		//else go down
		sliderValue = armJoySlider.getX();
		SmartDashboard.putNumber("sliderValue", sliderValue);
		armTalon.set(CrusaderCommon.ARM_MOTOR_SPEED_REVERSE);
	}
	
	
}

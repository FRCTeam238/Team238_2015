package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogPotentiometer;


public class Lift 
{	
	//Declarations of the pistons for the claw
	Solenoid rightFrontPiston;
	Solenoid rightBackPiston;
	Solenoid leftFrontPiston;
	Solenoid leftBackPiston;


	//Compressor compress;  May not be needed

	//Switches that tell the elevator when to stop
	DigitalInput raisedSwitch;
	DigitalInput travelSwitch;
	DigitalInput loadedSwitch;
	DigitalInput coopSwitch;

	int currentLiftLevel;  

	//motors to control the lift
	Jaguar liftMotorLeft;  
	Jaguar liftMotorRight;

	AnalogPotentiometer leftPotens;
	AnalogPotentiometer rightPotens;
	double potensOffsetValue = 0.0; //cant Zero a pot so need something to hold whatthe opffset is between the two
	
	double leftPotMin; 
	double leftPotMax; 
	double rightPotMin;
	double rightPotMax;
	
	
	public void liftInit()
	{
		//initializations of everything
		try{

			// The pneumatics are used to clamp onto the new game piece
			rightFrontPiston = new Solenoid(0); 
			rightBackPiston = new Solenoid(1); 
			leftFrontPiston = new Solenoid(2);
			leftBackPiston = new Solenoid(3);  


			//These are Sensors that will tell the height of the lift
			//loadedSwitch = new DigitalInput(4); // This level is when the robot is picking up the tower
			//travelSwitch = new DigitalInput(5); // This level is used when robot is traveling with the tower
			//raisedSwitch = new DigitalInput(6); // This level is when we are approaching a new tote or a bin
			//coopSwitch = new DigitalInput(7);

			currentLiftLevel = CrusaderCommon.GROUND_LEVEL; // Maybe?  under revise
			SmartDashboard.putNumber("CurrentLevel: ", currentLiftLevel);

			//These will bring the game piece up or down
			liftMotorRight= new Jaguar(7);  
			liftMotorLeft = new Jaguar(6); 

			//This is the potentiometer which may be added for more acuraccy
			leftPotens = new AnalogPotentiometer(2); // these go into analog ports
			rightPotens = new AnalogPotentiometer(3);
			
			letItGo();
			setPotOffsetValue();
			setMinAndMax(currentLiftLevel);

		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());  
		}
	}
	public int getLevel()
	{
		return currentLiftLevel;
	}
	
	public void manualControlOfLifter(double overRideValue)  
	{
		liftMotorRight.set(overRideValue);
		liftMotorLeft.set(overRideValue);
		SmartDashboard.putNumber("ManualMode", overRideValue);
		
	}
	
	public void setMinAndMax(int level){
		
		switch(level){
			case CrusaderCommon.GROUND_LEVEL:
				leftPotMin = CrusaderCommon.POT_GROUND - CrusaderCommon.POT_NEUTRAL_ZONE;
				leftPotMax = CrusaderCommon.POT_GROUND + CrusaderCommon.POT_NEUTRAL_ZONE;
				rightPotMin = CrusaderCommon.POT_GROUND - CrusaderCommon.POT_NEUTRAL_ZONE;
				rightPotMax = CrusaderCommon.POT_GROUND + CrusaderCommon.POT_NEUTRAL_ZONE;
				break;
			case CrusaderCommon.TRAVEL_LEVEL:
				leftPotMin = CrusaderCommon.POT_TRAVEL - CrusaderCommon.POT_NEUTRAL_ZONE;
				leftPotMax = CrusaderCommon.POT_TRAVEL + CrusaderCommon.POT_NEUTRAL_ZONE;
				rightPotMin = CrusaderCommon.POT_TRAVEL - CrusaderCommon.POT_NEUTRAL_ZONE;
				rightPotMax = CrusaderCommon.POT_TRAVEL + CrusaderCommon.POT_NEUTRAL_ZONE;
				break;
			case CrusaderCommon.COOP_LEVEL:
				leftPotMin = CrusaderCommon.POT_COOP - CrusaderCommon.POT_NEUTRAL_ZONE;
				leftPotMax = CrusaderCommon.POT_COOP + CrusaderCommon.POT_NEUTRAL_ZONE;
				rightPotMin = CrusaderCommon.POT_COOP - CrusaderCommon.POT_NEUTRAL_ZONE;
				rightPotMax = CrusaderCommon.POT_COOP + CrusaderCommon.POT_NEUTRAL_ZONE;
				break;
			case CrusaderCommon.LOADING_LEVEL:
				leftPotMin = CrusaderCommon.POT_LOADING - CrusaderCommon.POT_NEUTRAL_ZONE;
				leftPotMax = CrusaderCommon.POT_LOADING + CrusaderCommon.POT_NEUTRAL_ZONE;
				rightPotMin = CrusaderCommon.POT_LOADING - CrusaderCommon.POT_NEUTRAL_ZONE;
				rightPotMax = CrusaderCommon.POT_LOADING + CrusaderCommon.POT_NEUTRAL_ZONE;
				break;
			case CrusaderCommon.DELIVER_LEVEL:
				leftPotMin = CrusaderCommon.POT_GROUND - CrusaderCommon.POT_NEUTRAL_ZONE;
				leftPotMax = CrusaderCommon.POT_GROUND + CrusaderCommon.POT_NEUTRAL_ZONE;
				
				rightPotMin = CrusaderCommon.POT_GROUND - CrusaderCommon.POT_NEUTRAL_ZONE;
				rightPotMax = CrusaderCommon.POT_GROUND + CrusaderCommon.POT_NEUTRAL_ZONE;
				break;
			default:
				leftPotMin = CrusaderCommon.POT_GROUND - CrusaderCommon.POT_NEUTRAL_ZONE;
				leftPotMax = CrusaderCommon.POT_GROUND + CrusaderCommon.POT_NEUTRAL_ZONE;
				
				rightPotMin = CrusaderCommon.POT_GROUND - CrusaderCommon.POT_NEUTRAL_ZONE;
				rightPotMax = CrusaderCommon.POT_GROUND + CrusaderCommon.POT_NEUTRAL_ZONE;
				break;
				
		}
		
	}
	
	/* we use the left side pot as the reference, determine the difference between right and left as the value 
	 * to be used as the "offset". Add that value (pos or neg) to the right side every time a get() is done
	 * to essentially "level" them. Then the checks can be done to see if they are getting out o synch  
	 */
	private void setPotOffsetValue(){
		double leftPOtValue = leftPotens.get();
		double rightPOtValue = rightPotens.get();
		
		potensOffsetValue = leftPOtValue - rightPOtValue;
	}
	
	private boolean isAtLevel(double level, double leftPot, double rightPot){
		boolean atLevel = false;
		double leftSide = leftPot - level;
		double rightSide = rightPot- level;
		
		if((Math.abs(leftSide) < CrusaderCommon.POT_DEAD_BAND) || (Math.abs(rightSide) < CrusaderCommon.POT_DEAD_BAND))
		{
			atLevel = true;
		}
		
		return atLevel;
	}
	
	/*
	 * The jaguars will start going forward and the lift will go up.
	 * 
	 */
	public void liftGoesUp(double differential)  
	{	
		//if the potentiometers readings are more than "X" different we need to adjust motor speed
		if( Math.abs(differential) > CrusaderCommon.POT_DIFF_MAX)
		{
			if(differential < 0)
			{
				liftMotorRight.set(CrusaderCommon.LIFT_GOES_UP_NORMAL);
				//left side is above right side so slow it down
				liftMotorLeft.set(CrusaderCommon.LIFT_GOES_UP_NORMAL);
			}
			else
			{
				//left side is below right side so slow right down
				liftMotorRight.set(CrusaderCommon.LIFT_GOES_UP_NORMAL);
				liftMotorLeft.set(CrusaderCommon.LIFT_GOES_UP_NORMAL);
			}
		}
		else
		{
			liftMotorRight.set(CrusaderCommon.LIFT_GOES_UP_NORMAL);
			liftMotorLeft.set(CrusaderCommon.LIFT_GOES_UP_NORMAL);
		}
		
		SmartDashboard.putNumber("Lift Motor Right", liftMotorRight.get());
		SmartDashboard.putNumber("Lift Motor Left", liftMotorLeft.get());
	}
	
	

	
	/*
	 * The jaguars will start going backwards and the lift will go down.
	 */
	public void liftGoesDown(double differential)  
	{	
		//if the potentiometers readings are more than "X" different we need to adjust motor speed
		if( Math.abs(differential) > CrusaderCommon.POT_DIFF_MAX)
		{
			if(differential < 0)
			{
				//left side is above right side so slow right down
				liftMotorRight.set(CrusaderCommon.LIFT_GOES_DOWN_NORMAL);
				liftMotorLeft.set(CrusaderCommon.LIFT_GOES_DOWN_NORMAL);	
			}
			else
			{
				//left side is below right side so slow left down
				liftMotorRight.set(CrusaderCommon.LIFT_GOES_DOWN_NORMAL);
				liftMotorLeft.set(CrusaderCommon.LIFT_GOES_DOWN_NORMAL);
			}
		}
		else
		{
			liftMotorRight.set(CrusaderCommon.LIFT_GOES_DOWN_NORMAL);
			liftMotorLeft.set(CrusaderCommon.LIFT_GOES_DOWN_NORMAL);
		}	
		
		SmartDashboard.putNumber("Lift Motor Right", liftMotorRight.get());
		SmartDashboard.putNumber("Lift Motor Left", liftMotorLeft.get());
	}

	/*
	 * The jaguars will stop.  
	 * The output will be 0, for the jaguar will be set to zero. 
	 */
	public void stop()
	{
		liftMotorRight.set(CrusaderCommon.LIFT_STOPS);
		liftMotorLeft.set(CrusaderCommon.LIFT_STOPS);
	}

	private int update(Jaguar motor, double potValue,  double min, double max ) {
		int direction = CrusaderCommon.LIFT_STOPS;
		
		if( (potValue >= min) && (potValue <= max))
		{
			motor.set(CrusaderCommon.LIFT_STOPS);
		}
		else if( potValue > max)
		{
			//going up
			motor.set(CrusaderCommon.LIFT_GOES_UP_NORMAL);
			direction = CrusaderCommon.LIFT_GOES_UP_NORMAL;
		}
		else 
		{
			motor.set(CrusaderCommon.LIFT_GOES_DOWN_NORMAL);
			direction = CrusaderCommon.LIFT_GOES_DOWN_NORMAL;
		}
		
		
		return direction;
	}
	
	private void goToSpecifiedLevel(int level){
		
		double loadPotValueLeft = leftPotens.get();
		double loadPotValueRight = rightPotens.get() - .020;
		double differential = loadPotValueLeft -  loadPotValueRight;
		
		setMinAndMax(level);
		
		int leftDirection = update(liftMotorLeft, loadPotValueLeft,  leftPotMin, leftPotMax );
		int rightDirection = update(liftMotorRight, loadPotValueRight,  rightPotMin, rightPotMax);
		
		/* if both update calls come back with stop then set to Loading Level
		 * if both come back other than stop make the call to see if they need balancing
		 * if one is in the stopped state just leave it and the other will catch up
		 */
		if( (leftDirection == CrusaderCommon.LIFT_STOPS) && (rightDirection == CrusaderCommon.LIFT_STOPS))
		{
			currentLiftLevel = level;
		}
		else if ((leftDirection != CrusaderCommon.LIFT_STOPS) && (rightDirection != CrusaderCommon.LIFT_STOPS))
		{
			if((leftDirection == CrusaderCommon.LIFT_GOES_UP_NORMAL) || (rightDirection == CrusaderCommon.LIFT_GOES_UP_NORMAL))
			{
				liftGoesUp(differential);
			}
			else
			{
				liftGoesDown(differential);
			}
		} //otherwise leave well enough alone.
		
		SmartDashboard.putNumber("PotValueLeft", loadPotValueLeft);
		SmartDashboard.putNumber("PotValueRight", loadPotValueRight);
		SmartDashboard.putNumber("Level MIN", leftPotMin);
		SmartDashboard.putNumber("Level MAX", leftPotMax);
		SmartDashboard.putNumber("Left Dir", leftDirection);
		SmartDashboard.putNumber("Right Dir", rightDirection);
		SmartDashboard.putNumber("CurLevel: ", currentLiftLevel);
		SmartDashboard.putNumber("TargetLevel: ", level);
	}
	
	public void setToGround()  
	{
		goToSpecifiedLevel(CrusaderCommon.GROUND_LEVEL);
	}
	
	public void liftToLoadLevel()  
	{
		goToSpecifiedLevel(CrusaderCommon.LOADING_LEVEL);
	}
	
	/*
	 * This method will bring the lift to level 1 from any height
	 * Lift will stop when the travelSwitch is hit
	 * start making a Static final variables
	 */
	public void travelingMode() 
	{
		goToSpecifiedLevel(CrusaderCommon.TRAVEL_LEVEL);
	}
	
	public void setToCoop()
	{
		goToSpecifiedLevel(CrusaderCommon.COOP_LEVEL);
	}

	public void clampOn()    
	{						 		

		rightFrontPiston.set(true);
		rightBackPiston.set(true);
		leftFrontPiston.set(true);
		leftBackPiston.set(true);

	}

	/*
	 *  This signals the right pistons to turn off.
	 *	This read in a button value to see if it is true or not.
	 *  If the button is not pressed, than the solenoids on the right side will turn off.
	 */	
	public void letItGo()   
	{		

		rightFrontPiston.set(false);
		rightBackPiston.set(false);
		leftFrontPiston.set(false);
		leftBackPiston.set(false);
	}

	
}
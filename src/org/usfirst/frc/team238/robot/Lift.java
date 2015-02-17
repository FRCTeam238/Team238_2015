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

	int level;  

	//motors to control the lift
	Jaguar liftMotorLeft;  
	Jaguar liftMotorRight;

	AnalogPotentiometer leftPotens;
	AnalogPotentiometer rightPotens;
	double potensOffsetValue = 0.0; //cant sero a pot so need something to hold whatthe opffset is between the two
	
	int Sensor[]; 


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
			loadedSwitch = new DigitalInput(4); // This level is when the robot is picking up the tower
			travelSwitch = new DigitalInput(5); // This level is used when robot is traveling with the tower
			raisedSwitch = new DigitalInput(6); // This level is when we are approaching a new tote or a bin
			coopSwitch = new DigitalInput(7);

			Sensor = new int[4];

			level = CrusaderCommon.GROUND_LEVEL; // Maybe?  under revise
			SmartDashboard.putNumber("Level: ", level);

			//These will bring the game piece up or down
			liftMotorRight= new Jaguar(6);  
			liftMotorLeft = new Jaguar(7); 

			//This is the potentiometer which may be added for more acuraccy
			leftPotens = new AnalogPotentiometer(2); // these go into analog ports
			rightPotens = new AnalogPotentiometer(3);
			
			setPotOffsetValue();

		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());  
		}
	}
	public int getLevel()
	{
		return level;
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
	 * I set the Jag speed to .5 for now.  It can be adjusted when robot robot is built
	 *
	public void liftGoesUp(double leftPot, double rightPot)  
	{	
		if(leftPot > rightPot)
		{
			liftMotorRight.set(CrusaderCommon.LIFT_GOES_UP_SLOW);
			liftMotorLeft.set(CrusaderCommon.LIFT_GOES_UP_NORMAL);
		}
		else if(leftPot < rightPot)
		{
			liftMotorRight.set(CrusaderCommon.LIFT_GOES_UP_NORMAL);
			liftMotorLeft.set(CrusaderCommon.LIFT_GOES_UP_SLOW);
		}
		else
		{
			liftMotorRight.set(CrusaderCommon.LIFT_GOES_UP_NORMAL);
			liftMotorLeft.set(CrusaderCommon.LIFT_GOES_UP_NORMAL);
		}
		
		SmartDashboard.putNumber("Lift Motor Right", liftMotorRight.get());
		SmartDashboard.putNumber("Lift Motor Left", liftMotorLeft.get());
	}
	 */
	
	/*
	 * The jaguars will start going forward and the lift will go up.
	 * I set the Jag speed to .5 for now.  It can be adjusted when robot robot is built
	 */
	public void liftGoesUp(double leftPot, double rightPot)  
	{	
		double differential = leftPot - rightPot;
		
		//if the potentiometers readings are more than "X" different we need to adjust motor speed
		if( Math.abs(differential) > CrusaderCommon.POT_DIFF_MAX)
		{
			if(differential < 0)
			{
				liftMotorRight.set(CrusaderCommon.LIFT_GOES_UP_NORMAL);
				liftMotorLeft.set(CrusaderCommon.LIFT_GOES_UP_SLOW);
			}
			else
			{
				liftMotorRight.set(CrusaderCommon.LIFT_GOES_UP_SLOW);
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
	public void manualControlOfLifter(double overRideValue)  
	{
		liftMotorRight.set(overRideValue);
		liftMotorLeft.set(overRideValue);
	}

	/*
	 * The jaguars will start going backwards and the lift will go down.
	 * I set the Jag speed to -.5 for now.  It can be adjusted when robot robot is built
	 
	public void liftGoesDown(double lPot, double rPot)  
	{	
		if(lPot > rPot)
		{
			liftMotorRight.set(CrusaderCommon.LIFT_GOES_DOWN_NORMAL);
			liftMotorLeft.set(CrusaderCommon.LIFT_GOES_DOWN_SLOW);
		}
		else if(lPot < rPot)
		{
			liftMotorRight.set(CrusaderCommon.LIFT_GOES_DOWN_SLOW);
			liftMotorLeft.set(CrusaderCommon.LIFT_GOES_DOWN_NORMAL);
		}
		else
		{
			liftMotorRight.set(CrusaderCommon.LIFT_GOES_DOWN_NORMAL);
			liftMotorLeft.set(CrusaderCommon.LIFT_GOES_DOWN_NORMAL);
		}
		
		SmartDashboard.putNumber("Lift Motor Right", liftMotorRight.get());
		SmartDashboard.putNumber("Lift Motor Left", liftMotorLeft.get());
	}
	*/
	/*
	 * The jaguars will start going backwards and the lift will go down.
	 * I set the Jag speed to -.5 for now.  It can be adjusted when robot robot is built
	 */
	public void liftGoesDown(double lPot, double rPot)  
	{	
		double differential = lPot - rPot;
		
		//if the potentiometers readings are more than "X" different we need to adjust motor speed
		if( Math.abs(differential) > CrusaderCommon.POT_DIFF_MAX)
		{
			if(differential < 0)
			{
				liftMotorRight.set(CrusaderCommon.LIFT_GOES_DOWN_SLOW);
				liftMotorLeft.set(CrusaderCommon.LIFT_GOES_DOWN_NORMAL);	
			}
			else
			{
				liftMotorRight.set(CrusaderCommon.LIFT_GOES_DOWN_NORMAL);
				liftMotorLeft.set(CrusaderCommon.LIFT_GOES_DOWN_SLOW);
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

	public void liftToLoadLevel()  
	{
		double loadPotValueLeft = leftPotens.get();
		double loadPotValueRight = rightPotens.get() + potensOffsetValue;

		//if(((loadPotValueLeft <= CrusaderCommon.POT_LOADING_MIN) || (loadPotValueRight <= CrusaderCommon.POT_LOADING_MIN))) 
		if(isAtLevel(CrusaderCommon.POT_LOADING, loadPotValueLeft, loadPotValueRight))
		{
			stop(); 
			level = CrusaderCommon.LOADING_LEVEL;
		}
		else
		{
			liftGoesUp(loadPotValueLeft, loadPotValueRight);
		}

		//SmartDashboard.putBoolean("Load Switch Hit: ", loadedSwitch.get());
		SmartDashboard.putNumber("Level: ", level);
		SmartDashboard.putNumber("loadPotValueLeft", loadPotValueLeft);
		SmartDashboard.putNumber("loadPotValueRight", loadPotValueRight);
	}
	/*
	 * This method will bring the lift to level 1 from any height
	 * Lift will stop when the travelSwitch is hit
	 * start making a Static final variables
	 */
	public void travelingMode() 
	{	

		double travelPotValueLeft = leftPotens.get();
		double travelPotValueRight = rightPotens.get() + potensOffsetValue;

		//if(((travelPotValueLeft >= CrusaderCommon.POT_TRAVEL_MAX) && (travelPotValueLeft <= CrusaderCommon.POT_TRAVEL_MIN)) ||( (travelPotValueRight >= CrusaderCommon.POT_TRAVEL_MAX) && (travelPotValueRight <= CrusaderCommon.POT_TRAVEL_MIN)))//((travelSwitch.get() == true) || )  //The lift will stop when travelSwitch is hit
		if(isAtLevel(CrusaderCommon.POT_TRAVEL, travelPotValueLeft, travelPotValueRight))
		{
			stop();
			level = CrusaderCommon.TRAVEL_LEVEL;
		}
		else
		{
			if (level == CrusaderCommon.GROUND_LEVEL)
			{
				liftGoesUp(travelPotValueLeft, travelPotValueRight);			
			}
			else
			{
				liftGoesDown(travelPotValueLeft, travelPotValueRight);				
			}

		}
		SmartDashboard.putNumber("TravelPotValueRight", travelPotValueRight);
		SmartDashboard.putNumber("TravelPotValueLeft", travelPotValueLeft);
		//SmartDashboard.putBoolean("Travel Switch Hit: ", travelSwitch.get());
		SmartDashboard.putNumber("Level: ", level);


	}
	/*
	 * This method will bring the lift to level 0 from any height.
	 * Lift will stop when raisedSwitch is hit
	 */
	public void setToGround()  
	{	
		double groundPotValueLeft = leftPotens.get();
		double groundPotValueRight = rightPotens.get() + potensOffsetValue;

		//if((groundPotValueLeft >= CrusaderCommon.POT_GROUND) && (groundPotValueRight >= CrusaderCommon.POT_GROUND))//(raisedSwitch.get() == true || )  //The lift will stop when raisedSwitch is hit
		if(isAtLevel(CrusaderCommon.POT_GROUND, groundPotValueLeft, groundPotValueRight))
		{
			stop();
			level = CrusaderCommon.GROUND_LEVEL;
		}
		else 
		{
			liftGoesDown(groundPotValueLeft, groundPotValueRight);
		}

		//SmartDashboard.putBoolean("Ground Switch Hit: ", raisedSwitch.get());
		SmartDashboard.putNumber("Level: ", level);
		SmartDashboard.putNumber("GroundPotValueRight", groundPotValueRight);
		SmartDashboard.putNumber("GroundPotValueLeft", groundPotValueLeft);
	}


	public void setToCoop()
	{
		double coopPotValueLeft = leftPotens.get();
		double coopPotValueRight = rightPotens.get() + potensOffsetValue;

		//if((coopPotValueLeft >= CrusaderCommon.POT_COOP_MAX) && (coopPotValueLeft <= CrusaderCommon.POT_COOP_MIN) || (coopPotValueRight >= CrusaderCommon.POT_COOP_MAX) && (coopPotValueRight <= CrusaderCommon.POT_COOP_MIN))//)((coopSwitch.get() == true) || 
		if(isAtLevel(CrusaderCommon.POT_COOP, coopPotValueLeft, coopPotValueRight))
		{
			stop();
			level = CrusaderCommon.COOP_LEVEL;
		}
		else
		{
			if(level == CrusaderCommon.LOADING_LEVEL)
			{
				liftGoesDown(coopPotValueLeft, coopPotValueRight);
			}
			else
			{
				liftGoesUp(coopPotValueLeft, coopPotValueRight);
			}
		}
		SmartDashboard.putNumber("CoopPotValueRight", coopPotValueRight);
		SmartDashboard.putNumber("CoopPotValueLeft", coopPotValueLeft);
		SmartDashboard.putNumber("Level: ", level);

	}

	// Here are the pneumatics parts where the lift clamps on

	/*
	 *  This signals the right pistons to turn on.
	 *	This read in a button value to see if it is true or not.
	 *  If the button is pressed, than the solenoids on the right side will turn on.
	 */
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

	/*
	public void test()
	{
		liftGoesUp();
		liftGoesDown();
		stop();
		liftGameObjects();
		travelingMode();
		setToGround();
		clampOn();
		letItGo();
		System.out.println("All set and ready to go.");


	}	
	 */
}





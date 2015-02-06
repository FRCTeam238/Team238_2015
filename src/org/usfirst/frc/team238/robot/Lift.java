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

	AnalogPotentiometer potens;

	public void liftInit()
	{
		//initializations of everything
		try{

			// The pneumatics are used to clamp onto the new game piece
			rightFrontPiston = new Solenoid(0); 
			SmartDashboard.putBoolean("Right Front Piston: ", rightFrontPiston.get());
			rightBackPiston = new Solenoid(1); 
			SmartDashboard.putBoolean("Right Rear Piston", rightBackPiston.get());
			leftFrontPiston = new Solenoid(2);
			SmartDashboard.putBoolean("Left Front Pistons:", leftFrontPiston.get());
			leftBackPiston = new Solenoid(3);  
			SmartDashboard.putBoolean("Left Back Piston:", leftBackPiston.get());

			
		    //These are Sensors that will tell the height of the lift
			loadedSwitch = new DigitalInput(4); // This level is when the robot is picking up the tower
			SmartDashboard.putBoolean("Load Switch Hit: ", loadedSwitch.get());
			travelSwitch = new DigitalInput(5); // This level is used when robot is traveling with the tower
			SmartDashboard.putBoolean("Travel Switch Hit: ", travelSwitch.get());
			raisedSwitch = new DigitalInput(6); // This level is when we are approaching a new tote or a bin
			SmartDashboard.putBoolean("Raised Switch Hit: ", raisedSwitch.get());
			coopSwitch = new DigitalInput(7);
			SmartDashboard.putBoolean("Co-Op Switch Hit: ", coopSwitch.get());

			level = CrusaderCommon.GROUND_LEVEL; // Maybe?  under revise
			SmartDashboard.putNumber("Level: ", level);

			//These will bring the game piece up or down
			liftMotorRight= new Jaguar(6);  
			SmartDashboard.putNumber("Right Lift Motor: ", liftMotorRight.get());
			liftMotorLeft = new Jaguar(7); 
			SmartDashboard.putNumber("Left Lift Motor: ", liftMotorLeft.get());

			//This is the potentiometer which may be added for more acuraccy
			potens = new AnalogPotentiometer(2); // these go into analog ports

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
	
	/*
	 * The jaguars will start going forward and the lift will go up.
	 * I set the Jag speed to .5 for now.  It can be adjusted when robot robot is built
	 */
	public void liftGoesUp()  
	{	
		liftMotorRight.set(CrusaderCommon.LIFT_GOES_UP);
		liftMotorLeft.set(CrusaderCommon.LIFT_GOES_UP);
	}

	public void manualControlOfLifter(double overRideValue)  
	{
		liftMotorRight.set(overRideValue);
		liftMotorLeft.set(overRideValue);
	}

	/*
	 * The jaguars will start going backwards and the lift will go down.
	 * I set the Jag speed to -.5 for now.  It can be adjusted when robot robot is built
	 */
	public void liftGoesDown()  
	{	
		liftMotorRight.set(CrusaderCommon.LIFT_GOES_DOWN);
		liftMotorLeft.set(CrusaderCommon.LIFT_GOES_DOWN);
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

	/*
	 * This method will bring the lift to level 2 from any height
	 * The lift will stop when loadedSwitch is hit
	 */
	public void liftGameObjects()  
	{
		double liftPotValue = potens.get() ;
		if((loadedSwitch.get() == true) || (liftPotValue <= CrusaderCommon.POT_LOADING_MIN)) 
		{
			stop(); 
			level = CrusaderCommon.LOADING_LEVEL;
			
			
		}
		else
		{
			liftGoesUp();
		}

		SmartDashboard.putBoolean("Load Switch Hit: ", loadedSwitch.get());
		SmartDashboard.putNumber("Level: ", level);
		SmartDashboard.putNumber("LiftPotValue2", liftPotValue);
	}
	/*
	 * This method will bring the lift to level 1 from any height
	 * Lift will stop when the travelSwitch is hit
	 * start making a Static final variables
	 */
	public void travelingMode() 
	{	

		double travelPotValue = potens.get();
		
		if((travelSwitch.get() == true) || ((travelPotValue >= CrusaderCommon.POT_TRAVEL_MAX) && (travelPotValue <= CrusaderCommon.POT_TRAVEL_MIN)))  //The lift will stop when travelSwitch is hit
		{
			stop();
			level = CrusaderCommon.TRAVEL_LEVEL;
		}
		else
		{
			if(level == CrusaderCommon.LOADING_LEVEL) 
			{
				liftGoesDown();				
			}
			if (level == CrusaderCommon.GROUND_LEVEL)
			{
				liftGoesUp();			
			}

		}
		SmartDashboard.putNumber("TravelPotValue", travelPotValue);
		SmartDashboard.putBoolean("Travel Switch Hit: ", travelSwitch.get());
		SmartDashboard.putNumber("Level: ", level);


	}
	/*
	 * This method will bring the lift to level 0 from any height.
	 * Lift will stop when raisedSwitch is hit
	 */
	public void setToGround()  
	{	

		if(raisedSwitch.get() == true)  //The lift will stop when raisedSwitch is hit
		{
			stop();
			level = CrusaderCommon.GROUND_LEVEL;
		}
		else 
		{
			liftGoesDown();
		}

		SmartDashboard.putBoolean("Raised Switch Hit: ", raisedSwitch.get());
		SmartDashboard.putNumber("Level: ", level);
	}


	public void setToCoop()
	{
		if(coopSwitch.get() == true)
		{
			stop();
			level = CrusaderCommon.COOP_LEVEL;
		}
		else
		{
			if((level == CrusaderCommon.LOADING_LEVEL) || (potens.get() > CrusaderCommon.POT_COOP))
			{
				liftGoesDown();
			}
			else
			{
				liftGoesUp();
			}
		}
		SmartDashboard.putBoolean("Co-Op Switch Hit: ", coopSwitch.get());
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





package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


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

	int level;  

	//motors to control the lift
	Jaguar liftMotorLeft;  
	Jaguar liftMotorRight;

	//the value of the levels of the lift
	final int GROUND_LEVEL = 0;
	final int TRAVEL_LEVEL = 1;
	final int LOADING_LEVEL = 2;



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

			level = GROUND_LEVEL; // Maybe?  under revise
			SmartDashboard.putNumber("Level: ", level);

			//These will bring the game piece up or down
			liftMotorRight= new Jaguar(6);  
			SmartDashboard.putNumber("Right Lift Motor: ", liftMotorRight.get());
			liftMotorLeft = new Jaguar(7); 
			SmartDashboard.putNumber("Left Lift Motor: ", liftMotorLeft.get());

		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());  
		}
	}

	/*
	 * The jaguars will start going forward and the lift will go up.
	 * I set the Jag speed to .5 for now.  It can be adjusted when robot robot is built
	 */
	public void liftGoesUp()  
	{	
		liftMotorRight.set(0.5);
		liftMotorLeft.set(0.5);
	}


	/*
	 * The jaguars will start going backwards and the lift will go down.
	 * I set the Jag speed to -.5 for now.  It can be adjusted when robot robot is built
	 */
	public void liftGoesDown()  
	{
		liftMotorRight.set(-0.5);
		liftMotorLeft.set(-0.5);
	}

	/*
	 * The jaguars will stop.  
	 * The output will be 0, for the jaguar will be set to zero. 
	 */
	public void stop()
	{
		liftMotorRight.set(0);
		liftMotorLeft.set(0);
	}

	/*
	 * This method will bring the lift to level 2 from any height
	 * The lift will stop when loadedSwitch is hit
	 */
	public void liftGameObjects()  
	{

		if(loadedSwitch.get() == true) 
		{
			stop();
			level = LOADING_LEVEL;
		}

		else
		{
			if((level == TRAVEL_LEVEL)||(level == GROUND_LEVEL))		 				
			{
				liftGoesUp();
			}
		}

	}
	/*
	 * This method will bring the lift to level 1 from any height
	 * Lift will stop when the travelSwitch is hit
	 * start making a Static final variables
	 */
	public void travelingMode() 
	{	


		if(travelSwitch.get() == true)  //The lift will stop when travelSwitch is hit
		{
			stop();
			level = TRAVEL_LEVEL;
		}
		else
		{
			if(level == LOADING_LEVEL)
			{
				liftGoesDown();				
			}
			if (level == GROUND_LEVEL)
			{
				liftGoesUp();			
			}

		}
		
		
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
			level = GROUND_LEVEL;
		}
		else 
		{
			liftGoesDown();
		}

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
	 *  This signals the right pistons to turn on.
	 *	This read in a button value to see if it is true or not.
	 *  If the button is pressed, than the solenoids on the right side will turn on.
	 */	
	public void letItGo()    //This signals the right pistons to turn off.
	{		

		rightFrontPiston.set(false);
		rightBackPiston.set(false);
		leftFrontPiston.set(false);
		leftBackPiston.set(false);
	}


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

}





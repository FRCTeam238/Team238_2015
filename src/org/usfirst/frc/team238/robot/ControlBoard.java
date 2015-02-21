package org.usfirst.frc.team238.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ControlBoard { 
	//Here are the joysticks for controlling  the robot
	static Joystick manualOverrideJs; 	// operator manual overide
	static Joystick operatorJs;  	// operator control board
	static Joystick driverLeftJs; 	// driveTrain left
	static Joystick driverRightJs; 	// driveTrain right
	static int commands[];
	
	public void controlBoardInit()
	{
		try
		{
			manualOverrideJs = new Joystick(0);
			operatorJs = new Joystick(1);
			driverLeftJs = new Joystick(2);
			driverRightJs = new Joystick(3);
			
			//array that holds the command sent by each control device
			commands = new int[4];
			
			SmartDashboard.putString("operatorJs", "operatorJs Is Intialized");
			
		}
		
		catch(Exception ex)
		{
			System.out.println("ControlBoard Init Failed");
		}
	}
	
	
	
	/**
	 * loops thru all the buttons on the joystick until it gets to the one that is pressed
	 * works as long as we only need one button pressed at a time, if we need  more than one
	 * button we'll need to create an array of commands.... int command[]
	 * @return command value
	 */
	public int getCommand(Joystick theJoyStick){
		int command;
		boolean jsButtonValue = false;
		
		int interator = theJoyStick.getButtonCount(); 
		
		for(command = 1; command < interator; command++){
			jsButtonValue = theJoyStick.getRawButton(command);
			if(jsButtonValue){
				break;
			}
		}
		if(!jsButtonValue){
			command = 0;
		}
		
		SmartDashboard.putNumber("Opperator Command", command);
		return command;
	}
	
	/**
	 * 
	 * @param theJoyStick
	 * @return
	 */
	public int getDriverCommand(Joystick theJoyStick){
		int command = 0;
		double zPos =  0.0;
		
		boolean jsButtonValue = theJoyStick.getRawButton(1);
		
		//if the triggers is pressed get the z axis  for direction to spin the wheel
		if(jsButtonValue)
		{
			zPos = theJoyStick.getZ(); 

			if( zPos > .10)
			{
				command = 1;
			}
			else if(zPos < -.10)
			{
				command = 2;
			}			
		}
		else if(theJoyStick.getRawButton(3)){
			command = 3;
		}
		
		SmartDashboard.putNumber("Driver Command", command);
		SmartDashboard.putNumber("ZPOS", zPos);
		
		return command;
	}
	
	//populates each array element with the corresponding value for the joys stick
	public int[] getCommands(){
		
		commands[0] = getCommand(manualOverrideJs);
		commands[1] = getCommand(operatorJs);
		commands[2] = getDriverCommand(driverLeftJs);
		commands[3] = getDriverCommand(driverRightJs);
		
		return commands;
	}
	
	//gets the y value of the manual overide joy stick to feed to the command controller
	public static double getManualCommandValue()
	{
		return manualOverrideJs.getY();
	}

	public static boolean overRide(){
		boolean overRide = operatorJs.getRawButton(10);
		
		return overRide;
					
	}
	
	
}

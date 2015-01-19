
package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	Lift theLift;
	ControlBoard theControlBoard;
	Claws theClaws;
	DriveTrain theDriveTrain;
	SaloonDoors theSaloonDoors;
	
    public void robotInit() {
    	
    	try
    	{
    		theControlBoard = new ControlBoard();
			SmartDashboard.putString("theControlBoard", "initialized");
    		theLift = new Lift();
    		SmartDashboard.putString("theLift", "initialized");
    		theClaws = new Claws();
    		SmartDashboard.putString("theClaws", "initialized");
    		theDriveTrain = new DriveTrain();
    		SmartDashboard.putString("theDriveTrain", "initialized");
    		theSaloonDoors = new SaloonDoors();
    		SmartDashboard.putString("theSaloonDoors", "initialized");
    		System.out.println("Fully Initialized");
    	}
    	
    	catch(Exception ex)
    	{
    		System.out.println(ex.getMessage());
    	}
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}

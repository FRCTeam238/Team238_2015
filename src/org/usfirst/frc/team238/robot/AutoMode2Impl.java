package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoMode2Impl implements Command {
	
	/* this is a multi-step autonomous mode
	 *   1. spin the claw to capture the bin and begin driving forward
	 *      until backplace button is pressed
	 *   2. move to the travel mode
	 *      until lift to travel mode is complete
	 *   3. drive forward 
	 *      until a timeout elapses
	 */

	private static final int UNTIL_BIN_LOADED = 0;
	private static final int UNTIL_IN_TRAVEL_MODE = 1;
	private static final int WHILE_TURN_TO_RIGHT = 2;
	private static final int WHILE_DRIVE_TO_FINAL = 3;
	
	private int[] commandValue = new int[6];
	private int commandScriptIndex = 0;
	private AutonomousDrive autonomousDrive;
	private Lift lift;
	
	// force next pass through the buildCommands to perform the initialization
	private boolean isInReset = true; 

	private int[][] commandScript =
		{
			{ 
				CrusaderCommon.MAN_CMD_IDX_DONOTHING, 
				CrusaderCommon.OPR_CMD_IDX_SETTOGROUND, 
				CrusaderCommon.LEFTDRIVER_CMD_IDX_SPINRIGHT, 
				CrusaderCommon.RIGHTDRIVER_CMD_IDX_SPINLEFT,
				CrusaderCommon.AUTONOMOUS_CMD_IDX_DRIVEFORWARD,
				UNTIL_BIN_LOADED
			},
			{ 
				CrusaderCommon.MAN_CMD_IDX_DONOTHING,
				CrusaderCommon.OPR_CMD_IDX_SETTOTRAVEL,
				CrusaderCommon.LEFTDRIVER_CMD_IDX_DONOTHING,
				CrusaderCommon.RIGHTDRIVER_CMD_IDX_DONOTHING,
				CrusaderCommon.AUTONOMOUS_CMD_IDX_DONOTHING,
				UNTIL_IN_TRAVEL_MODE
			},
			{
				// driving functionality occurs in the DriveToFinal
				CrusaderCommon.MAN_CMD_IDX_DONOTHING,
				CrusaderCommon.OPR_CMD_IDX_DONOTHING,
				CrusaderCommon.LEFTDRIVER_CMD_IDX_DONOTHING,
				CrusaderCommon.RIGHTDRIVER_CMD_IDX_DONOTHING,
				CrusaderCommon.AUTONOMOUS_CMD_IDX_DRIVEFORWARD,
				WHILE_DRIVE_TO_FINAL
			}
		};
			
	public AutoMode2Impl()
	{
		// do nothing
	}
	
	public void init(AutonomousDrive theDrive, Lift theLift)
	{
		autonomousDrive = theDrive;
		lift = theLift;
		commandScriptIndex = 0;
		commandValue = new int[6];
		isInReset = true;
	}
	
	public void reset()
	{
		commandScriptIndex = 0;
		
		// force evaluatePredicateInitializer into the first command's init
		isInReset = true; 
	}
	
	private boolean evaluatePredicate(int predicateID)
	{
		boolean retval = false;
		
		switch (predicateID)
		{
			case UNTIL_BIN_LOADED:
				retval = lift.isBinLoaded();
				break;
			case UNTIL_IN_TRAVEL_MODE:
				retval = lift.getLevel() == CrusaderCommon.TRAVEL_LEVEL;
				break;
			case WHILE_TURN_TO_RIGHT:
				retval = autonomousDrive.isActionComplete();
				break;
			case WHILE_DRIVE_TO_FINAL:
				retval = autonomousDrive.isActionComplete();
				break;
			default:
				break;
		}
		
		return retval;
	}
	
	private void evaluatePredicateInitializer(int predicateID)
	{
		switch (predicateID)
		{
			case UNTIL_BIN_LOADED:
				autonomousDrive.killTimer();
				autonomousDrive.startTimer();
				autonomousDrive.resetAction();
				break;
			case UNTIL_IN_TRAVEL_MODE:
				// do nothing
				break;
			case WHILE_TURN_TO_RIGHT:
				autonomousDrive.killTimer();
				autonomousDrive.startTimer();
				autonomousDrive.resetAction();
				break;
			case WHILE_DRIVE_TO_FINAL:
				autonomousDrive.killTimer();
				autonomousDrive.startTimer();
				autonomousDrive.resetAction();
				break;
			default:
				break;
		}
	}

	public int[] buildCommands()
	{
		//System.out.println("CSI=" + commandScriptIndex);
		if ((commandScriptIndex >= 0) && (commandScriptIndex < commandScript.length))
		{
			if (isInReset)
			{
				isInReset = false;
				
				int predicateID = commandScript[commandScriptIndex][CrusaderCommon.INPUT_AUTO_PREDICATE];
				evaluatePredicateInitializer(predicateID);
			}
			
			SmartDashboard.putNumber("AM1 CSI", commandScriptIndex);
			int predicateID = commandScript[commandScriptIndex][CrusaderCommon.INPUT_AUTO_PREDICATE];
			
			if (evaluatePredicate(predicateID))
			{
				// the eval returned true, so step to the next script instruction
				commandScriptIndex++;
				
				// once we step to the next script instruction perform any initialization necessary

				// retest the command index to see if the evaluatePredicate stepped off the end of the 
				// of the script
				if ((commandScriptIndex >= 0) && (commandScriptIndex < commandScript.length))
				{
					evaluatePredicateInitializer(predicateID);
				}
			}
		}
		
		// retest the command index to see if the evaluatePredicate stepped off the end of the 
		// of the script
		if ((commandScriptIndex >= 0) && (commandScriptIndex < commandScript.length))
		{
			// all six elements of the command script instruction are returned to the 
			// caller
			//CAT TODO consider copying the command script, not returning the actual one
			commandValue = commandScript[commandScriptIndex];
		}
		
		return commandValue;
	}
	
	@Override
	public void execute() {
		
	}

	@Override
	public void execute(double overRideValue) {
		// TODO Auto-generated method stub

	}

}

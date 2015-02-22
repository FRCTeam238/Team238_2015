package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

// @SuppressWarnings("deprecation")
public class Robot extends IterativeRobot {

	private static boolean robotTestMode = false;
	private static int count = 0;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	Lift theLift;
	Claws rightClaw;
	Claws leftClaw;
	SaloonDoors theSaloonDoors;
	Shifter theShifter;
	CommandGoToGround operatorCmdSetToGround;
	CommandGoToTravel operatorCmdSetToTravel;
	CommandGoToLift operatorCmdSetToLift;
	CommandGoToDeliver operatorCmdSetToDeliver;
	CommandCoopPoints operatorCmdCoopPoints;
	CommandSaloonDoorsOpen operatorCmdSetToSaloonDoorsOpen;
	CommandClawSpinRight driverJs3CmdSpinRight;
	CommandClawSpinRight driverJs2CmdSpinRight;
	Preferences myPreferences;
	ControlBoard myControlBoard;
	CommandClawSpinLeft driverJs3CmdSpinLeft;
	CommandClawSpinLeft driverJs2CmdSpinLeft;
	NoOperatorCommand theDoNothingCmd;
	NoDriverCommand theDoNothingRightDriverCmd;
	NoDriverCommand theDoNothingLeftDriverCmd;
	CommandController theMCP;
	RobotDrive myRobotDrive;
	CommandShiftLow shiftLowCMD;
	CommandShiftHigh shiftHighCMD;

	// Autonomous Mode Support
	Autonomous myAutonomous;
	String autoMode;
	Timer autonomousTimer;
	AutonomousDrive autonomousDrive;

	CommandDriveIdle autoDriveIdle;
	CommandDriveForward autoDriveForward;
	CommandDriveBackwards autoDriveBackward;
	CommandDriveTurnRight autoDriveTurnRight;
	CommandDriveTurnLeft autoDriveTurnLeft;
	
	// CAT DigitalInput autoLoadedSwitch;

	// This is only valid in test mode. When this object is
	// valid, then the other objects (thisLife, theClaws, etc.) will not be
	// valid
	TestMain testController = null;

	public void disabledInit() {
		try {
			if (autonomousTimer != null) {
				autonomousTimer.stop();
			}

			// only use checkForSmartDashboardChanges function in init methods
			// or you will
			// smoke the roborio into a useless pile of silicon
			checkForSmartDashboardChanges("mode",
					CrusaderCommon.PREFVALUE_OP_MODE_NORMAL);

			updateTestMode();
		} catch (Exception ex) {
			System.out.println("disabledInit exception");
		}

	}

	public void disabledPeriodic() {

		try {
			if (count > 500) {

				count = 0;

				String modeFromDS = SmartDashboard.getString("mode");
				if (modeFromDS != null) {
					System.out.println("DSModeFromPeriodicDisabled = "
							+ modeFromDS);
				}
			}
			count++;
		} catch (Exception ex) {
			System.out.println("disabledPriodic exception");
		}

	}

	public void teleopInit() {
		try {
			System.out.println("TeleopInit()");
			// only use checkForSmartDashboardChanges function in init methods
			// or you will
			// smoke the roborio into a useless pile of silicon
			checkForSmartDashboardChanges("mode",
					CrusaderCommon.PREFVALUE_OP_MODE_NORMAL);
			updateTestMode();
		} catch (Exception ex) {
			System.out.println("TeleopInit:Exception");
		}

	}

	public void autonomousInit() {
		try {

			System.out.println("AutononousInit()");

			// only use checkForSmartDashboardChanges function in init methods
			// or you will
			// smoke the roborio into a useless pile of silicon
			try {
				checkForSmartDashboardChanges("auto", "1");
			} catch (Exception ex) {
				System.out.println("AutononousInit:CMDB Exception");
			}

			// Note: Command objects for autonomous are initialized in
			// RobotInit
			try {
				autonomousTimer = new Timer();

				autonomousTimer.reset();
				autonomousTimer.start();
				
				myAutonomous.reset();
			} catch (Exception ex) {
				System.out.println("AutononousInit:Timer");
			}
		} catch (Exception ex) {
			System.out.println("AutononousInit:Exception");
		}
	}

	public void robotInit() {

		try {
			System.out.println("RobotInit()");
			SmartDashboard.putString(CrusaderCommon.PREFERENCE_OP_MODE, "");

			myControlBoard = new ControlBoard();
			myControlBoard.controlBoardInit();
			
			// CAT autoLoadedSwitch = new DigitalInput(1);

			theLift = new Lift();
			theLift.liftInit();

			leftClaw = new Claws();
			leftClaw.clawsInit(4);

			rightClaw = new Claws();
			rightClaw.clawsInit(5);

			theShifter = new Shifter();
			theShifter.init();

			theSaloonDoors = new SaloonDoors();
			theSaloonDoors.Init();

			theMCP = new CommandController();
			theMCP.init();

			theDoNothingCmd = new NoOperatorCommand(theLift, theSaloonDoors);
			theMCP.setCommand(CrusaderCommon.OPR_CMD_LIST,
					CrusaderCommon.OPR_CMD_IDX_DONOTHING, theDoNothingCmd);

			theDoNothingRightDriverCmd = new NoDriverCommand(rightClaw);
			theDoNothingLeftDriverCmd = new NoDriverCommand(leftClaw);
			theMCP.setCommand(CrusaderCommon.LEFTDRIVER_CMD_LIST,
					CrusaderCommon.LEFTDRIVER_CMD_IDX_DONOTHING,
					theDoNothingLeftDriverCmd);
			theMCP.setCommand(CrusaderCommon.RIGHTDRIVER_CMD_LIST,
					CrusaderCommon.RIGHTDRIVER_CMD_IDX_DONOTHING,
					theDoNothingRightDriverCmd);

			operatorCmdSetToGround = new CommandGoToGround(theLift,
					theSaloonDoors);
			theMCP.setCommand(CrusaderCommon.OPR_CMD_LIST,
					CrusaderCommon.OPR_CMD_IDX_SETTOGROUND,
					operatorCmdSetToGround);

			operatorCmdSetToTravel = new CommandGoToTravel(theLift,
					theSaloonDoors);
			theMCP.setCommand(CrusaderCommon.OPR_CMD_LIST,
					CrusaderCommon.OPR_CMD_IDX_SETTOTRAVEL,
					operatorCmdSetToTravel);

			operatorCmdSetToLift = new CommandGoToLift(theLift, theSaloonDoors);
			theMCP.setCommand(CrusaderCommon.OPR_CMD_LIST,
					CrusaderCommon.OPR_CMD_IDX_SETTOLIFT, operatorCmdSetToLift);

			operatorCmdSetToDeliver = new CommandGoToDeliver(theLift,
					theSaloonDoors);
			theMCP.setCommand(CrusaderCommon.OPR_CMD_LIST,
					CrusaderCommon.OPR_CMD_IDX_SETTODELIVER,
					operatorCmdSetToDeliver);

			operatorCmdCoopPoints = new CommandCoopPoints(theLift,
					theSaloonDoors);
			theMCP.setCommand(CrusaderCommon.OPR_CMD_LIST,
					CrusaderCommon.OPR_CMD_IDX_COOPPOINTS,
					operatorCmdCoopPoints);

			// left driver JS commands
			driverJs2CmdSpinRight = new CommandClawSpinRight(leftClaw);
			theMCP.setCommand(CrusaderCommon.LEFTDRIVER_CMD_LIST,
					CrusaderCommon.LEFTDRIVER_CMD_IDX_SPINRIGHT,
					driverJs2CmdSpinRight);

			driverJs2CmdSpinLeft = new CommandClawSpinLeft(leftClaw);
			theMCP.setCommand(CrusaderCommon.LEFTDRIVER_CMD_LIST,
					CrusaderCommon.LEFTDRIVER_CMD_IDX_SPINLEFT,
					driverJs2CmdSpinLeft);

			theMCP.setCommand(CrusaderCommon.LEFTDRIVER_CMD_LIST,
					CrusaderCommon.LEFTDRIVER_CMD_IDX_UNUSED3,
					theDoNothingLeftDriverCmd);

			shiftLowCMD = new CommandShiftLow(theShifter);
			theMCP.setCommand(CrusaderCommon.LEFTDRIVER_CMD_LIST,
					CrusaderCommon.LEFTDRIVER_CMD_IDX_SHIFTLOW, shiftLowCMD);

			// right driver JS commands
			driverJs3CmdSpinRight = new CommandClawSpinRight(rightClaw);
			theMCP.setCommand(CrusaderCommon.RIGHTDRIVER_CMD_LIST,
					CrusaderCommon.RIGHTDRIVER_CMD_IDX_SPINRIGHT,
					driverJs3CmdSpinRight);

			driverJs3CmdSpinLeft = new CommandClawSpinLeft(rightClaw);
			theMCP.setCommand(CrusaderCommon.RIGHTDRIVER_CMD_LIST,
					CrusaderCommon.RIGHTDRIVER_CMD_IDX_SPINLEFT,
					driverJs3CmdSpinLeft);

			shiftHighCMD = new CommandShiftHigh(theShifter);
			theMCP.setCommand(CrusaderCommon.RIGHTDRIVER_CMD_LIST,
					CrusaderCommon.RIGHTDRIVER_CMD_IDX_SHIFTHIGH, shiftHighCMD);

			myRobotDrive = new RobotDrive(0, 1, 2, 3);
			autonomousDrive = new AutonomousDrive(myRobotDrive);
			myAutonomous = new Autonomous();
			myAutonomous.autoInit(autonomousDrive, theLift);

			// operatorCmdSetToSaloonDoorsOpen = new
			// CommandSaloonDoorsOpen(theSaloonDoors);
			// theMCP.setCommand(CrusaderCommon.DRIVER_CMD_LIST, 1,
			// operatorCmdSetToSaloonDoorsOpen);

			autoDriveIdle = new CommandDriveIdle(autonomousDrive);
			theMCP.setCommand(CrusaderCommon.AUTONOMOUS_CMD_LIST, CrusaderCommon.AUTONOMOUS_CMD_IDX_DONOTHING, autoDriveIdle);

			autoDriveForward = new CommandDriveForward(autonomousDrive);
			theMCP.setCommand(CrusaderCommon.AUTONOMOUS_CMD_LIST, CrusaderCommon.AUTONOMOUS_CMD_IDX_DRIVEFORWARD, autoDriveForward);

			autoDriveBackward = new CommandDriveBackwards(autonomousDrive);
			theMCP.setCommand(CrusaderCommon.AUTONOMOUS_CMD_LIST, CrusaderCommon.AUTONOMOUS_CMD_IDX_DRIVEBACKWARD, autoDriveBackward);

			autoDriveTurnLeft = new CommandDriveTurnLeft(autonomousDrive);
			theMCP.setCommand(CrusaderCommon.AUTONOMOUS_CMD_LIST, CrusaderCommon.AUTONOMOUS_CMD_IDX_TURNLEFT, autoDriveTurnLeft);
			
			autoDriveTurnRight = new CommandDriveTurnRight(autonomousDrive);
			theMCP.setCommand(CrusaderCommon.AUTONOMOUS_CMD_LIST, CrusaderCommon.AUTONOMOUS_CMD_IDX_TURNRIGHT, autoDriveTurnRight);
			
			// NOTE: the timer is initialized in autonomousInit

			System.out.println("Fully Initialized");

		} catch (Exception ex) {
			// SmartDashboard.putString(TestMain.TEST_DASH_KEY_EXCEPTION,
			// "EXCEPTION");
			System.out.println(ex.getMessage());
			ex.printStackTrace();

		}
	}

	private void updateTestMode() {
		String mode = Preferences.getInstance().getString(
				CrusaderCommon.PREFERENCE_OP_MODE,
				CrusaderCommon.PREFVALUE_OP_MODE_NORMAL);
		if (mode != null) {
			System.out.println("TMI_PrefMode = " + mode);
			SmartDashboard.putString(CrusaderCommon.PREFERENCE_OP_MODE, mode);

			switch (mode) {
			case CrusaderCommon.PREFVALUE_OP_MODE_TEST:
				robotTestMode = true;
				break;
			case CrusaderCommon.PREFVALUE_OP_MODE_NORMAL:
			default:
				robotTestMode = false;
				break;
			}
		}

		return;
	}

	/*
	 * This function will check to determine if the current mode wants the robot
	 * to drive forward
	 * 
	 * This may need enhancement in the event that future modes will require
	 * turning and
	 */
	/*
	private boolean IsDrivingForward(int autoModeID) {
		// drive forward 3 seconds in autoMode
		final double AUTONOMOUS_DRIVE_TO_SCORING_PLATFORM = 3.0;

		boolean retval = false; // assume don't drive

		if ((autoModeID == Autonomous.Mode_GrabAndDrive)
				&& (autonomousTimer.get() < AUTONOMOUS_DRIVE_TO_SCORING_PLATFORM)) {
			retval = true;
		}

		return retval;
	}
	*/

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		int commandValue[];

		try {
			count++;
			if (count > 500) {
				count = 0;

				String key = "auto";

				autoMode = myPreferences.getString(key, "1");
				System.out.println("Auto-PREFs: " + autoMode);

				// String valueFromDS = SmartDashboard.getString(key);
				// System.out.println("AUTO-SB: " + valueFromDS);

			}

			if (autoMode != null) {
				try {
					int autoModeID = Integer.parseInt(autoMode);

					// read the backplate switch to make sure we have something
					// in the loading bay
					// CAT if(autoLoadedSwitch.get() == true){
					commandValue = myAutonomous.buildAutoCommands(autoModeID);
					theMCP.autoButtonPressed(commandValue);
					// CAT }

					/*
					 * //CAT if (IsDrivingForward(autoModeID)) {
					 * autoDriveForward.execute(); } else {
					 * autoDriveIdle.execute(); }
					 */
				} catch (NumberFormatException ex) {
					System.out.println("automode cannot be parsed");
				}
			}
			else 
			{
				System.out.println("automode is null");
			}
		} catch (Exception ex) {
			System.out.println("Autonomous exception");
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {

		int commandValue[];

		double leftJsValue = 0;
		double rightJsValue = 0;

		try {
			if (autonomousTimer != null) {
				autonomousTimer.stop();
			}

			leftJsValue = ControlBoard.driverLeftJs.getY();
			rightJsValue = ControlBoard.driverRightJs.getY();

			myRobotDrive.tankDrive(-leftJsValue, -rightJsValue);

			commandValue = myControlBoard.getCommands();
			// System.out.println("telopperiodic: " + commandValue[0]);
			theMCP.buttonPressed(commandValue);

		} catch (Exception e) {
			System.out.println("telopperiodic: ");
			e.printStackTrace();
		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

	/**
	 * This should ONLY be called from an init function
	 */
	private void checkForSmartDashboardChanges(String key, String value) {
		myPreferences = Preferences.getInstance();

		String valueFromPrefs = myPreferences.getString(key, value);
		if (valueFromPrefs != null) {
			System.out.println("PREFs:" + key + " = " + valueFromPrefs);
			String valueFromDS = null;
			try {
				valueFromDS = SmartDashboard.getString(key);
			} catch (Exception ex) {
				ex.printStackTrace();
				SmartDashboard.putString(key, valueFromPrefs);
			}

			System.out.println("PREFs_DS:" + key + " = " + valueFromDS);

			// check for null and also if it's empty don't overwrite what's in
			// the preferences table
			if ((valueFromDS != null) && (!valueFromDS.isEmpty())) {
				System.out.println("SB:" + key + " = " + valueFromDS);

				// if they are not the same then update the preferences
				if (!valueFromPrefs.equalsIgnoreCase(valueFromDS)) {

					myPreferences.putString(key, valueFromDS);

					// NEVER NEVER use this save() in a periodic function or you
					// will destroy your RoboRio
					// making it an expensive chunk of useless plastic and
					// silicon
					myPreferences.save();
				}
			}
		}
	}
}

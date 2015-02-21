package org.usfirst.frc.team238.robot;

public class CrusaderCommon {

	public final static double CLAWMOTORSPEED = 1.0;
	public final static double MOTOROFF = 0;
	public final static double CLAWMOTORSPEEDREVERSE = -1.0;
	public final static double DOORMOTORSPEED = 0.5;
	public final static double DOORMOTORSPEEDREVERSE = -0.5;
	public final static double SALOONDOORSTOPVALUE = .96;
	
	public static final String PREFERENCE_OP_MODE = "mode";
	public static final String PREFVALUE_OP_MODE_NORMAL = "normal";
	public static final String PREFVALUE_OP_MODE_TEST = "test";
	public static final String PREFVALUE_OP_AUTO = "auto";
	public static final String PREFVALUE_OP_AUTO_DEFAULT = "1";
	
	//two types of command lists
	public static final int OPR_CMD_LIST = 1;
	public static final int LEFTDRIVER_CMD_LIST = 2;
	public static final int RIGHTDRIVER_CMD_LIST = 3;
	public static final int AUTONOMOUS_CMD_LIST = 4;
	
	//public static final double POT_GROUND_MIN = 0.690;
	public static final double POT_GROUND = 0.440;
	//public static final double POT_GROUND_MAX = 0.610;
	
	//public static final double POT_TRAVEL_MIN = 0.380;
	public static final double POT_TRAVEL = 0.346;	
	//public static final double POT_TRAVEL_MAX = 0.280;
	
	//public static final double POT_COOP_MIN = 0.230;
	public static final double POT_COOP = 0.140;
	//public static final double POT_COOP_MAX = 0.130;
	
	//public static final double POT_LOADING_MIN = 0.100;
	public static final double POT_LOADING = 0.018;
	//public static final double POT_LOADING_MAX = 0.010;/
	public static final double POT_NEUTRAL_ZONE = .002;
	
	public static final double POT_DIFF_MAX = 0.010;
	public static final double POT_DEAD_BAND = 0.005;
	
	//Levels for the Lift 
	public static final int GROUND_LEVEL = 1;
	public static final int TRAVEL_LEVEL = 2;
	public static final int LOADING_LEVEL = 3;
	public static final int DELIVER_LEVEL = 4;
	public static final int COOP_LEVEL = 5;
	
	//Speed for the Lift Jaguars
	public static final int LIFT_GOES_UP_NORMAL = -1;
	public static final int LIFT_GOES_DOWN_NORMAL = 1;
	public static final int LIFT_STOPS = 0;
	public static final double LIFT_GOES_DOWN_SLOW = 0.5;
	public static final double LIFT_GOES_UP_SLOW = -0.5;
	
	//
	public static final int INPUT_MANUAL_OVERRIDE = 0;
	public static final int INPUT_OPR_CONTROL = 1;
	public static final int INPUT_DRIVER_LEFT_JS = 2;
	public static final int INPUT_DRIVER_RIGHT_JS = 3;
	
	public static final boolean SHIFTER_HIGH_GEAR = true;
	public static final boolean SHIFTER_LOW_GEAR = false;
	
	public static final int SHIFT_STATE_HIGH_GEAR = 1;
	public static final int SHIFT_STATE_LOW_GEAR = 0;
	
	/*
	 * The AUTO_DRIVE_* constants are the joystick positions when moving in the
	 * expected direction. These values are passed to the RobotDrive.tankDrive
	 * method.
	 */
	public static final double AUTO_DRIVE_FORWARD = 0.75;
	public static final double AUTO_DRIVE_BACKWARD = -0.75;
	public static final double AUTO_DRIVE_IDLE = 0.0;
}

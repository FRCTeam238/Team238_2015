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
	
	// Temperary potentiometer values for the lift code
	public static final double POT_GROUND_MIN = 0.690;
	public static final double POT_GROUND = 0.660;
	public static final double POT_GROUND_MAX = 0.610;
	
	public static final double POT_TRAVEL_MIN = 0.380;
	public static final double POT_TRAVEL = 0.330;	
	public static final double POT_TRAVEL_MAX = 0.280;
	
	public static final double POT_COOP_MIN = 0.230;
	public static final double POT_COOP = 0.180;
	public static final double POT_COOP_MAX = 0.130;
	
	public static final double POT_LOADING_MIN = 0.100;
	public static final double POT_LOADING = 0.050;
	public static final double POT_LOADING_MAX = 0.020;
	
	
	
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
	public static final double LIFT_GOES_DOWN_SLOW = 0.75;
	public static final double LIFT_GOES_UP_SLOW = -0.75;
	
	//
	public static final int INPUT_MANUAL_OVERRIDE = 0;
	public static final int INPUT_OPR_CONTROL = 1;
	public static final int INPUT_DRIVER_LEFT_JS = 2;
	public static final int INPUT_DRIVER_RIGHT_JS = 3;
	
}
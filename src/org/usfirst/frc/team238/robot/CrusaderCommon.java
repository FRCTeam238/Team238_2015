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
	public static final int DRIVER_CMD_LIST = 2;
	
	// Temperary potentiometer values for the lift code
	public static final double POT_GROUND = 0.0;
	public static final double POT_TRAVEL = 0.25;
	public static final double POT_RAISED = 0.5;
	public static final double POT_COOP = 1.0;
	
	//Levels for the Lift 
	public static final int GROUND_LEVEL = 0;
	public static final int TRAVEL_LEVEL = 1;
	public static final int LOADING_LEVEL = 2;
	public static final int COOP_LEVEL = 3;
	
	//Speed for the Lift Jaguars
	public static final int LIFT_GOES_UP = -1;
	public static final int LIFT_GOES_DOWN = 1;
	public static final int LIFT_STOPS = 0;
	
	//
	public static final int INPUT_MANUAL_OVERRIDE = 0;
	public static final int INPUT_OPR_CONTROL = 1;
	public static final int INPUT_DRIVER = 2;
	
}
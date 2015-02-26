package org.usfirst.frc.team238.robot;

public class AutoMode4Impl implements Command {

	/* The execute function will populate the commandValue array with 
	 * the current command set based on the state of the robot.
	 */
	private int[] commandValue;

	public void setCommandBuffer(int[] commandBuffer)
	{
		commandValue = commandBuffer;
	}
	
	@Override
	public void execute() {
		commandValue[CrusaderCommon.INPUT_MANUAL_OVERRIDE] = CrusaderCommon.MAN_CMD_IDX_DONOTHING;
		commandValue[CrusaderCommon.INPUT_OPR_CONTROL] = CrusaderCommon.OPR_CMD_IDX_DONOTHING;
		commandValue[CrusaderCommon.INPUT_DRIVER_LEFT_JS] = CrusaderCommon.LEFTDRIVER_CMD_IDX_DONOTHING; 
		commandValue[CrusaderCommon.INPUT_DRIVER_RIGHT_JS] = CrusaderCommon.RIGHTDRIVER_CMD_IDX_DONOTHING;
	}

	@Override
	public void execute(double overRideValue) {
		// TODO Auto-generated method stub

	}

}

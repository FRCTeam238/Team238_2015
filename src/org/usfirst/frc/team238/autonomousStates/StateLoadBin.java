package org.usfirst.frc.team238.autonomousStates;

import org.usfirst.frc.team238.commands.CommandGoToLift;
import org.usfirst.frc.team238.core.AutonomousState;
import org.usfirst.frc.team238.core.CommandController;

public class StateLoadBin implements AutonomousState {

	int count = 0;
	CommandGoToLift liftCmd;
	
	
	@Override
	public void init(int value, CommandController theMcp) {
		liftCmd = theMcp.getLiftCmd();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void process() {
		System.out.println("StateLoadBin ");
		count++;
		liftCmd.execute();
	}

	@Override
	public boolean done() {
		
		
		if(liftCmd.complete() || count > 30)
		{
			return true;
		}
		
		return false;
	}

	
}

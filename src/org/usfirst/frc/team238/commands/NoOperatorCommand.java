package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.Lift;

public  class NoOperatorCommand implements Command {
	
	Lift lift;
	
	public NoOperatorCommand(Lift theLift){
		
		this.lift = theLift;
		
	}
	public void execute() {
		lift.stop();
		
	}
	
	public void execute(double overRideValue) {
		lift.stop();
	}

}

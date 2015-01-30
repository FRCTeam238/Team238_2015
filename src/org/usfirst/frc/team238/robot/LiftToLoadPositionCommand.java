package org.usfirst.frc.team238.robot;

public class LiftToLoadPositionCommand implements Command {

	Lift lift;
	
	public LiftToLoadPositionCommand(Lift lift){
		this.lift = lift;
	}
	
	public void execute() {
		lift.liftGoesUp();

	}

}

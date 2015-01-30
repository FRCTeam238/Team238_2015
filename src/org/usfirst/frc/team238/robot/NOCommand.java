package org.usfirst.frc.team238.robot;

public class NOCommand implements Command {
	
	Lift lift;
	Claws claws;
	SaloonDoors saloonDoors;
	DriveTrain driveTrain;
	
	public NOCommand(Lift theLift, Claws theClaws, SaloonDoors theSaloonDoors, DriveTrain theDT ){
		this.claws = theClaws;
		this.driveTrain = theDT;
		this.lift = theLift;
		this.saloonDoors = theSaloonDoors;
		
		
	}
	public void execute() {
		lift.stop();
		claws.stop();
		saloonDoors.stop();
		driveTrain.stop();

	}

}

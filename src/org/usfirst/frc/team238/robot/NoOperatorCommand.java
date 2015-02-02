package org.usfirst.frc.team238.robot;

public  class NoOperatorCommand implements Command {
	
	Lift lift;
	Claws claws;
	SaloonDoors saloonDoors;
	DriveTrain driveTrain;
	
	public NoOperatorCommand(Lift theLift, Claws theClaws, SaloonDoors theSaloonDoors, DriveTrain theDT ){
		this.claws = theClaws;
		this.driveTrain = theDT;
		this.lift = theLift;
		this.saloonDoors = theSaloonDoors;
		
		
	}
	public void execute() {
		lift.stop();
		saloonDoors.stop();
		claws.stop();
		
	}
	
	public void execute(double overRideValue) {
		
	}

}

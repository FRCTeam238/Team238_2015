package org.usfirst.frc.team238.robot;

public  class NoOperatorCommand implements Command {
	
	Lift lift;
	Claws claws;
	//SaloonDoors saloonDoors;
	
	public NoOperatorCommand(Lift theLift, SaloonDoors theSaloonDoors ){
		
		this.lift = theLift;
		//this.saloonDoors = theSaloonDoors;
		
	}
	public void execute() {
		lift.stop();
		//saloonDoors.stop();
		
	}
	
	public void execute(double overRideValue) {
		lift.stop();
		//saloonDoors.stop();
	}

}

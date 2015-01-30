package org.usfirst.frc.team238.robot;

public class SaloonDoorsOpenCommand implements Command {
	SaloonDoors saloonDoor;
	
	public SaloonDoorsOpenCommand(SaloonDoors saloonDoor){
		this.saloonDoor = saloonDoor;
	}
	
	public void execute() {
		saloonDoor.OpenDoors();

	}

}

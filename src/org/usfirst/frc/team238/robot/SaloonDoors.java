package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SaloonDoors {

	Relay LeftDoorMotor;
	Relay RightDoorMotor;
	ControlBoard theControlBoard;
	
	/*OVerview
	 * This function initializes Relays: Left Door and Right Door.
	 * Input: none 
	 * Output: none  
	 */
	public void Init(ControlBoard controlboard) {
			
		try {
			theControlBoard = new ControlBoard();
			LeftDoorMotor = new Relay(1, Relay.Direction.kForward);
			SmartDashboard.putString("LeftDoorMotor", "Initialized");
			RightDoorMotor = new Relay(2, Relay.Direction.kReverse);
			SmartDashboard.putString("RightDoorMotor", "Initialized");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	/* Overview
	 * When the OpenSaloondoorsButton is pressed the motors will 
	 * turn forward, opening the Saloon Doors until sensor says stop. 
	 * Input: OpenSaloonDoorsButton
	 * Output: Motors Forward, "Saloon Doors Open"
	 */
	private void OpenDoors() {
		RightDoorMotor.set(Value.kForward);
		SmartDashboard.putString("RightDoorMotor", "kForward");
		LeftDoorMotor.set(Value.kForward);
		SmartDashboard.putString("LeftDoorMotor", "kForward");
	}	
	
	/* Overview
	 * When the CloseSaloondoorsButton is pressed the motors will 
	 * turn backward, closing the Saloon Doors. 
	 * Input: CloseSaloonDoorsButton
	 * Output: Motors Backward, "Saloon Doors Close"
	 */
	private void CloseDoors() {
		RightDoorMotor.set(Value.kReverse);
		SmartDashboard.putString("RightDoorMotor", "kReverse");
		LeftDoorMotor.set(Value.kReverse);
		SmartDashboard.putString("LeftDoorMotor", "kReverse");
	}

	/*Overview
	 * When the OpenDoorButton is pressed it will open the Saloon Doors.
	 * When the CloseDoorButton is pressed it will close the Saloon Doors.
	 * Input: none
	 * Output: none       
	 */
	public void poll() {
		boolean b1 = theControlBoard.isButtonFivePressed(); //open door
		boolean b2 = theControlBoard.isButtonSixPressed(); // close door
		SmartDashboard.putBoolean("b1", b1);
		SmartDashboard.putBoolean("b2", b2);
		if ((b1 == true) && (b2 == true)) {
			// do nothing
		} 
		else if (b1 == true)
		{
			OpenDoors();
		} 
		else if (b2 == true) {
			CloseDoors();
		} else { // do nothing
		}
	}
}	
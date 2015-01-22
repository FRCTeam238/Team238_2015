package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SaloonDoors {

	Talon leftDoorMotor;
	Talon rightDoorMotor;
	AnalogPotentiometer leftPot;
	AnalogPotentiometer rightPot;
	
	/*OVerview
	 * This function initializes Relays: Left Door and Right Door.
	 * Input: none 
	 * Output: none  
	 */
	public void Init() {
			
		try {
			
			leftDoorMotor = new Talon(8);
			SmartDashboard.putString("LeftDoorMotor", "Initialized");
			
			rightDoorMotor = new Talon(9);
			SmartDashboard.putString("RightDoorMotor", "Initialized");
			
			leftPot = new AnalogPotentiometer(90);
			SmartDashboard.putString("Leftpot","Initialized");
			
			rightPot = new AnalogPotentiometer(90);
			SmartDashboard.putString("Rightpot","Initialized");
			
			SmartDashboard.putString("theControlBoard","Initialized");
			
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
		}
	}
	
	/* Overview
	 * When the OpenSaloondoorsButton is pressed the motors will 
	 * turn forward, opening the Saloon Doors. 
	 * Input: OpenSaloonDoorsButton
	 * Output: Motors Forward, "Saloon Doors Open"
	 */
	private void OpenDoors() {
		String outPutValue = "";
		
		if ((leftPot.get() == 90) && (rightPot.get() == 90)) {

			rightDoorMotor.set(CrusaderCommon.DOORMOTORSPEED);
			leftDoorMotor.set(CrusaderCommon.DOORMOTORSPEED);
			outPutValue = ("CrusaderCommon.DOORMOTORSPEED");
			
		}
		else {
			leftDoorMotor.set(CrusaderCommon.MOTOROFF);
			rightDoorMotor.set(CrusaderCommon.MOTOROFF);
			outPutValue = "CrusaderCommon.MOTOROFF";
		} 
		
		SmartDashboard.putString("SaloonDoors.OpenDoors", outPutValue);
	}	

	/* Overview
	 * When the CloseSaloondoorsButton is pressed the motors will 
	 * turn backward, closing the Saloon Doors. 
	 * Input: CloseSaloonDoorsButton
	 * Output: Motors Backward, "Saloon Doors Close"
	 */
	private void CloseDoors() {
		String outPutValue = "";

		if ((leftPot.get() == 90) && (rightPot.get() == 90)) {

			rightDoorMotor.set(CrusaderCommon.DOORMOTORSPEEDREVERSE);
			leftDoorMotor.set(CrusaderCommon.DOORMOTORSPEEDREVERSE);
			outPutValue = "CrusaderCommon.DOORMOTORSPEEDREVERSE";
		}
		else { 
			leftDoorMotor.set(CrusaderCommon.MOTOROFF);
			rightDoorMotor.set(CrusaderCommon.MOTOROFF);
			outPutValue = "CrusaderCommon.MOTOROFF";
		}

		SmartDashboard.putString ("SaloonDoors.CloseDoors",outPutValue);
	}

	/*Overview
	 * When the OpenDoorButton is pressed it will open the Saloon Doors.
	 * When the CloseDoorButton is pressed it will close the Saloon Doors.
	 * Input: none
	 * Output: none       
	 */
	public void poll() {
		boolean b1 = ControlBoard.isButtonFivePressed(); //open door
		SmartDashboard.putString("ButtonFive", "Pressed");
		boolean b2 = ControlBoard.isButtonSixPressed(); // close door
		SmartDashboard.putString("ButtonSix", "Pressed");
		if ((b1 == true) && (b2 == true)) {
			// do nothing
		} 
		else if (b1 == true) {
			OpenDoors();
		} 
		else if (b2 == true) {
			CloseDoors();
		}
		else if ((b1 == false) && (b2 == false))
		{
			leftDoorMotor.set(CrusaderCommon.MOTOROFF);
			rightDoorMotor.set(CrusaderCommon.MOTOROFF);
			SmartDashboard.putString("Button 5 or 6", "motors are off");
		
		} else { 
			SmartDashboard.putString("Button 5 or 6", "not pressed");
		}
	}
}	
package org.usfirst.frc.team238.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TestMain {
	
	private static final int TEST_PWM_CHANNEL_JAG = 4;
	private static final int TEST_PWM_CHANNEL_TALON = 8;
	private static final int TEST_DIO_CHANNEL_INPUT = 0;
	private static final int TEST_AIO_CHANNEL_INPUT = 0;
	private static final String TEST_DASH_KEY_AXIS_POS = "Test:Axis Y";
	private static final String TEST_DASH_KEY_DIOINPUT = "Test:DIO IN";
	public static final String TEST_DASH_KEY_EXCEPTION = "Test:Exception";
	private static final String TEST_DASH_KEY_AIOINPUT = "Test:AIO IN";
	
	private Jaguar testJag;
	private Talon testTalon;
	private DigitalInput testDIOInput;
	private AnalogPotentiometer testPotentiometer;

	public TestMain()
	{
		// do nothing
	}
	
	public void Init()
	{
		testJag = new Jaguar(TEST_PWM_CHANNEL_JAG);
		testTalon = new Talon(TEST_PWM_CHANNEL_TALON);
		testDIOInput = new DigitalInput(TEST_DIO_CHANNEL_INPUT);
		testPotentiometer = new AnalogPotentiometer(TEST_AIO_CHANNEL_INPUT);
		
		SmartDashboard.putString("PWM JAG", String.format("%d", TEST_PWM_CHANNEL_JAG));
		SmartDashboard.putString("PWM Talon", String.format("%d", TEST_PWM_CHANNEL_TALON));
		SmartDashboard.putString("DIO INPUT", String.format("%d", TEST_DIO_CHANNEL_INPUT));
		SmartDashboard.putString("AIO Input", String.format("%d", TEST_AIO_CHANNEL_INPUT));
	}
	
	public void Poll()
	{
		try {
			double axisValue = ControlBoard.joy1.getY();
			
			SmartDashboard.putNumber(TEST_DASH_KEY_AXIS_POS, axisValue);
			
			testJag.set(axisValue);
			testTalon.set(axisValue);
			
			boolean dioInputValue = testDIOInput.get();
			SmartDashboard.putBoolean(TEST_DASH_KEY_DIOINPUT, dioInputValue);
			
			double aioInputValue = testPotentiometer.get();
			SmartDashboard.putNumber(TEST_DASH_KEY_AIOINPUT, aioInputValue);
			
			SmartDashboard.putString(TEST_DASH_KEY_EXCEPTION, "none");
		}
		catch (Exception ex)
		{
			SmartDashboard.putString(TEST_DASH_KEY_EXCEPTION, "EXCEPTION");
			System.out.println(ex.getStackTrace());
		}
	}
}

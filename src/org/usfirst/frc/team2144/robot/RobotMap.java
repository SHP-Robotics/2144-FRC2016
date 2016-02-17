package org.usfirst.frc.team2144.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * @author :)
 */
public class RobotMap {
	// This is keybindings, basically

	// PWM
	public static final int leftPort = 0; // left drivetrain
	public static final int rightPort = 1; // right drivetrain

	public static final int intakeServoPort = 2; // intake servo
	public static final int intakeTalonPort = 3; // intake talons

	public static final int intakePitchPort = 4; // intake act talon

	public static final int mastPitchPort = 5; // mast pitch motor port

	public static final int winchPort = 6;

	public static final int mastWinchPort = 7;

	public static final int mastHookPort = 8;

	// DIO
	public static final int leftEncPortA = 0; // left drivetrain enc A
	public static final int leftEncPortB = 1; // left drivetrain enc B
	public static final int rightEncPortA = 2; // right drivetrain enc A
	public static final int rightEncPortB = 3; // right drivetrain enc B

	public static final int mastPitchEncA = 6; // mast pitch enc A
	public static final int mastPitchEncB = 7; // mast pitch enc B

	public static final int mastHookEncA = 4;
	public static final int mastHookEncB = 5;

	public static final int mastWinchLimit = 8;

	public static final int intakeLimitPort = 9; // intake limit switch

	// AIN
	public static final int intakePitchPotPort = 0; // intake actuator pot

}

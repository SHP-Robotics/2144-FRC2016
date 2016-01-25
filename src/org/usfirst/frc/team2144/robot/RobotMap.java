package org.usfirst.frc.team2144.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// This is keybindings, basically
	public static final int fLeftPort = 0;
	public static final int fRightPort = 1;
	public static final int bLeftPort = 2;
	public static final int bRightPort = 3;
	public static final int ArmBasePort = 4;
	public static final int ArmJointPort = 5;

	public static final int ArmBasePotPort = 0;

	public static final int leftEncPortA = 0;
	public static final int leftEncPortB = 1;
	public static final int rightEncPortA = 2;
	public static final int rightEncPortB = 3;

	public static final int armBaseUp = 4;
	public static final int armBaseDown = 0;

	public static final int ArmJointEncoderA = 3;
	public static final int ArmJointEncoderB = 4;

}

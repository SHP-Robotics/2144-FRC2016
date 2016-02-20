package org.usfirst.frc.team2144.robot;

public class Constants {

	// linear actuator up/down
	public static final double actUp = 0.40;
	public static final double actDown = 0.90;
	public static final double actHalfDown = actDown - 0.15;
	
	public static final double actUpAngle = 53;
	public static final double actDownAngle = -20;

	// intake motor speeds and servo pos
	public static final double intakeIntakeSpeed = -0.3;
	public static final double intakeFireSpeed = 1;
	public static final double intakeRestingSpeed = 0;
	public static final double intakeServoFire = 0.5;
	public static final double intakeServoResting = 0.9;

	// intake PID values
	public static final double intakeP = 3;
	public static final double intakeI = 0;
	public static final double intakeD = 0;
	
	public static final double winchSpeed = -0.95;

	// mast pitch PID values
	public static final double mastPitchP = 0.015;
	public static final double mastPitchI = 0;
	public static final double mastPitchD = 0;
	public static final double mastPitchPIDTolerance = 5;


	public static final double mastPitchUp = -126;
	public static final double mastPitchDown = 0;
	public static final double mastPitchDelay = 0.5; // time to wait (seconds)
														// before moving mast

	// mast hook PID
	public static final double mastHookP = 0.02;
	public static final double mastHookI = 0.001;
	public static final double mastHookD = 0;


}

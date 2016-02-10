package org.usfirst.frc.team2144.robot;

public class Constants {

	// linear actuator up/down
	public static final double actUp = 0.04;
	public static final double actDown = 0.62;
	public static final double actHalfDown = 0.40;

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
	
	public static final double winchSpeed = -1.0;

	// mast pitch PID values
	public static final double mastPitchP = 3;
	public static final double mastPitchI = 0;
	public static final double mastPitchD = 0;
	public static final double mastPitchPIDTolerance = 5;

	public static final double mastPitchUp = 200;
	public static final double mastPitchDown = 0;

}

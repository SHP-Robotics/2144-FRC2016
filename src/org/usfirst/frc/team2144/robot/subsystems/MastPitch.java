package org.usfirst.frc.team2144.robot.subsystems;

import org.usfirst.frc.team2144.robot.Constants;
import org.usfirst.frc.team2144.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class MastPitch extends PIDSubsystem {

	Talon talon;
	Encoder encoder;

	// Initialize your subsystem here
	public MastPitch() {
		super(Constants.mastPitchP, Constants.mastPitchI, Constants.mastPitchD);
		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
		talon = new Talon(RobotMap.mastPitchPort);
		encoder = new Encoder(RobotMap.mastPitchEncA, RobotMap.mastPitchEncB);
	}
	
	public void reset_encoder() {
		encoder.reset();
	}
	
	public int get_encoder() {
		return encoder.get();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		return encoder.get();
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		talon.set(output);
	}
}

package org.usfirst.frc.team2144.robot.subsystems;

import org.usfirst.frc.team2144.robot.RobotMap;
import org.usfirst.frc.team2144.robot.commands.IntakePitchDrive;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class IntakePitch extends PIDSubsystem {

	public AnalogPotentiometer pot;
	public Talon talon;

	// Initialize your subsystem here
	public IntakePitch() {
		super(3, 0, 0);
		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
		pot = new AnalogPotentiometer(RobotMap.intakePitchPotPort);
		talon = new Talon(RobotMap.intakePitchPort);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new IntakePitchDrive());
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		return pot.get();
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		talon.set(output);
	}
}

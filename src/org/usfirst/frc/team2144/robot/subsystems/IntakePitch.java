package org.usfirst.frc.team2144.robot.subsystems;

import org.usfirst.frc.team2144.robot.Constants;
import org.usfirst.frc.team2144.robot.RobotMap;
import org.usfirst.frc.team2144.robot.commands.IntakePitchDrive;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class IntakePitch extends PIDSubsystem {

	public AnalogPotentiometer pot;
	public Talon talon;

	// Initialize your subsystem here
	public IntakePitch() {
		super(Constants.intakeP, Constants.intakeI, Constants.intakeD);
		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
		pot = new AnalogPotentiometer(RobotMap.intakePitchPotPort);
		talon = new Talon(RobotMap.intakePitchPort);
		LiveWindow.addActuator("IntakePitch", "motor", talon);
		LiveWindow.addSensor("IntakePitch", "pot", pot);
		LiveWindow.addActuator("IntakePitch", "pid", getPIDController());
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new IntakePitchDrive());
	}
	
	public void drive(double speed) {
		talon.set(speed);
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

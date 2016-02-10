package org.usfirst.frc.team2144.robot.commands;

import org.usfirst.frc.team2144.robot.Constants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MastPitchUp extends CommandBase {

	public MastPitchUp() {
		// Use requires() here to declare subsystem dependencies
		requires(mastPitch);
		requires(intakePitch);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		intakePitch.setSetpoint(Constants.actHalfDown);
		Timer.delay(1.5);
		mastPitch.setSetpoint(Constants.mastPitchUp);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return mastPitch.get_encoder() >= Constants.mastPitchUp;
	}

	// Called once after isFinished returns true
	protected void end() {
		intakePitch.setSetpoint(Constants.actUp);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}

package org.usfirst.frc.team2144.robot.commands;

import org.usfirst.frc.team2144.robot.Constants;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class MastPitchDrive extends CommandBase {

	public MastPitchDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(mastPitch);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		mastPitch.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (oi.getMastPitchUp()) {
			mastPitch.enable();
			mastPitch.setSetpoint(Constants.mastPitchUp);
		} else if (oi.getMastPitchDown()) {
			mastPitch.setSetpoint(Constants.mastPitchDown);
			Timer.delay(0.1);
			mastPitch.disable();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
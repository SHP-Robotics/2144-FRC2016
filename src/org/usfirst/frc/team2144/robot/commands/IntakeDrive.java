package org.usfirst.frc.team2144.robot.commands;

import org.usfirst.frc.team2144.robot.Constants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeDrive extends CommandBase {

	public IntakeDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(intake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (oi.getIntake()) {
			intake.set(Constants.intakeIntakeSpeed);
		} else if (oi.getSpool()) {
			intake.set(Constants.intakeFireSpeed);
		} else {
			intake.set(Constants.intakeRestingSpeed);
		}

		if (oi.getFire()) {
			intake.setServo(Constants.intakeServoFire);
		} else {
			intake.setServo(Constants.intakeServoResting);
		}
		
		if (intake.hasBall()) {
			SmartDashboard.putBoolean("I have a ball", true);
		} else {
			SmartDashboard.putBoolean("I have a ball", false);
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

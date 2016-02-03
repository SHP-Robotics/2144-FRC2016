package org.usfirst.frc.team2144.robot.commands;

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
			intake.set(-0.4);
		} else if (oi.getSpool()) {
			intake.set(1);
		} else {
			intake.set(0);
		}

		if (oi.getFire()) {
			intake.setServo(0.5);
		} else {
			intake.setServo(0.9);
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

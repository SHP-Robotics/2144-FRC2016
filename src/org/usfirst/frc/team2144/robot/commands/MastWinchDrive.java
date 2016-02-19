package org.usfirst.frc.team2144.robot.commands;

/**
 *
 */
public class MastWinchDrive extends CommandBase {

	public MastWinchDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(mastWinch);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (oi.getStick2POV() == 0) {
			mastWinch.setMotor(-0.5);
		} else if (oi.getStick2POV() == 90) {
			mastWinch.setMotor(0.5);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
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

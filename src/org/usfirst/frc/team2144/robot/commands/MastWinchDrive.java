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
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (oi.getMastWinchUp()) {
			mastWinch.setMotor(-1);
		} else if (oi.getMastWinchDown()) {
			mastWinch.setMotor(1);
		} else {
			mastWinch.setMotor(0);
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

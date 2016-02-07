package org.usfirst.frc.team2144.robot.commands;

import org.usfirst.frc.team2144.robot.Constants;
import org.usfirst.frc.team2144.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakePitchDrive extends Command {

	public IntakePitchDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.intakePitch);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.intakePitch.enable();
		Robot.intakePitch.setAbsoluteTolerance(0.005);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.oi.getIntakePitch()) {
			Robot.intakePitch.setSetpoint(Constants.actDown);
		} else {
			Robot.intakePitch.setSetpoint(Constants.actUp);
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


package org.usfirst.frc.team2144.robot.commands;

import org.usfirst.frc.team2144.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GatorDrive extends Command {

	public GatorDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.tankDrive(Robot.oi.getPrecise(), Robot.oi.getStickY() * -1, Robot.oi.getStick2Y() * -1);
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

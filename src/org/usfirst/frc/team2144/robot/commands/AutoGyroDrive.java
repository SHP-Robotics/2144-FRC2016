package org.usfirst.frc.team2144.robot.commands;

import org.usfirst.frc.team2144.robot.Constants;

/**
 *
 */
public class AutoGyroDrive extends CommandBase {

	double speed;
	int distance;
	double kP = Constants.autoGyroDriveP;
	
	/**
	 * Drives the robot a given distance, using the navX gyro to stay straight.
	 * @param spd the speed to drive at
	 * @param dist how far to drive (in encoder ticks)
	 */
	public AutoGyroDrive(double spd, int dist) {
		// Use requires() here to declare subsystem dependencies
		requires(drivetrain);
		requires(sensors);
		speed = spd;
		distance = dist;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		sensors.resetNavX();
		drivetrain.arcadeDrive(false, speed, 0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double error = -sensors.getYaw() * kP;
		if (error > 1) {
			error = 1;
		} else if (error < -1) {
			error = -1;
		}
		drivetrain.arcadeDrive(false, speed, error);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (drivetrain.have_encoders_reached_pos(distance, distance)) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		drivetrain.tankDrive(false, 0, 0);
		drivetrain.reset_encoders();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}

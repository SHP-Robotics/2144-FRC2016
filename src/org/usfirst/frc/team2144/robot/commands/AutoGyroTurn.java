package org.usfirst.frc.team2144.robot.commands;

import org.usfirst.frc.team2144.robot.Constants;

/**
 *
 */
public class AutoGyroTurn extends CommandBase {

	double speed, angle;

	/**
	 * Turn to a given angle using navX gyro.
	 * 
	 * @param spd
	 *            The speed to turn at (positive for right, neg for left)
	 * @param angl
	 *            How far to turn (in degrees)
	 */
	public AutoGyroTurn(double spd, double angl) {
		// Use requires() here to declare subsystem dependencies
		requires(drivetrain);
		requires(sensors);
		speed = -spd;
		angle = angl;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		sensors.resetYaw();
		drivetrain.arcadeDrive(false, 0, speed);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		drivetrain.arcadeDrive(false, 0, speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return sensors.getYaw() > angle - Constants.turningTolerance
				&& sensors.getYaw() < angle + Constants.turningTolerance;
	}

	// Called once after isFinished returns true
	protected void end() {
		drivetrain.arcadeDrive(false, 0, 0);
		drivetrain.reset_encoders();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}

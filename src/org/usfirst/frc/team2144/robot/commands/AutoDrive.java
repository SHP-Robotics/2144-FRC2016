package org.usfirst.frc.team2144.robot.commands;

/**
 *
 */
public class AutoDrive extends CommandBase {

	double leftSpeed, rightSpeed;
	int leftDistance = 0, rightDistance = 0;

	public AutoDrive(double leftSpd, double rightSpd) {
		// Use requires() here to declare subsystem dependencies
		requires(drivetrain);
		leftSpeed = leftSpd;
		rightSpeed = rightSpd;
	}

	public AutoDrive(double leftSpd, double rightSpd, int leftDist, int rightDist) {
		requires(drivetrain);
		leftSpeed = leftSpd;
		rightSpeed = rightSpd;
		leftDistance = leftDist;
		rightDistance = rightDist;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		drivetrain.tankDrive(false, leftSpeed + 0.09, rightSpeed);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		drivetrain.tankDrive(false, leftSpeed + 0.09, rightSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (drivetrain.have_encoders_reached_pos(leftDistance, rightDistance)) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		if (leftDistance == 0 && rightDistance == 0) {
			
		} else {
			drivetrain.tankDrive(false, 0, 0);
			drivetrain.reset_encoders();
		}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}

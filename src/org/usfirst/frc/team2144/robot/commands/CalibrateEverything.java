package org.usfirst.frc.team2144.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CalibrateEverything extends CommandBase {

	public CalibrateEverything() {
		// Use requires() here to declare subsystem dependencies
		requires(drivetrain);
		requires(intakePitch);
		// requires(mastPitch);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		drivetrain.reset_encoders();
		// mastPitch.reset_encoder();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		intakePitch.drive(oi.getStickY() * -1);

		drivetrain.arcadeDrive(false, oi.getStick2X(), oi.getStick2Y() * -1);

		SmartDashboard.putNumber("potV", intakePitch.pot.get());
		SmartDashboard.putNumber("LDT enc", drivetrain.leftEnc.get());
		SmartDashboard.putNumber("RDT enc", drivetrain.rightEnc.get());
		// SmartDashboard.putNumber("mastPitchV", mastPitch.get_encoder());
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

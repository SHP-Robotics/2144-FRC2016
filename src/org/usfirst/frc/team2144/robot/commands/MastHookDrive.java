package org.usfirst.frc.team2144.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MastHookDrive extends CommandBase {

	public MastHookDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(mastHook);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		mastHook.reset_encoder();
		mastHook.setSetpoint(0);
		mastHook.enable();
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (oi.getMastHookUp()) {
			mastHook.drive(1);;
		} else if (oi.getMastHookDown()) {
			mastHook.drive(-0.5);;
		} else {
			mastHook.drive(0);
		}
		SmartDashboard.putNumber("hookPt", mastHook.getSetpoint());
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

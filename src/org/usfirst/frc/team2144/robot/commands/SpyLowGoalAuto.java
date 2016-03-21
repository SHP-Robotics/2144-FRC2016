package org.usfirst.frc.team2144.robot.commands;

import org.usfirst.frc.team2144.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SpyLowGoalAuto extends CommandGroup {

	public SpyLowGoalAuto() {
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.

		addParallel(new AutoIntakeDrive(Constants.actUp + 0.10)); // intake
		// up
		addSequential(new ResetDrivetrainEncoders());
		addSequential(new AutoGyroDrive(0.6, 400)); // drive away from spy
		addParallel(new AutoIntakeDrive(Constants.actUp));
		addSequential(new AutoIntakeShooter(Constants.intakeFireSpeed, false), 2.0);
		addSequential(new AutoIntakeShooter(Constants.intakeFireSpeed, true), 0.5);
		addSequential(new AutoIntakeShooter(Constants.intakeRestingSpeed, false));

	}
}

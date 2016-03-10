package org.usfirst.frc.team2144.robot.commands;

import org.usfirst.frc.team2144.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class HiCastleAuto extends CommandGroup {

	public HiCastleAuto() {
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

		addParallel(new AutoIntakeDrive(Constants.actUp + 0.10, Constants.intakeRestingSpeed, false)); // intake
		// up
		addSequential(new ResetDrivetrainEncoders());
		addSequential(new AutoGyroDrive(0.6, 700)); // drive up to low bar
		addParallel(new AutoIntakeDrive(Constants.actDown, Constants.intakeRestingSpeed, false)); // intake
		// down
		addSequential(new ResetDrivetrainEncoders());
		addSequential(new AutoGyroDrive(0.6, 2300)); // drive through low bar
		addParallel(new AutoIntakeDrive(Constants.actUp + 0.10, Constants.intakeRestingSpeed, false)); // intake
		// up
		addSequential(new ResetDrivetrainEncoders());
		addSequential(new AutoGyroDrive(0.6, 1000)); // drive towards
		// castle
		addSequential(new AutoGyroTurn(0.6, 45));
	}
}

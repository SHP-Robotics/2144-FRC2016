package org.usfirst.frc.team2144.robot.commands;

import org.usfirst.frc.team2144.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BreachBAuto extends CommandGroup {

	public BreachBAuto() {
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
		addSequential(new AutoGyroDrive(1.0, 3500)); // drive up to low bar

	}
}

package org.usfirst.frc.team2144.robot.commands;

import org.usfirst.frc.team2144.robot.Constants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarAuto extends CommandGroup {

	public LowBarAuto() {
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
		
		addParallel(new AutoIntakeDrive(Constants.actUp + 0.10)); // intake up
		addSequential(new ResetDrivetrainEncoders());
		addSequential(new AutoDrive(0.6, 0.6, 700, 700)); // drive up to low bar
		addParallel(new AutoIntakeDrive(Constants.actDown)); // intake down
		addSequential(new ResetDrivetrainEncoders());
		addSequential(new AutoDrive(0.6, 0.6, 2300, 2300)); // drive through low bar
		addParallel(new AutoIntakeDrive(Constants.actUp + 0.10)); // intake up
//		addSequential(new ResetDrivetrainEncoders());
//		addSequential(new AutoDrive(0.6, 0.6, 500, 500)); // drive towards castle
	}
}

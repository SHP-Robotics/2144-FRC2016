package org.usfirst.frc.team2144.robot.subsystems;

import org.usfirst.frc.team2144.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MastHook extends Subsystem {

	Talon talon;
	Encoder encoder;

	public MastHook() {
		talon = new Talon(RobotMap.mastHookPort);
		encoder = new Encoder(RobotMap.mastHookEncA, RobotMap.mastHookEncB);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}

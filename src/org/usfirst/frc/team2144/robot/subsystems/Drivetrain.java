
package org.usfirst.frc.team2144.robot.subsystems;

import org.usfirst.frc.team2144.robot.RobotMap;
import org.usfirst.frc.team2144.robot.commands.GatorDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public RobotDrive robit;
	public Talon fLeft, fRight, bLeft, bRight;
	// public Encoder leftEnc, rightEnc;

	public Drivetrain() {
		fLeft = new Talon(RobotMap.fLeftPort);
		fRight = new Talon(RobotMap.fRightPort);
		bLeft = new Talon(RobotMap.bLeftPort);
		bRight = new Talon(RobotMap.bRightPort);
		robit = new RobotDrive(fLeft, bLeft, fRight, bRight);
		// leftEnc = new Encoder(RobotMap.leftEncPortA, RobotMap.leftEncPortB);
		// rightEnc = new Encoder(RobotMap.rightEncPortA,
		// RobotMap.rightEncPortB);
	}

	public void arcadeDrive(boolean isPrecise, double stickX, double stickY) {
		if (isPrecise)
			robit.arcadeDrive(stickY, stickX);
		else
			robit.arcadeDrive(stickY / 2, stickX / 2);
	}

	public void tankDrive(boolean isPrecise, double leftStickY, double rightStickY) {
		if (isPrecise)
			robit.tankDrive(leftStickY, rightStickY);
		else
			robit.tankDrive(leftStickY / 2, rightStickY / 2);
	}

	/*
	 * public boolean have_encoders_reached_pos(int leftPos, int rightPos) { if
	 * (has_left_encoder_reached_pos(leftPos) &&
	 * has_right_encoder_reached_pos(rightPos)) { return true; } else { return
	 * false; } }
	 * 
	 * public boolean has_left_encoder_reached_pos(int pos) { if
	 * (Math.abs(leftEnc.get()) >= pos) { return true; } else { return false; }
	 * }
	 * 
	 * public boolean has_right_encoder_reached_pos(int pos) { if
	 * (Math.abs(rightEnc.get()) >= pos) { return true; } else { return false; }
	 * }
	 * 
	 * public void reset_left_encoder() { leftEnc.reset(); }
	 * 
	 * public void reset_right_encoder() { rightEnc.reset(); }
	 * 
	 * public void reset_encoders() { reset_left_encoder();
	 * reset_right_encoder(); }
	 */

	public void initDefaultCommand() {
		setDefaultCommand(new GatorDrive());
	}
}

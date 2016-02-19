package org.usfirst.frc.team2144.robot.subsystems;

import org.usfirst.frc.team2144.robot.Constants;
import org.usfirst.frc.team2144.robot.RobotMap;
import org.usfirst.frc.team2144.robot.commands.MastHookDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class MastHook extends PIDSubsystem {

	Talon talon;
	Encoder encoder;

	public MastHook() {
		super(Constants.mastHookP, Constants.mastHookI, Constants.mastHookD);
		talon = new Talon(RobotMap.mastHookPort); 
		encoder = new Encoder(RobotMap.mastHookEncA, RobotMap.mastHookEncB);
		LiveWindow.addActuator("MastHook", "motor", talon);
		LiveWindow.addSensor("MastHook", "encoder", encoder);
	}

	public void drive(double foo) {
		talon.set(foo);
	}

	public int get_encoder() {
		return encoder.get();
	}

	public void reset_encoder() {
		encoder.reset();
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new MastHookDrive());
	}

	protected double returnPIDInput() {
		return encoder.get();
	}

	protected void usePIDOutput(double output) {
		talon.set(output);
	}
}

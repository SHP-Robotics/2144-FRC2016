package org.usfirst.frc.team2144.robot.subsystems;

import org.usfirst.frc.team2144.robot.RobotMap;
import org.usfirst.frc.team2144.robot.commands.MastWinchDrive;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class MastWinch extends Subsystem {

	Talon talon;
	DigitalInput limit;

	public MastWinch() {
		talon = new Talon(RobotMap.mastWinchPort);
		limit = new DigitalInput(RobotMap.mastWinchLimit);
		LiveWindow.addActuator("MastWinch", "motor", talon);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void setMotor(double foo) {
		talon.set(foo);
	}

	public boolean getLimit() {
		return limit.get();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new MastWinchDrive());
	}
}

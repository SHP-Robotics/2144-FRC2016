package org.usfirst.frc.team2144.robot.subsystems;

import org.usfirst.frc.team2144.robot.RobotMap;
import org.usfirst.frc.team2144.robot.commands.WinchDrive;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {
	
	Talon talon;
	
	public Winch() {
		talon = new Talon(RobotMap.winchPort);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new WinchDrive());
    }

	public void drive(double winchspeed) {
		talon.set(winchspeed);
	}
}


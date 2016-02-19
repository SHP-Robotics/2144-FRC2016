package org.usfirst.frc.team2144.robot.subsystems;

import org.usfirst.frc.team2144.robot.RobotMap;
import org.usfirst.frc.team2144.robot.commands.WinchDrive;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Winch extends Subsystem {
	
	Talon talon;
	
	public Winch() {
		talon = new Talon(RobotMap.winchPort);
		LiveWindow.addActuator("Winch", "Winch", talon);
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


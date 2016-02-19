package org.usfirst.frc.team2144.robot.subsystems;

import org.usfirst.frc.team2144.robot.RobotMap;
import org.usfirst.frc.team2144.robot.commands.IntakeDrive;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Intake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Talon talon; 
	public Servo servo;
	public DigitalInput limit;
	
	public Intake() {
		talon = new Talon(RobotMap.intakeTalonPort);
		servo = new Servo(RobotMap.intakeServoPort);
		limit = new DigitalInput(RobotMap.intakeLimitPort);
	}
	
	public void set(double speed) {
		talon.set(speed);
	}
	
	public void setServo(double pos) {
		servo.set(pos);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new IntakeDrive());
    }

	public boolean hasBall() {
		return limit.get();
	}
}


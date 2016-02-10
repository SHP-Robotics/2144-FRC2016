package org.usfirst.frc.team2144.robot;

import org.usfirst.frc.team2144.robot.commands.MastPitchDown;
import org.usfirst.frc.team2144.robot.commands.MastPitchUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	Joystick left = new Joystick(0);
	Joystick right = new Joystick(1);

	JoystickButton mastPitchUpButton = new JoystickButton(left, ControlMap.mastPitchUpButton);
	JoystickButton mastPitchDownButton = new JoystickButton(left, ControlMap.mastPitchDownButton);

	public OI() {
		mastPitchUpButton.whenPressed(new MastPitchUp());
		mastPitchDownButton.whenPressed(new MastPitchDown());
	}

	public double getStickX() {
		return left.getX();
	}

	public double getStickY() {
		return left.getY();
	}

	public double getStick2Y() {
		return right.getY();
	}

	public int getStick2POV() {
		return right.getPOV();
	}

	public boolean getPrecise() {
		return false;
	}

	public boolean getFire() {
		return right.getRawButton(ControlMap.fireButton);
	}

	public boolean getSpool() {
		return left.getRawButton(ControlMap.spoolButton);
	}

	public boolean getIntake() {
		return left.getRawButton(ControlMap.intakeButton);
	}

	public boolean getIntakePitch() {
		return right.getRawButton(ControlMap.intakePitchButton);
	}

	public boolean getWinch() {
		return left.getRawButton(ControlMap.winchButton);
	}

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}

package org.usfirst.frc.team2144.robot;

import org.usfirst.frc.team2144.robot.commands.IntakePitchOverride;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	Joystick left = new Joystick(0);
	Joystick right = new Joystick(1);

	JoystickButton actEmergOverrideButton = new JoystickButton(right, ControlMap.actEmergOverrideButton);

	public OI() {
		actEmergOverrideButton.whenPressed(new IntakePitchOverride());
	}

	public double getStickX() {
		return left.getX();
	}

	/**
	 * returns non-inverted Y
	 */
	public double getStickY() {
		return left.getY();
	}

	public double getStick2X() {
		return right.getX();
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

	public boolean getMastPitchUp() {
		return left.getRawButton(ControlMap.mastPitchUpButton);
	}

	public boolean getMastPitchDown() {
		return left.getRawButton(ControlMap.mastPitchDownButton);
	}

	public double getActOverride() {
		if (left.getRawButton(ControlMap.actUpButton)) {
			return -0.5;
		} else if (left.getRawButton(ControlMap.actDownButton)) {
			return 0.5;
		} else {
			return 0;
		}
	}

	public double getIntakePitchPitch() {
		double i = (right.getThrottle() + 1) / 2;
		i = ((i * (Constants.actDown - Constants.actUp)) / 5) + Constants.actUp;
		return i;
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


package org.usfirst.frc.team2144.robot;

import org.usfirst.frc.team2144.robot.commands.CalibrateEverything;
import org.usfirst.frc.team2144.robot.commands.CommandBase;
import org.usfirst.frc.team2144.robot.commands.HiCastleAuto;
import org.usfirst.frc.team2144.robot.commands.LowBarAuto;
import org.usfirst.frc.team2144.robot.commands.ReachDefAuto;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	// public static final Drivetrain drivetrain = new Drivetrain();
	// public static final Intake intake = new Intake();
	// public static final IntakePitch intakePitch = new IntakePitch();
	public static OI oi;

	Command autonomousCommand;
	CalibrateEverything testCommand;
	SendableChooser autoChooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		// instantiate the command used for the autonomous period
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Low Bar Auto", new LowBarAuto());
		autoChooser.addObject("Reach Auto", new ReachDefAuto());
		autoChooser.addObject("High Goal Auto", new HiCastleAuto());
		autoChooser.addObject("No Auto", null);

		testCommand = new CalibrateEverything();

		SmartDashboard.putData("Auto Chooser", autoChooser);

		// put everything on the SmartDashboard
		CommandBase.init();
		SmartDashboard.putData(Scheduler.getInstance());

	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		autonomousCommand = (Command) autoChooser.getSelected();

		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void disabledInit() {
		if (testCommand != null)
			testCommand.cancel();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();

	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}

package org.usfirst.frc.team2144.robot.commands;

import org.usfirst.frc.team2144.robot.Constants;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import misc.ParticleReport;

/**
 *
 */
public class AlignToTower extends CommandBase {

	double xTolerance = Constants.VPXTolerance;
	double distTolerance = Constants.VPDistTolerance;
	Image derpImage;
	double VIEW_ANGLE = 64; // View angle fo camera, set to Axis m1011 by
							// default, 64 for m1013, 51.7 for 206, 52 for
							// HD3000 square, 60 for HD3000 640x480
	double targetDist = Constants.VPTargetDist;
	double targetX = Constants.VPTargetX;

	public AlignToTower() {
		// Use requires() here to declare subsystem dependencies
		requires(drivetrain);
		requires(camera);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		camera.getImage(derpImage);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		camera.runProcessing();
		ParticleReport particle = camera.getParticle();

		if (particle != null) {
			double distError = computeDistance(derpImage, particle) - targetDist;
			double xError = targetX - ((particle.BoundingRectRight + particle.BoundingRectLeft) / 2);
			
			drivetrain.arcadeDrive(false, -1 * distError, 0.1 * xError);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

	/**
	 * Computes the estimated distance to a target using the width of the
	 * particle in the image. For more information and graphics showing the math
	 * behind this approach see the Vision Processing section of the
	 * ScreenStepsLive documentation.
	 *
	 * @param image
	 *            The image to use for measuring the particle estimated
	 *            rectangle
	 * @param report
	 *            The Particle Analysis Report for the particle
	 * 
	 * @return The estimated distance to the target in feet.
	 */
	double computeDistance(Image image, ParticleReport report) {
		double normalizedWidth, targetWidth;
		NIVision.GetImageSizeResult size;

		size = NIVision.imaqGetImageSize(image);
		normalizedWidth = 2 * (report.BoundingRectRight - report.BoundingRectLeft) / size.width;
		targetWidth = 20;

		return targetWidth / (normalizedWidth * 12 * Math.tan(VIEW_ANGLE * Math.PI / (180 * 2)));
	}
}

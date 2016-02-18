package org.usfirst.frc.team2144.robot.subsystems;

import org.usfirst.frc.team2144.robot.commands.SensorMonitor;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Sensors extends Subsystem {
	
	AHRS navx;
	PowerDistributionPanel pdp;
	
	public Sensors() {
		pdp = new PowerDistributionPanel(0);
		try {
            navx = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void updateTemp() {
		SmartDashboard.putNumber("PDP temp", pdp.getTemperature());
		SmartDashboard.putNumber("navX Temp", navx.getTempC());
	}
	
	public double getYaw() {
		return navx.getYaw();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new SensorMonitor());
    }
}


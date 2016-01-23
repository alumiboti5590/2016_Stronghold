package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5590.robot.OI;
import org.usfirst.frc.team5590.robot.commands.Drive;

public class Drivetrain extends Subsystem {
	
	private static int leftTrackSlot = 1;
    private static int rightTrackSlot = 2;
    
	private static RobotDrive robotDrive;
    
    /**
	 * Initializes Talon Speed Controllers without needing an existing instance.
	 */
	public static void initializeControllers(){
		SpeedController leftTrackController = new TalonSRX(leftTrackSlot);
		SpeedController rightTrackController = new TalonSRX(rightTrackSlot);
		robotDrive = new RobotDrive(leftTrackController, rightTrackController);
    	robotDrive.setSafetyEnabled(false);
    	robotDrive.setExpiration(.1);
    	robotDrive.setSensitivity(.5);
    	robotDrive.setMaxOutput(1.0);
	}
    
    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
    }
	
	/**
	 * 
	 */
	public void updateSpeed() {
		double axisValue = OI.xboxController.getLeftStickY();
		robotDrive.tankDrive(axisValue, axisValue, true);
	}
	
	public void takeJoystickInput(double left, double right) {
		robotDrive.tankDrive(left, right);
	}
	
	public void setSpeed(double speed) {
		robotDrive.tankDrive(speed, speed);
	}
	
	public void rotateLeft(double speed) {
		robotDrive.tankDrive(-speed, speed);
	}
	
	public void rotateRight(double speed) {
		robotDrive.tankDrive(speed, -speed);
	}
	
	public void stop() {
		robotDrive.drive(0, 0);
	}
   
}


package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

import org.usfirst.frc.team5590.robot.commands.StopDriving;

public class Drivetrain extends Subsystem {
	
	private static int leftTrackSlot = 1;
    private static int rightTrackSlot = 2;
	private static RobotDrive robotDrive;
	private static SpeedController leftTrackController;
    private static SpeedController rightTrackController;
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	/**
	 * Initializes Talon Speed Controllers without needing an existing instance.
	 */
	public static void initializeControllers(){
		
		leftTrackController = new TalonSRX(leftTrackSlot);
    	LiveWindow.addActuator("Drivetrain", "Left Track", (LiveWindowSendable) leftTrackController);
    	
    	rightTrackController = new TalonSRX(rightTrackSlot);
    	LiveWindow.addActuator("Drivetrain", "Left Track", (LiveWindowSendable) rightTrackController);
    
    	robotDrive = new RobotDrive(leftTrackController, rightTrackController);
    	
    	robotDrive.setSafetyEnabled(false);
    	robotDrive.setExpiration(.1);
    	robotDrive.setSensitivity(.5);
    	robotDrive.setMaxOutput(1.0);
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
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new StopDriving());
    }
}


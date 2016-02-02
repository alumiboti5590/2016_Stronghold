package org.usfirst.frc.team5590.robot.subsystems;

import org.usfirst.frc.team5590.robot.OI;
import org.usfirst.frc.team5590.robot.commands.Drive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	private static final int leftTrackDIO = 0;
	private static final int rightTrackDIO = 1;

	private static RobotDrive robotDrive;
	
	private double leftMotorSpeed = 0;
	private double rightMotorSpeed = 0;

	/**
	 * Initializes Talon Speed Controllers without needing an existing instance.
	 */
	public static void initializeControllers() {

		SpeedController leftTrackController = new TalonSRX(leftTrackDIO);
		SpeedController rightTrackController = new TalonSRX(rightTrackDIO);

		robotDrive = new RobotDrive(leftTrackController, rightTrackController);
		robotDrive.setSafetyEnabled(false);

	}

	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}
	
	/**
	 * This function is called continuously. If we are currently in driving mode
	 * ( The motors are already spinning ) no spin will occur. This means that 
	 * the only time this will function is when the robot is not moving. 
	 * 
	 */
	public void updateSpin() {
		double rightTrigger = OI.xboxController.getRightTrigger()/2;
		double leftTrigger = OI.xboxController.getLeftTrigger()/2;
		double rotateSpeed = rightTrigger - leftTrigger;
		if (this.leftMotorSpeed == 0 && this.rightMotorSpeed == 0) {
			this.leftMotorSpeed = rotateSpeed;
			this.rightMotorSpeed = rotateSpeed*-1;
			robotDrive.tankDrive(this.leftMotorSpeed*-1, this.rightMotorSpeed*-1);
			System.out.println("Setting rotate speed.. motors are not moving");
		}
		System.out.println("right: " + rightTrigger + " left: "+ leftTrigger);
	}

	/**
	 * 
	 */
	public void updateSpeed() {
		double leftStickY = roundToTenth(OI.xboxController.getLeftStickY());
		double rightStickY = roundToTenth(OI.xboxController.getRightStickY());
		this.rightMotorSpeed = leftStickY*.75;
		this.leftMotorSpeed = rightStickY*.75;
		robotDrive.tankDrive(this.leftMotorSpeed, this.rightMotorSpeed);
		System.out.println("Y Axis Left Stick: " + leftStickY);
		System.out.println("X Axis Left Stick: " + rightStickY + "\n");
	}
	
	private double roundToTenth(double speed) {
		double value = Math.round(speed*10);
		System.out.println(value/10);
		return value/10;
	}

	public void takeJoystickInput(double left, double right) {
		robotDrive.tankDrive(left, right);
		System.out.println("Left: " + left + "...Right:" + right);
	}

	public void setSpeed(double speed) {
		robotDrive.tankDrive(speed, speed);
		System.out.println("Speed: " + speed);
	}

	public void rotateLeft(double speed) {
		robotDrive.tankDrive(-speed, speed);
		System.out.println("Speed: " + speed);
	}

	public void rotateRight(double speed) {
		robotDrive.tankDrive(speed, -speed);
		System.out.println("Speed: " + speed);
	}

	public void stop() {
		robotDrive.tankDrive(0.0, 0.0);
		System.out.println("Stopped");
	}

}

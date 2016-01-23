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

	/**
	 * Initializes Talon Speed Controllers without needing an existing instance.
	 */
	public static void initializeControllers() {

		SpeedController leftTrackController = new TalonSRX(leftTrackDIO);
		SpeedController rightTrackController = new TalonSRX(rightTrackDIO);

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
		System.out.println(axisValue);
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
		robotDrive.drive(0, 0);
		System.out.println("Stopped");
	}

}

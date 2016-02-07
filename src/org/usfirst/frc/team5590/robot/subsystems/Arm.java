package org.usfirst.frc.team5590.robot.subsystems;

import org.usfirst.frc.team5590.robot.OI;
import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.commands.arm.ManualArmControl;

import com.ni.vision.NIVision.GeometricSetupDataItem;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {

	private static final int ARM_ROTATIONAL_PWM = 4;

	/**
	 * DIO Ports for Encoder
	 */
	private static int ROTATIONAL_ENCODER_SIGNAL_A = 0;
	private static int ROTATIONAL_ENCODER_SIGNAL_B = 1;
	
	private static SpeedController rotationalSpeedController;
	private static Encoder         rotationalEncoder;
	
	private double encoderRawPosition = 0.0;
	
	public boolean isMoving = false;
	
	public void initDefaultCommand() {
	}
	
	public void resetArm() {
		this.rotateClockwise(0);
		rotationalEncoder.reset();
	}

	public static void initializeControllers() {	
		rotationalSpeedController = new TalonSRX(ARM_ROTATIONAL_PWM);
		rotationalEncoder = new Encoder(ROTATIONAL_ENCODER_SIGNAL_A, ROTATIONAL_ENCODER_SIGNAL_B,
				false, EncodingType.k2X);
	}

	public void setPosition(double degrees){
    	boolean direction = degrees > getDegrees();
    	if (direction) {
    		rotateCounterClockwise(getDistance(degrees));
    	} else {
    		rotateClockwise(getDistance(degrees));
    	}
	}
	
	/**
	 * @param rawDistance
	 */
	public void rotateClockwise(double rawDistance) {
		while (rotationalEncoder.getDistance() > rawDistance) {
			rotationalSpeedController.set(-0.5);
		}
		System.out.println("Current Location: " + rotationalEncoder.getDistance() + " Final Location: " + rawDistance);
		rotationalSpeedController.set(0.0);
	}
	
	/**
	 * @param rawDistance The distance for the encoder to compare against.
	 */
	private void rotateCounterClockwise(double rawDistance) {
		while (rotationalEncoder.getDistance() < rawDistance) {
			rotationalSpeedController.set(0.5);
			isMoving = true;
		}
		System.out.println("Current Location: " + rotationalEncoder.getDistance() + " Final Location: " + rawDistance);
		rotationalSpeedController.set(0.0);
		isMoving = false;
	}
	
	public void updateRotationalMotor() {
		double logitechJoystickZ = OI.logitechController.getMainStickZ() / 4;
		if (rotationalEncoder.getDistance() > 480) {
			rotationalSpeedController.set(0.0);
		} else {
			rotationalSpeedController.set(logitechJoystickZ * -1);
		}
		System.out.println("Distance: " + rotationalEncoder.getDistance() + " Direction: "
				+ rotationalEncoder.getDirection());
		encoderRawPosition = rotationalEncoder.getDistance();
	}

	public double getDegrees(){
		return .27355*encoderRawPosition;
	}
	
	public double getDistance(double degrees){
		return 3.6555*degrees;
	}
	
	public void turnPerDegree(double desiredDegree) {
		double desiredDistance = (4 * desiredDegree) / 3;
		int outputDistance = (int) desiredDistance;
		int precision = 1;
		if (desiredDegree > 0) {
			while (rotationalEncoder.getDistance() < outputDistance) {
				rotationalSpeedController.set(.5 / precision);
			}
			// Error handling
			if (Math.abs(rotationalEncoder.getDistance() - outputDistance) > 25) {
				double error = rotationalEncoder.getDistance();
				while (rotationalEncoder.getDistance() > 5 + outputDistance) {
					rotationalSpeedController.set(-.2 / precision);
				}
				precision+=5;
				// End error
			}
		} else {
			while (rotationalEncoder.getDistance() > outputDistance) {
				rotationalSpeedController.set(-.5 / precision);
			}
			// Error Handling
			if (Math.abs(rotationalEncoder.getDistance() - outputDistance) > 25) {
				double error = rotationalEncoder.getDistance();
				while (rotationalEncoder.getDistance() < outputDistance - 5) {
					rotationalSpeedController.set(.2 / precision);
				}
				precision+=5;
				// End error
			}
		}
			rotationalSpeedController.set(0.0);
			System.out.println("Distance: " + rotationalEncoder.getDistance() + " Direction: "
					+ rotationalEncoder.getDirection());
	}
}

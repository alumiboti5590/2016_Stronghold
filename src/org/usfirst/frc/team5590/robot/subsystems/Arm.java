package org.usfirst.frc.team5590.robot.subsystems;
import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.commands.arm.ManualArmControl;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {

	private static final int ARM_ROTATIONAL_PWM = 2;

	/**
	 * DIO Ports for Encoder
	 */
	private static int ROTATIONAL_ENCODER_SIGNAL_A = 0;
	private static int ROTATIONAL_ENCODER_SIGNAL_B = 1;
	
	private static int DIO_SAFETY_SWITCH_PORT = 9;
	
	private static SpeedController rotationalSpeedController;
	private static Encoder         rotationalEncoder;
	public static DigitalInput    safetySwitch;
	
	public void initDefaultCommand() {
	}

	/**
	 * Rotate the arm back to starting position until
	 * the digital switch gets set (meaning we hit the reset point.)
	 */
	public void resetArm() {
		this.rotate(0, 1);
		System.out.println("Reseting Arm");
		while (!safetySwitch.get()) {
			rotationalSpeedController.set(0.1);
		}
		rotationalSpeedController.set(0.0);
		rotationalEncoder.reset();
	}

	/**
	 * Setup the controllers with the desired ports
	 */
	public static void initializeControllers() {	
		rotationalSpeedController = new TalonSRX(ARM_ROTATIONAL_PWM);
		rotationalEncoder = new Encoder(ROTATIONAL_ENCODER_SIGNAL_A, ROTATIONAL_ENCODER_SIGNAL_B,
				false, EncodingType.k2X);
		 safetySwitch = new DigitalInput(DIO_SAFETY_SWITCH_PORT);
	}

	/**
	 * Set the position of the arm a certain amount of degrees.
	 * @param degrees
     */
	public void setPosition(double degrees){
    	if (degrees > this.getDegrees()) {
    		System.out.println("Rotating");
    		rotate(this.getDistance(degrees), 1);
    	} else {
    		rotate(this.getDistance(degrees), -1);
    	}
	}
	
	/**
	 * This method takes in a raw distance and direction parameter, and rotates
	 * the arm at a speed of 0.5. The direction is determined by -1, and 1.
	 * 
	 * As the arm reaches 90% of its desired rotation distance, the arm will then
	 * slow down to a speed of 0.2 until desired destination is reached. This will 
	 * reduce error from the values on the encoder.
	 * 
	 * @param rawDistance is the desired rotational value
	 * @param direction -1 rotates arm clockwise, 1 rotates arm counterclockwise
	 */
	public void rotate(double rawDistance, double direction) {
		double speedControlApex = Math.abs(rawDistance * 0.15);
		if (rawDistance == 0){
			speedControlApex = Math.abs(rotationalEncoder.getDistance() * 0.15);
		}
		while ((rotationalEncoder.getDistance()*direction) < (rawDistance * direction)) {
			if (safetySwitch.get() && direction == 1) {
				break;
			}
			if (Math.abs(rotationalEncoder.getDistance() - rawDistance) < speedControlApex){
				rotationalSpeedController.set(0.2*direction);
			} else {
				rotationalSpeedController.set(0.5*direction);
			}
		}
		System.out.println("Current Location: " + rotationalEncoder.getDistance() + " Final Location: " + rawDistance);
		rotationalSpeedController.set(0.0);
	}

	/*
	 * Some fancy math functions below here
     */
	public double getDegrees(){
		return .27355*rotationalEncoder.getDistance();
	}
	
	public double getDistance(double degrees){
		return 3.6555*degrees;
	}

	public void updateRotation(){
		if (Math.abs(Robot.oi.logitechController.getMainStickY()) > 0.3 && !safetySwitch.get()){
			rotationalSpeedController.set(Robot.oi.logitechController.getMainStickY());
		} else {
			rotationalSpeedController.set(0);
		}
	}
	
	public void stopArm() {
		rotationalSpeedController.set(0);
	}
}

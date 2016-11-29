package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;


public class Shooter extends Subsystem {
	
	private static final int SHOOTER_ROTATIONAL_PWM = 3;
	
	private static final int SHOOTER_BOTTOM_PWM = 6;
	private static final int SHOOTER_TOP_PWM = 5;

	/**
	 * DIO Ports for Encoder
	 */
	private static final int ROTATIONAL_ENCODER_SIGNAL_A = 2;
	private static final int ROTATIONAL_ENCODER_SIGNAL_B = 3;
	
	private static final int DIO_SAFETY_SWITCH_PORT = 8;
	
	private static SpeedController rotationalSpeedController;
	private static Encoder         rotationalEncoder;
   
    private static SpeedController ballShooterBottom;
    private static SpeedController ballShooterTop;
    private static DigitalInput    safetySwitch;
    
    /**
     * Down is when the shooter is full retracted into the frame of the robot.
     * Shoot is when the shooter is tilted up to about 45 degrees to fire.
     * Evade is when the shooter is titled all the way to about 90 degrees.
     */
    public static enum Position {
    	DOWN, SHOOT, EVADE
    }
    
    public static Position shooterPosition;

	/**
	 * Setup the controllers with the desired ports
	 */
    public static void initializeControllers(){
    	rotationalSpeedController = new TalonSRX(SHOOTER_ROTATIONAL_PWM);
    	ballShooterBottom = new TalonSRX(SHOOTER_BOTTOM_PWM);
    	ballShooterTop = new TalonSRX(SHOOTER_TOP_PWM);
		rotationalEncoder = new Encoder(ROTATIONAL_ENCODER_SIGNAL_A, ROTATIONAL_ENCODER_SIGNAL_B,
				true, EncodingType.k2X);
		safetySwitch = new DigitalInput(DIO_SAFETY_SWITCH_PORT);
		shooterPosition = Position.DOWN;
    }
    
    public void initDefaultCommand() {
    }

    /**
	 * Starts the shooter motor
	 * @param speed
     */
    public void setShooterSpeed(double speed){
    	ballShooterBottom.set(speed);
    	ballShooterTop.set(-1 * (speed - 0.05));
    }

    /**
	 * Stops the shooter motor
	 */
    public void stopShooter(){
    	ballShooterBottom.set(0);
        ballShooterTop.set(0);
    }
    
    public void stopAll(){
    	stopShooter();
    	rotationalSpeedController.set(0);
    }

    /**
	 * Resets the position of the shooter
	 */
    public void resetShooter() {
		this.rotate(0, 1);
		while (!safetySwitch.get()) {
			rotationalSpeedController.set(0.1);
		}
		rotationalSpeedController.set(0.0);
		rotationalEncoder.reset();
	}

    /**
	 * Sets the position of the shooter
	 * @param degrees
     */
    public void setPosition(double degrees){
    	if (degrees > this.getDegrees()) {
    		rotate(this.getDistance(degrees), 1);
    	} else {
    		rotate(this.getDistance(degrees), -1);
    	}
    }

    /**
	 * Move the shooter a certain amount/distance
	 * @param rawDistance
	 * @param direction
     */
	public void rotate(double rawDistance, double direction) {
		double speedControlApex = Math.abs(rawDistance * 0.15);
		if (rawDistance == 0){
			speedControlApex = Math.abs(rotationalEncoder.getDistance() * 0.20);
		}
		System.out.println("Starting shooter Movement");
		while ((rotationalEncoder.getDistance()*direction) < (rawDistance * direction)) {
			if (safetySwitch.get()) {
				break;
			}
			if (Math.abs(rotationalEncoder.getDistance() - rawDistance) < speedControlApex){
				rotationalSpeedController.set(0.2*direction);
			} else {
				rotationalSpeedController.set(0.8*direction);
			}
		}
		System.out.println("Current Location: " + rotationalEncoder.getDistance() + " Final Location: " + rawDistance);
    	rotationalSpeedController.set(0.0);
    }

	/**
	 *  Uses logitech controller to move the shooter angle
	 */
	public void updateShooterRotation() {
		if (Math.abs(Robot.oi.logitechController.getMainStickY()) > 0.15){
			rotationalSpeedController.set(Robot.oi.logitechController.getMainStickY());
		} else {
			rotationalSpeedController.set(0);
		}
	}
	
	public void collect(double speed) {
		ballShooterBottom.set(speed);
	}
	
	public Position getPosition() {
		return shooterPosition;
	}

	/**
	 * 6337 counts per revolution
	 * @return
	 */
	public double getDegrees(){
		return 0.0568092*rotationalEncoder.getDistance();
	}
	
	public double getDistance(double degrees){
		return 17.60277*degrees;
	}
    
}


package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;


/**
 *  
 */
public class Shooter extends Subsystem {
	
	private static final int ARM_ROTATIONAL_PWM = 5;

	/**
	 * DIO Ports for Encoder
	 */
	private static int ROTATIONAL_ENCODER_SIGNAL_A = 2;
	private static int ROTATIONAL_ENCODER_SIGNAL_B = 3;
	
	private static SpeedController rotationalSpeedController;
	private static Encoder         rotationalEncoder;
   
    private static SpeedController ballShooter;
    
    public static final int ballShooterDIO = 3;
    
    public static void initializeControllers(){
    	ballShooter = new TalonSRX(ballShooterDIO);
    	rotationalSpeedController = new TalonSRX(ARM_ROTATIONAL_PWM);
		rotationalEncoder = new Encoder(ROTATIONAL_ENCODER_SIGNAL_A, ROTATIONAL_ENCODER_SIGNAL_B,
				false, EncodingType.k2X);
    }
    
    public void initDefaultCommand() {
    }
    
    public void setShooterSpeed(double speed){
    	ballShooter.set(speed);
    }
    
    public double getShooterSpeed(){
    	return ballShooter.get();
    }
    
    public void stopShooter(){
    	ballShooter.set(0);
    }
    
    public void stopAll(){
    	stopShooter();
    }
    
    public void setPosition(double degrees){
    	if (degrees > this.getDegrees()) {
    		System.out.println("Rotating");
    		rotate(this.getDistance(degrees), 1);
    	} else {
    		rotate(this.getDistance(degrees) ,-1);
    	}
    } 	
    
	public void rotate(double rawDistance, double direction) {
		double speedControlApex = rawDistance * 0.1;
		if (rawDistance == 0){
			speedControlApex = rotationalEncoder.getDistance() * 0.1;
		}
		while ((rotationalEncoder.getDistance()*direction) < (rawDistance * direction)) {
			if (Math.abs(rotationalEncoder.getDistance() - rawDistance) < speedControlApex){
				rotationalSpeedController.set(0.2*direction);
			} else {
				rotationalSpeedController.set(0.5*direction);
			}
		}
		System.out.println("Current Location: " + rotationalEncoder.getDistance() + " Final Location: " + rawDistance);
    		rotationalSpeedController.set(0.0);
    }

	public double getDegrees(){
		return .27355*rotationalEncoder.getDistance();
	}
	
	public double getDistance(double degrees){
		return 3.6555*degrees;
	}
    
}


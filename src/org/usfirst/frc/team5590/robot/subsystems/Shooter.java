package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;


/**
 *  
 */
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
    
    public static void initializeControllers(){
    	rotationalSpeedController = new TalonSRX(SHOOTER_ROTATIONAL_PWM);
    	ballShooterBottom = new TalonSRX(SHOOTER_BOTTOM_PWM);
    	ballShooterTop = new TalonSRX(SHOOTER_TOP_PWM);
		rotationalEncoder = new Encoder(ROTATIONAL_ENCODER_SIGNAL_A, ROTATIONAL_ENCODER_SIGNAL_B,
				false, EncodingType.k2X);
		safetySwitch = new DigitalInput(DIO_SAFETY_SWITCH_PORT);
    }
    
    public void initDefaultCommand() {
    }
    
    public void setShooterSpeed(double speed){
    	ballShooterBottom.set(speed);
    	ballShooterTop.set(-1 * (speed - 0.05));
    }
    
    public void stopShooter(){
    	ballShooterBottom.set(0);
        ballShooterTop.set(0);
    }
    
    public void stopAll(){
    	stopShooter(); 
    }
    
    public void resetShooter() {
		this.rotate(0, -1);
		while (!safetySwitch.get()) {
			rotationalSpeedController.set(-0.1);
			System.out.println("Reseting Shooter");
		}
		rotationalEncoder.reset();
	}
    
    public void setPosition(double degrees){
    	if (degrees > this.getDegrees()) {
    		System.out.println("Rotating Positive");
    		rotate(this.getDistance(degrees), -1);
    	} else {
    		System.out.println("Rotating Negative");
    		rotate(this.getDistance(degrees) ,1);
    	}
    } 	
    
	public void rotate(double rawDistance, double direction) {
		double speedControlApex = rawDistance * 0.1;
		if (rawDistance == 0){
			speedControlApex = rotationalEncoder.getDistance() * 0.1;
		}
		while ((rotationalEncoder.getDistance()*direction) < (rawDistance * direction)) {
			System.out.println("Encoder: " + rotationalEncoder.getDistance());
			if (safetySwitch.get()) {
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

	public double getDegrees(){
		return .27355*rotationalEncoder.getDistance();
	}
	
	public double getDistance(double degrees){
		return 3.6555*degrees;
	}
    
}


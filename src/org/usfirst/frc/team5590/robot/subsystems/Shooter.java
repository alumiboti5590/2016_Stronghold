package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;


/**
 *  
 */
public class Shooter extends Subsystem {
   
    private static SpeedController ballShooter;
    
    public static final int ballShooterDIO = 3;
    
    public static void initializeControllers(){
    	ballShooter = new TalonSRX(ballShooterDIO);
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

}


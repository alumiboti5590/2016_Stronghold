package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

import org.usfirst.frc.team5590.robot.RobotMap;
import org.usfirst.frc.team5590.robot.commands.StopShooting;

/**
 *  
 */
public class Shooter extends Subsystem {
   
    public static SpeedController ballShooter = RobotMap.ballShooterMotor;
    
    public static final int ballShooterDIO = 4;
    
    public static void initializeControllers(){
    	ballShooter = new TalonSRX(ballShooterDIO);
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new StopShooting());
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


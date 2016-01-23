package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

import org.usfirst.frc.team5590.robot.RobotMap;
import org.usfirst.frc.team5590.robot.commands.StopCollecting;

/**
 *  
 */
public class Shooter extends Subsystem {
    
    public static SpeedController ballCollector = RobotMap.ballCollectorMotor;
    public static SpeedController ballShooter = RobotMap.ballShooterMotor;
    
    public static int ballCollectorSlot = RobotMap.ballCollectorSlot;
    public static int ballShooterSlot = RobotMap.ballCollectorSlot;
    
    public static void initializeControllers(){
    	ballCollector = new TalonSRX(ballCollectorSlot);
    	ballShooter = new TalonSRX(ballShooterSlot);
    	LiveWindow.addActuator("Ball Shooter", "Shooter", (LiveWindowSendable) ballShooter);
    	LiveWindow.addActuator("Ball Collector", "Collector", (LiveWindowSendable) ballCollector);
    }
    
    public void initDefaultCommand() {
    }
    
    public void setCollectorSpeed(double speed){
    	ballCollector.set(speed);
    }
    
    public void setShooterSpeed(double speed){
    	ballShooter.set(speed);
    }
    
    public double getCollectorSpeed(){
    	return ballCollector.get();
    }
    
    public double getShooterSpeed(){
    	return ballCollector.get();
    }
    
    public void stopShooter(){
    	ballCollector.set(0);
    }
    
    public void stopCollector(){
    	ballShooter.set(0);
    }
    
    public void stopAll(){
    	stopCollector();
    	stopShooter();
    }

}


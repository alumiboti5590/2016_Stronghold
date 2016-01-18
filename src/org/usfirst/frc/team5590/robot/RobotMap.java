package org.usfirst.frc.team5590.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class RobotMap {
	public static SpeedController drivetrainLeftTrack;
    public static SpeedController drivetrainRightTrack;
    public static RobotDrive robotDrive;
    public static SpeedController ballCollector;
    public static SpeedController ballShooter;
    
    public static void init(){
    	drivetrainLeftTrack = new TalonSRX(1);
    	LiveWindow.addActuator("Drivetrain", "Left Track", (LiveWindowSendable) drivetrainLeftTrack);
    	
    	drivetrainRightTrack = new TalonSRX(2);
    	LiveWindow.addActuator("Drivetrain", "Left Track", (LiveWindowSendable) drivetrainRightTrack);
    
    	robotDrive = new RobotDrive(drivetrainLeftTrack, drivetrainRightTrack);
    	
    	robotDrive.setSafetyEnabled(false);
    	robotDrive.setExpiration(.1);
    	robotDrive.setSensitivity(.5);
    	robotDrive.setMaxOutput(1.0);
    
    	ballCollector = new TalonSRX(3);
    	LiveWindow.addActuator("Ball Collector", "Collector", (LiveWindowSendable) ballCollector);
    
    	ballShooter = new TalonSRX(4);
    	LiveWindow.addActuator("Ball Shooter", "Shooter", (LiveWindowSendable) ballShooter);
    
    }
}

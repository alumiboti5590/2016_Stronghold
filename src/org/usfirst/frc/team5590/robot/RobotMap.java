package org.usfirst.frc.team5590.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class RobotMap {
	public static SpeedController drivetrainLeftTrack;
    public static SpeedController drivetrainRightTrack;
    public static SpeedController ballCollector;
    public static SpeedController ballShooter;
    public static SpeedController breachArm;
    
    public static RobotDrive robotDrive;
    
    public static Encoder breachEncoder;
    
    //DIO slots
    public static int lTrack = 1;
    public static int rTrack = 2;
    public static int bCollector = 3;
    public static int bShooter = 4;
    public static int bArmMotor = 5;
    
    //PWM slots
    public static int bEncoder0 = 1;
    public static int bEncoder1 = 2;
    
    public static void init(){
    	drivetrainLeftTrack = new TalonSRX(lTrack);
    	LiveWindow.addActuator("Drivetrain", "Left Track", (LiveWindowSendable) drivetrainLeftTrack);
    	
    	drivetrainRightTrack = new TalonSRX(rTrack);
    	LiveWindow.addActuator("Drivetrain", "Left Track", (LiveWindowSendable) drivetrainRightTrack);
    
    	robotDrive = new RobotDrive(drivetrainLeftTrack, drivetrainRightTrack);
    	
    	robotDrive.setSafetyEnabled(false);
    	robotDrive.setExpiration(.1);
    	robotDrive.setSensitivity(.5);
    	robotDrive.setMaxOutput(1.0);
    
    	ballCollector = new TalonSRX(bCollector);
    	LiveWindow.addActuator("Ball Collector", "Collector", (LiveWindowSendable) ballCollector);
    
    	ballShooter = new TalonSRX(bShooter);
    	LiveWindow.addActuator("Ball Shooter", "Shooter", (LiveWindowSendable) ballShooter);
    
    	breachArm = new TalonSRX(bArmMotor);
    	LiveWindow.addActuator("Breach Arm", "Arm", (LiveWindowSendable) breachArm);
    	
    	// !!! THESE ENCODER VALEUS NEED TO BE VALIDATED/CHANGED FOR THIS
    	// YEAR'S SPECS !!!
    	breachEncoder = new Encoder(bEncoder0, bEncoder1, false, EncodingType.k2X);
    	breachEncoder.setMinRate(.1);
    	breachEncoder.setDistancePerPulse(.014);
    	breachEncoder.setSamplesToAverage(30);
    	
    }
}

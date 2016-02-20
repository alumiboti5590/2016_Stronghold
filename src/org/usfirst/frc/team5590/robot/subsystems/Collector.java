package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class Collector extends Subsystem {
	
	private static SpeedController ballCollectorController;
	
	// private static int DIO_SAFETY_SWITCH_PORT = 7;
	
	// private static DigitalInput collectorSwitch; 
	public static final int ballCollectorPWM = 4;
	
	public static void initializeControllers(){
		ballCollectorController = new TalonSRX(ballCollectorPWM);
		// collectorSwitch = new DigitalInput(DIO_SAFETY_SWITCH_PORT);
	}
    
	public double getCollectorSpeed(){
    	return ballCollectorController.get();
    }
	
	public void setCollectorSpeed(double speed){
    	ballCollectorController.set(speed);
    	System.out.println("Current Collector Speed: " + ballCollectorController.get());
    }
	
	public void stopCollector(){
    	ballCollectorController.set(0);
    }
	
	public void stopAll(){
		stopCollector();
	}

    public void initDefaultCommand() {
    }
    
    //public boolean getSafetySwitch() {
    	//return this.collectorSwitch.get();
    //}
}


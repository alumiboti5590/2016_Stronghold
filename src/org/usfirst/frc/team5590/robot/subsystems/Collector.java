package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class Collector extends Subsystem {
	
	private static SpeedController ballCollectorController;
	
	public static final int ballCollectorPWM = 3;
	
	public static void initializeControllers(){
		ballCollectorController = new TalonSRX(ballCollectorPWM);
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
}


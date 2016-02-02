package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

import org.usfirst.frc.team5590.robot.RobotMap;
import org.usfirst.frc.team5590.robot.commands.StopCollecting;

/**
 *
 */
public class Collector extends Subsystem {
	
	private static SpeedController ballCollector;
	
	public static final int ballCollectorDIO = 2;
	
	public static void initializeControllers(){
		ballCollector = new TalonSRX(ballCollectorDIO);
	}
    
	public double getCollectorSpeed(){
    	return ballCollector.get();
    }
	
	public void setCollectorSpeed(double speed){
    	ballCollector.set(speed);
    }
	
	public void stopCollector(){
    	ballCollector.set(0);
    }
	
	public void stopAll(){
		stopCollector();
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new StopCollecting());
    }
}


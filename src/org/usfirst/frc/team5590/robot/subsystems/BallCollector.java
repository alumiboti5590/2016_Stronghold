package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5590.robot.RobotMap;
import org.usfirst.frc.team5590.robot.commands.StopCollecting;

/**
 *  
 */
public class BallCollector extends Subsystem {
    
    SpeedController ballCollector = RobotMap.ballCollectorMotor;
	
    public void initDefaultCommand() {
       setDefaultCommand(new StopCollecting());
    }
    
    public void setSpeed(double speed){
    	ballCollector.set(speed);
    }
    
    public double getSpeed(){
    	return ballCollector.get();
    }
    
    public void stop(){
    	ballCollector.set(0);
    }
}


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

import org.usfirst.frc.team5590.robot.subsystems.Arm;
import org.usfirst.frc.team5590.robot.subsystems.Collector;
import org.usfirst.frc.team5590.robot.subsystems.Drivetrain;
import org.usfirst.frc.team5590.robot.subsystems.Shooter;

public class RobotMap {
    
    public static void init(){
    	Drivetrain.initializeControllers();
    	Shooter.initializeControllers();
    	Arm.initializeControllers();
    	Collector.initializeControllers();
    }
}

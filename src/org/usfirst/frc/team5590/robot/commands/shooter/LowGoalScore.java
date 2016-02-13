package org.usfirst.frc.team5590.robot.commands.shooter;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowGoalScore extends CommandGroup {
    
    public  LowGoalScore() {
    	requires(Robot.shooter);
        requires(Robot.collector);
        System.out.println("LOW GOAL SCORED!!!!!!!!!!!!!!!");
    }
}

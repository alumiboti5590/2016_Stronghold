package org.usfirst.frc.team5590.robot.commands.shooter;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class HighGoalScore extends CommandGroup {
    
    public  HighGoalScore() {
        requires(Robot.shooter);
        requires(Robot.collector);
        System.out.println("HIGH GOAL SCORED!!!!!!!!!!!!!!!");
    }
}

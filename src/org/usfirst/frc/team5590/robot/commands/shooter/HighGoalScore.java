package org.usfirst.frc.team5590.robot.commands.shooter;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class HighGoalScore extends CommandGroup {
    
    public  HighGoalScore() {
        requires(Robot.shooter);
        requires(Robot.collector);
        addSequential(new ShooterDeploy());
        addSequential(new AutoShoot());
        Timer.delay(3.0);
        addParallel(new AutoCollect());
        System.out.println("HIGH GOAL SCORED!!!!!!!!!!!!!!!");
    }
}

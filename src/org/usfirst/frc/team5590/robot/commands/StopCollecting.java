package org.usfirst.frc.team5590.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.*;
/**
 *
 */
public class StopCollecting extends Command {

    public StopCollecting() {
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.stopCollector();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.stopCollector();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

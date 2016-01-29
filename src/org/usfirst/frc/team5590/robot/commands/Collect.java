package org.usfirst.frc.team5590.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.*;

/**
 *
 */
public class Collect extends Command {
	
    public Collect() {
    	requires(Robot.collector);
    	// TODO: Timeout change based on tests
    	setTimeout(1.0);
    }

    protected void initialize() {
    	// TODO: Speed changed according to tests
    	Robot.collector.stopCollector();
    	Robot.collector.setCollectorSpeed(.0);
    }

    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collector.stopCollector();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.collector.stopCollector();
    }
}

package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoCollect extends Command {
	
	Button button;
	
    public AutoCollect() {
    	requires(Robot.collector);
    	// TODO: Timeout change based on tests
    	setTimeout(3.0);
    }

    protected void initialize() {
    	// TODO: Speed changed according to tests
    	Robot.collector.stopCollector();
    	Robot.collector.setCollectorSpeed(.0);
    }

    protected void execute() {
    	Robot.collector.setCollectorSpeed(1);
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

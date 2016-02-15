package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Collect extends Command {
	
	Button button;
	
    public Collect() {
    	requires(Robot.collector);
    }

    protected void initialize() {

    }

    protected void execute() {
    	Robot.collector.setCollectorSpeed(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
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

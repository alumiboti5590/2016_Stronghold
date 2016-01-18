package org.usfirst.frc.team5590.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.*;

/**
 *
 */
public class BallCollect extends Command {

    public BallCollect() {
    	requires(Robot.ballCollector);
    	// !!! TIMEOUT NEEDS TO BE CHANGED ACCORDING TO TESTS !!!
    	setTimeout(1.0);
    }

    protected void initialize() {
    	Robot.ballCollector.stop();
    	// !!! SPEED NEEDS TO BE CHANGED ACCORDING TO TESTS !!!
    	Robot.ballCollector.setSpeed(.2);
    }

    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ballCollector.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.ballCollector.stop();
    }
}

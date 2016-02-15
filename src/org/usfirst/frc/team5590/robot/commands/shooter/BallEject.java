package org.usfirst.frc.team5590.robot.commands.shooter;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallEject extends Command {

	private boolean isComplete = false;
	
    public BallEject() {
    	requires(Robot.shooter);
    	requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.stopShooter();
    	Robot.collector.stopCollector();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(timeSinceInitialized() < .1) {
    		Robot.shooter.setShooterSpeed(.1);
    		Robot.collector.setCollectorSpeed(.5);
    	}
    	while(timeSinceInitialized() < 3.1) {
    		Robot.collector.setCollectorSpeed(-1);
    	}
    	while(timeSinceInitialized() < 4.1) {
    		Robot.shooter.setShooterSpeed(-1);
    	}
    	isComplete = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isComplete;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.stopShooter();
    	Robot.collector.stopCollector();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

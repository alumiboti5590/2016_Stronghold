package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PassOff extends Command {

	private Button button;
	private boolean isComplete = false;
	
    public PassOff(Button button) {
    	requires(Robot.shooter);
    	requires(Robot.collector);
    	this.button = button;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.stopAll();
    	Robot.collector.stopCollector();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Spin up in the shoot
    	while (timeSinceInitialized() < 1) {
    		Robot.shooter.updateShooterRotation();
    		Robot.collector.setCollectorSpeed(.5);
    		Robot.shooter.collect(.3);
    	}
    	
    	Robot.shooter.stopAll();
    	Robot.collector.stopCollector();
    	// Prime up bottom
    	while (timeSinceInitialized() < 3) {
    		Robot.collector.setCollectorSpeed(-.5);
    	}
    	// Shoot this shit
    	while (timeSinceInitialized() < 4) { Robot.shooter.collect(-.7); }
    	
    	isComplete = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !this.button.get() || isComplete;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collector.stopCollector();
    	Robot.shooter.stopAll();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.collector.stopCollector();
    	Robot.shooter.stopAll();
    }
}

package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shoot extends Command {

	private Button button;
	private boolean isComplete = false;
	
    public Shoot(Button button) {
        requires(Robot.shooter);
        requires(Robot.collector);
        this.button = button;
    }

    protected void initialize() {
    	System.out.println("Initializing shoot ball");
    	Robot.shooter.stopShooter();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while (timeSinceInitialized() < 3.0) {
    		Robot.shooter.setShooterSpeed(1);
    	}
    	Robot.collector.setCollectorSpeed(1);
    	isComplete = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return !this.button.get() || isComplete;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Stopping shooter");
    	Robot.collector.stopCollector();
    	Robot.shooter.stopShooter();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.stopShooter();
    }
}

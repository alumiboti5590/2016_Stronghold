package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Collect extends Command {

	Button button;
	
    public Collect(Button button) {
    	requires(Robot.collector);
    	requires(Robot.shooter);
    	this.button = button;
    }

    protected void initialize() {
    	System.out.println("Starting Collector");
    	Robot.collector.stopCollector();
    }

    protected void execute() {
    	Robot.collector.setCollectorSpeed(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// If either switch was hit after command started or button lifted
    	if (!this.button.get()) {
    		System.out.print("Collector Button Released");
    	}
    	return !this.button.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("collector control ended");
    	Robot.collector.stopCollector();
    	double startTime = timeSinceInitialized();
    	// Slight set back to make sure not in shooter
    	while(timeSinceInitialized() - startTime < .05) {
    		Robot.shooter.setShooterSpeed(-.1);
    	}
    	Robot.shooter.stopShooter();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("Interrupted collector");
    	Robot.collector.stopCollector();
    }
}

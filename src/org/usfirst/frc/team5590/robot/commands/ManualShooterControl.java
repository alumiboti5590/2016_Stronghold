package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualShooterControl extends Command {

	private Button button;
	
    public ManualShooterControl(Button button) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooter);
        this.button = button;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.updateShooterRotation();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !this.button.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.stopAll();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.stopAll();
    }
}

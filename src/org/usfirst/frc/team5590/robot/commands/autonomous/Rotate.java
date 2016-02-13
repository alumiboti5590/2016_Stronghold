package org.usfirst.frc.team5590.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5590.robot.subsystems.*;
import org.usfirst.frc.team5590.robot.Robot;

/**
 *
 */
public class Rotate extends Command {
	
	public Drivetrain drivetrain  = Robot.drivetrain;
	
	private double degrees;

    public Rotate(double degrees) {
        requires(drivetrain);
        this.degrees = degrees;
        //TODO Find time for rotation per second
        double rotationPerSecond = .1;
        setTimeout(degrees*rotationPerSecond);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.stop();
    	drivetrain.rotateRight(.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drivetrain.stop();
    }
}

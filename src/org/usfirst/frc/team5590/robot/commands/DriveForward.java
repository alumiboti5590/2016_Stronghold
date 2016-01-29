package org.usfirst.frc.team5590.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5590.robot.subsystems.*;
import org.usfirst.frc.team5590.robot.Robot;

/**
 *
 */
public class DriveForward extends Command {
	
	public Drivetrain drivetrain = Robot.drivetrain;

    public DriveForward() {
    	requires(drivetrain);
        //TODO Set a time out
        setTimeout(1.0);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.stop();
    	System.out.println("Driving Forward");
    	drivetrain.setSpeed(.7);
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
    }
}

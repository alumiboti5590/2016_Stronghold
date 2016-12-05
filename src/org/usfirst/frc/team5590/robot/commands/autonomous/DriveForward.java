package org.usfirst.frc.team5590.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5590.robot.subsystems.*;
import org.usfirst.frc.team5590.robot.Robot;

/**
 *
 */
public class DriveForward extends Command {
	
	public Drivetrain drivetrain = Robot.drivetrain;
	private double speed;
	private double time;

    public DriveForward(double speed, double time) {
    	requires(drivetrain);
    	this.speed=speed;
    	this.time=time;
        //TODO Set a time out
        setTimeout(this.time);
    }

    // Called just before this Command runs the first time
    // cackerman
    protected void initialize() {
    	drivetrain.stop();
    	System.out.println("Driving Forward");
    	drivetrain.setSpeed(this.speed);
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

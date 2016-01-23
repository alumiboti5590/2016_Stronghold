package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/** This command sets the speed of both speed controllers to 0.6
 * To make make both tracks drive the robot forward
 */
public class Drive extends Command {
	
	private Drivetrain drivetrain = Robot.drivetrain;

    public Drive() {
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.updateSpeed();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

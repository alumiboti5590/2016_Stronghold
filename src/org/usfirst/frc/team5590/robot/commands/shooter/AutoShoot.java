package org.usfirst.frc.team5590.robot.commands.shooter;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoShoot extends Command {
	
    public AutoShoot() {
        requires(Robot.shooter);
        setTimeout(15.0);
    }

    protected void initialize() {
    	System.out.println("Shooting Ball");
    	Robot.shooter.stopShooter();
    	//TODO Speed Changed according to tests
    	Robot.shooter.setShooterSpeed(.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.setShooterSpeed(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.stopShooter();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//Robot.shooter.stopShooter();
    }
}

package org.usfirst.frc.team5590.robot.commands.shooter;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.Shooter.Position;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterUp extends Command {

	public ShooterUp() {
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Position position = Robot.shooter.getPosition();
    	if (position == Position.DOWN) {
    		System.out.println("Shooter Moving to 45 degrees");
    		new ShooterDeploy().start();
    	} else if (position == Position.SHOOT) {
    		System.out.println("Shooter moving to 90 degrees");
    		new ShooterEvade().start();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

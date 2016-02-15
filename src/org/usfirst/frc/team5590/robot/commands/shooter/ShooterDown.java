package org.usfirst.frc.team5590.robot.commands.shooter;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.Shooter.Position;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterDown extends Command {

    public ShooterDown() {
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Position position = Robot.shooter.getPosition();
    	if (position == Position.SHOOT) {
    		System.out.println("Shooter Moving to 0 degrees");
    		new ShooterRetract().start();
    	} else if (position == Position.EVADE) {
    		System.out.println("Shooter moving to 45 degrees");
    		new ShooterDeploy().start();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

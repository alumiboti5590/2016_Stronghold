package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shoot extends Command {

	private Button button;
	
    public Shoot(Button button) {
        requires(Robot.shooter);
        setTimeout(1.0);
        this.button = button;
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
    	if (isTimedOut() || !button.get()) {
    		return true;
    	}
        return false;
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

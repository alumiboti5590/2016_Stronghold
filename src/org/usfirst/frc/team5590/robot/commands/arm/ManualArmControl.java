package org.usfirst.frc.team5590.robot.commands.arm;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualArmControl extends Command {

    public ManualArmControl() {
    	requires(Robot.arm);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.arm.updateRotation();
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
    	System.out.println("Manual Control Interupted");
    }
}

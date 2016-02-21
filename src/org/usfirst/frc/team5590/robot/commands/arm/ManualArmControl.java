package org.usfirst.frc.team5590.robot.commands.arm;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualArmControl extends Command {

	private Button button;
	
    public ManualArmControl(Button button) {
    	requires(Robot.arm);
    	this.button = button;
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.arm.updateRotation();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !this.button.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.stopArm();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("Manual Control Interupted");
    	Robot.arm.stopArm();
    }
}

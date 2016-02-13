package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.commands.arm.ArmOpenGate;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TriggerCommands extends Command {
	
	private Shoot shootCommand;
	private ArmOpenGate openGate;
	private Button button;

    public TriggerCommands(Button button) {
    	shootCommand = new Shoot(button);
    	openGate = new ArmOpenGate();
    }

    protected void initialize() {
    	if (Robot.oi.shooterMode) {
    		System.out.println("Running: Shoot");
    		shootCommand.start();
    	} else {
    		System.out.println("Running Arm");
    		openGate.start();
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
